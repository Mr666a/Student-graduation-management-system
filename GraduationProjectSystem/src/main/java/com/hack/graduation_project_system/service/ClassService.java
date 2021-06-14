package com.hack.graduation_project_system.service;

import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.Progress;
import com.hack.graduation_project_system.domain.Student;

import java.util.List;

public interface ClassService {
    public int addClass(Class c);

    public int deleteClass(Class c);

    public int updateClass(Class c);

    public Class getClassById(String classid);

    public List<Class> getAllClass();

    public List<Student> getStudent(Class c);

}
