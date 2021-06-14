package com.hack.graduation_project_system;

import com.hack.graduation_project_system.dao.StudentMapper;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class StudentTest {

    @Autowired
    public StudentService studentService;

    @Test
    public void addStudentTest(){
        Student student = new Student();
        student.setStudentname("李四");
        student.setPassword("123456");
        student.setGender("男");
        student.setMajorid("M02");

        studentService.addStudent(student);
    }

    @Test
    public void updateStudentTest() {
        Student student = studentService.getStudentById(3);
        student.setClassid("T01");
        studentService.updateStudent(student);

        student = studentService.getStudentById(4);
        student.setClassid("T02");
        studentService.updateStudent(student);

    }

    @Test
    public void StudentTest() {
//        Student student = studentService.getStudentById(3);
//        System.out.println(student.getStudentname());
//        System.out.println(student.getClassid());

        List<Student> list = studentService.getAllStudentByClassId("T01");

        for (Student s : list) {
            System.out.println(s.getStudentname());
        }
    }
}
