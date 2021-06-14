package com.hack.graduation_project_system;

import com.hack.graduation_project_system.domain.Progress;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.service.ProgressService;
import com.hack.graduation_project_system.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class ProgressTest {
    @Autowired
    private ProgressService progressService;

    @Autowired
    private StudentService studentService;

    @Test
    public void addProgress() {
        Progress progress = new Progress();
        progress.setStudentid(2000103);
        progress.setProjectid(1);
        progressService.addProgress(progress);
    }
}
