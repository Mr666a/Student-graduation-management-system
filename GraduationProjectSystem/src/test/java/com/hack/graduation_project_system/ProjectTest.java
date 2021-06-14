package com.hack.graduation_project_system;


import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.Teacher;
import com.hack.graduation_project_system.service.ProjectService;
import com.hack.graduation_project_system.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class ProjectTest {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ProjectService projectService;

    @Test
    public void addProject() {
        Project project = new Project();
        project.setProjectid(1);
        project.setProjectname("软件工程1");
        Teacher teacher = teacherService.getTeacherById(1000);
        String sid = "teacher_" + teacher.getTeacherid();
        project.setSubmitid(sid);
        project.setStatus(false);
        project.setChoose(false);
        project.setSpecialproject(false);
        Date date = new Date();
        project.setTime(date);
        project.setContentfilename("test.html");
        projectService.addProject(project);
    }


    @Test
    public void updateProject() {
        Project project = projectService.getProjectById(1);
        System.out.println(project);
        project.setChoose(true);
        projectService.updateProject(project);
    }
}
