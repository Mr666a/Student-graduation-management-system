package com.hack.graduation_project_system.controller;

import com.hack.graduation_project_system.Utils.FileOperation;
import com.hack.graduation_project_system.domain.Leader;
import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.pojo.ProgressInfo;
import com.hack.graduation_project_system.pojo.StudentInfo;
import com.hack.graduation_project_system.service.LeaderService;
import com.hack.graduation_project_system.service.MajorService;
import com.hack.graduation_project_system.service.ProjectService;
import com.hack.graduation_project_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StudentController {

    private StudentInfo studentInfo;
    private StudentService studentService;
    private ProjectService projectService;
    private MajorService majorService;
    private LeaderService leaderService;

    @Autowired
    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    @Autowired
    public void setProjectService(ProjectService projectService){
        this.projectService = projectService;
    }
    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    @Autowired
    public void setLeaderService(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    //学生信息页面
    @RequestMapping("/info")
    public String stuInfo(){
        return "student/student_info";
    }


    //获取学生信息页面
    @ResponseBody
    @PostMapping("/getInfo")
    public Collection<StudentInfo> getInfo(HttpServletRequest request){
        Map<String, StudentInfo> stuInfo = new HashMap<>();
        HttpSession httpSession = request.getSession();
        Student student = (Student) httpSession.getAttribute("stu");
        //获取学生专业信息
        Major major = majorService.getMajorById(student.getMajorid());
        Leader leader = leaderService.getLeaderById(major.getLeaderid());
        studentInfo.setId(student.getStudentid().toString());
        studentInfo.setName(student.getStudentname());
        studentInfo.setCid(student.getId());
        studentInfo.setPhone(student.getPhone());
        studentInfo.setGrade(student.getGrade().toString());
        studentInfo.setEmail(student.getEmail());
        studentInfo.setOver(student.getGraduationdate().toString());
        studentInfo.setMajor(major.getMajorname());
        studentInfo.setLeader(leader.getLeadername());
        studentInfo.setDepartment("软件工程系");
        studentInfo.setAdminClass("20级软件工程1班");
        stuInfo.put("student", studentInfo);
        return stuInfo.values();

    }
    @RequestMapping("/showMyPj")
    public ModelAndView showMyProject(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("stu");
        if (student.getProjectid() != null){
            mv.setViewName("/project/show-stu-project");
            mv.addObject("id", student.getProjectid());
            return mv;
        }else{
            mv.setViewName("/error/noExistError");
            return mv;
        }

    }


    @RequestMapping("/showProcess")
    public String showProcess(HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("stu");
        if (student.getProjectid()!=null){
            return "/project/project-manager";
        }else {
            return "/error/noExistError";
        }
    }

    @ResponseBody
    @RequestMapping("/getProcess")
    public Collection<ProgressInfo> getProcess(HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String, ProgressInfo> pgInfos = new HashMap<>();
        Student student = (Student) session.getAttribute("stu");
        Project project = projectService.getProjectById(student.getProjectid());
        String projectName = project.getProjectname();
        String progressFile = projectName;
        ProgressInfo progressInfo = FileOperation.readFile(progressFile);
        pgInfos.put("progressInfo", progressInfo);
        return pgInfos.values();
    }
}
