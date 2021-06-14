package com.hack.graduation_project_system.service;

import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.domain.Class;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public int addStudent(Student student);

    public int deleteStudent(Student student);

    public int updateStudent(Student student);

    public Student getStudentById(Integer studentid);

    public List<Student> getAllStudent();

    public List<Student> getAllStudentByClassId(String classid);

    public Major getMajor(Student student);

    public Project getProject(Student student);

    public Class getClass(Student student);

}
