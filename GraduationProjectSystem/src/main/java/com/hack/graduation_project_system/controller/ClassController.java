package com.hack.graduation_project_system.controller;

import com.hack.graduation_project_system.domain.*;
import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/class")
public class ClassController {

    private ClassService classService;
    private TeacherService teacherService;
    private StudentService studentService;
    private MajorService majorService;
    private ProjectService projectService;

    @Autowired
    public void setClassService(ClassService classService){
        this.classService = classService;
    }
    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/getClassInfo")
    public ModelAndView getClassInfo(HttpServletRequest request) {
        String viewName = "class/class_table";
        ModelAndView modelAndView = new ModelAndView(viewName);
        HttpSession session = request.getSession();
        Class c = (Class)teacherService.getClass((Teacher)session.getAttribute("teacher"));

        List<Student> students = studentService.getAllStudentByClassId(c.getClassid());

        List<Map<String, Object>> datas = new ArrayList<>();
        for (Student student : students) {
            Map<String, Object> data = new HashMap();
            Major major = majorService.getMajorById(student.getMajorid());
            Project project = projectService.getProjectById(student.getProjectid());
            data.put("student", student);
            data.put("major", major);
            data.put("project", project);
            datas.add(data);
        }

        modelAndView.addObject("datas", datas);
        modelAndView.addObject("class", c);
        return modelAndView;
    }

    @GetMapping("/getAllClassInfoByMajor")
    public ModelAndView AllClassInfoByMajor(HttpServletRequest request) {
        String viewName = "class/class_table_major";
        ModelAndView modelAndView = new ModelAndView(viewName);
        HttpSession session = request.getSession();
        String majorId = ((Leader) session.getAttribute("leader")).getMajorid();
        List<Map<String, Object>> datas = new ArrayList<>();

        //根据专业负责人的专业，获取本专业的下所有的教师id
        List<Teacher> teacherList = teacherService.getAllTeacherByMajorId(majorId);
        for (Teacher teacher : teacherList) {
            Class c = (Class)teacherService.getClass(teacher);

            List<Student> students =  studentService.getAllStudentByClassId(c.getClassid());
            for (Student student : students) {
                Map<String, Object> data = new HashMap();
                Major major = majorService.getMajorById(student.getMajorid());
                Project project = projectService.getProjectById(student.getProjectid());
                data.put("student", student);
                data.put("major", major);
                data.put("project", project);
                data.put("class", c);
                data.put("teacher", teacher);
                datas.add(data);
            }
        }

        modelAndView.addObject("datas", datas);
        return modelAndView;
    }

}
