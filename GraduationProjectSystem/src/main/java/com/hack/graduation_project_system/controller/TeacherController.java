package com.hack.graduation_project_system.controller;

import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.Leader;
import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.Teacher;
import com.hack.graduation_project_system.pojo.TeacherInfo;
import com.hack.graduation_project_system.service.ClassService;
import com.hack.graduation_project_system.service.MajorService;
import com.hack.graduation_project_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private ClassService classService;
    private TeacherInfo teacherInfo;
    private TeacherService teacherService;
    private MajorService majorService;
    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
    @Autowired
    public void setTeacherInfo(TeacherInfo teacherInfo){
        this.teacherInfo = teacherInfo;
    }
    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    @ResponseBody
    @RequestMapping("/getTeachers")
    public Collection<TeacherInfo> getTeachers(){
        Map<Integer, TeacherInfo> result = new HashMap<>();
        List<Teacher> teachers = teacherService.getAllTeacher();
        int i = 0;
        for (Teacher teacher : teachers){
            TeacherInfo tInfo = new TeacherInfo();
            String majorName = majorService.getMajorById(teacher.getMajorid()).getMajorname();
            System.out.println(teacher.getTeachername());
            tInfo.setTeacherId(teacher.getTeacherid().toString());
            tInfo.setMajorName(majorName);
            tInfo.setTeacherName(teacher.getTeachername());
            result.put(i, tInfo);
            i++;
        }

        return result.values();
    }
    @GetMapping("/addTeacher")
    public ModelAndView addTeacher(HttpServletRequest request) {
        String viewName = "teacher/add_teacher_form";
        ModelAndView modelAndView = new ModelAndView(viewName);
        List<Major> majorList = majorService.getAllMajor();
        modelAndView.addObject("majorList", majorList);
        return modelAndView;
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@RequestParam("teacherid") String teacherid, @RequestParam("teachername") String teachername,
                             @RequestParam("password") String password, @RequestParam("gender") String gender,
                             @RequestParam("phone") String phone, @RequestParam("classid") String classid,
                             @RequestParam("classname") String classname, @RequestParam("majorid") String majorid) {
        //新增班级
        Class c = new Class();
        c.setClassid(classid);
        c.setClassname(classname);
        classService.addClass(c);

        //新增教师
        Teacher teacher = new Teacher();
        teacher.setTeacherid(Integer.parseInt(teacherid));
        teacher.setTeachername(teachername);
        teacher.setGender(gender);
        if (!phone.trim().equals("")) {
            teacher.setPhone(phone);
        }

        teacher.setClassid(classid);
        teacher.setMajorid(majorid);
        teacher.setPassword(password);
        teacherService.addTeacher(teacher);

        return "redirect:/teacher/getTeacherInfoByMajor";
    }


    @GetMapping("/getTeacherInfo")
    public ModelAndView getTeacherInfo(@RequestParam("id") String id) {
        String viewName = "teacher/teacher_info";
        ModelAndView modelAndView = new ModelAndView(viewName);
        return modelAndView;
    }

    @GetMapping("/getTeacherInfoByMajor")
    public ModelAndView getTeacherInfoByMajor(HttpServletRequest request) {
        String viewName = "teacher/teacher_info_major";
        ModelAndView modelAndView = new ModelAndView(viewName);
        HttpSession session = request.getSession();
        String majorId = ((Leader) session.getAttribute("leader")).getMajorid();

        List datas = new ArrayList();

        //根据专业负责人的专业，获取本专业的下所有的教师id
        List<Teacher> teacherList = teacherService.getAllTeacherByMajorId(majorId);
        for (Teacher teacher: teacherList) {
            Major major = teacherService.getMajor(teacher);
            Class c = classService.getClassById(teacher.getClassid());
            Map<String, Object> map = new HashMap<>();
            map.put("teacher", teacher);
            map.put("class", c);
            map.put("major", major);
            datas.add(map);
        }
        modelAndView.addObject("datas", datas);
        return modelAndView;
    }

}
