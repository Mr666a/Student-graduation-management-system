package com.hack.graduation_project_system.controller;

import com.hack.graduation_project_system.domain.Leader;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.domain.Teacher;
import com.hack.graduation_project_system.service.LeaderService;
import com.hack.graduation_project_system.service.StudentService;
import com.hack.graduation_project_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SystemController {

    private StudentService studentService;
    private LeaderService leaderService;
    private TeacherService teacherService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setLeaderService(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("/")
    public String welcome(){
        return "page-login";
    }

    /**
     * 根据学号登录
     * @param sid
     * @param password
     * @return
     */
    @ResponseBody
    @PostMapping("/sid_login")
    public Collection<String> sidLogin(@RequestParam(value = "sid") Integer sid,
                               @RequestParam(value = "password") String password,
                               HttpServletRequest request){
        Student student = studentService.getStudentById(sid);
        HttpSession httpSession = request.getSession();
        //存放返回状态
        Map<Integer, String> result = new HashMap<>();
        //如果账号存在
        if (student != null){
            System.out.println("学号：" + sid + "请求登录！");
            if (password.trim().equals(student.getPassword())){
                System.out.println("登录成功!");
                httpSession.setAttribute("stu", student);
                result.put(200, "success");
                return result.values();
            }else{
                result.put(202, "errorPwd");
                return result.values();
            }
        }
        result.put(201, "noExist");
        return result.values();
    }

    /**
     * 根据工号登录
     * 登录逻辑,先去admin找，找不到找teacher
     * @param sid
     * @param password
     * @return
     */
    @ResponseBody
    @PostMapping("/eid_login")
    public Collection<String> eidLogin(@RequestParam(value = "sid") Integer sid,
                           @RequestParam(value = "password") String password,
                           HttpServletRequest request){
        //存放返回状态
        Map<Integer, String> result = new HashMap<>();

        //管理员账号登录
        Leader leader = leaderService.getLeaderById(sid);
        if (leader != null){
            System.out.println("工号：" + sid + "请求登录！");
            //验证管理员密码
            if (password.trim().equals(leader.getPassword())){
                System.out.println("密码输入正确");
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("leader", leader);
                result.put(300, "successL");
                return result.values();
            }else {
                result.put(202, "errorPwd");
                return result.values();
            }
        }

        Teacher teacher = teacherService.getTeacherById(sid);
        //教师账号登录
        if (teacher != null){
            //验证管理员密码
            if (password.trim().equals(teacher.getPassword())){
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("teacher", teacher);
                result.put(400, "successT");
                return result.values();
            }else {
                result.put(202, "errorPwd");
                return result.values();
            }
        }

        result.put(201, "noExist");
        return result.values();
    }


    /**
     * 跳转index主页Controller
     */

    @RequestMapping("/stuIndex")
    public String stuIndex(){
        return "student/student_index";
    }

    @RequestMapping("/adminIndex")
    public String adminIndex(){
        return "admin/admin_index";
    }
    @RequestMapping("/teachIndex")
    public String teachIndex(){
        return "teacher/teacher_index";
    }

    @RequestMapping("/testIn")
    public String testIn(){

        return "test1";
    }

    @ResponseBody
    @PostMapping("/testOut")
    public String test(@RequestParam(value = "sid") Integer sid,
                       @RequestParam(value = "password") String password){

        return "successfully"+sid+password;
    }

    @RequestMapping("/logOut/{type}")
    public String logOut(HttpServletRequest request, @PathVariable("type") Integer type){
        HttpSession httpSession = request.getSession();
        switch(type){
            case 1: httpSession.setAttribute("stu", null);break;
            case 2: httpSession.setAttribute("teacher", null);break;
            case 3: httpSession.setAttribute("leader", null);break;
        }
        System.out.println("退出成功！");
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping("/findPassword")
    public String findPassword(@RequestParam(value = "sid") String sid,
                               @RequestParam(value = "id") String id){
        Student student = studentService.getStudentById(Integer.parseInt(sid.trim()));
        if (student!=null){
            String did = student.getId();
            boolean isOk = did.endsWith(id.trim());
            if (isOk){
                return "Ok";
            }else {
                return "No";
            }
        }else {
            return "Error";
        }


    }

    @ResponseBody
    @RequestMapping("/changePassword")
    public String changePassword(@RequestParam(value = "mid") String sid,
                                 @RequestParam(value = "newPwd") String newPwd){
        Student student = studentService.getStudentById(Integer.parseInt(sid));
        student.setPassword(newPwd);
        studentService.updateStudent(student);
        return "true";
    }

    @RequestMapping("/showChangePwd")
    public String showChangePwd(){
        return "page-changePwd";
    }

    @ResponseBody
    @RequestMapping("/chagePwd/{type}")
    public String changePwd(@PathVariable("type") Integer type,
                            HttpServletRequest request,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "newPassword") String newPassword){
            HttpSession httpSession = request.getSession();
            String result = "";
            String sPwd = null;
            switch (type){
                case 1:{
                    Student student = (Student) httpSession.getAttribute("stu");
                    sPwd = student.getPassword();
                }break;
                case 2:{
                    Teacher teacher = (Teacher) httpSession.getAttribute("teacher");
                    sPwd = teacher.getPassword();
                }break;
                case 3:{
                    Leader leader = (Leader) httpSession.getAttribute("leader");
                    sPwd = leader.getPassword();
                }break;
            }
            if(sPwd.equals(password.trim())){
                result = "success";
            }else {
                result = "error";
            }
            return result;
    }



}
