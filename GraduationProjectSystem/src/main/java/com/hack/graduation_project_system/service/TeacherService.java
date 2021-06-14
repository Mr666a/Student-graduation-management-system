package com.hack.graduation_project_system.service;

import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.Teacher;

import java.util.List;

public interface TeacherService {
    public int addTeacher(Teacher teacher);

    public int deleteTeacher(Teacher teacher);

    public int updateTeacher(Teacher teacher);

    public Teacher getTeacherById(Integer teacherid);

    public List<Teacher> getAllTeacher();

    public List<Teacher> getAllTeacherByMajorId(String majorId);

    public Major getMajor(Teacher teacher);

    public Class getClass(Teacher teacher);

    public String getNameById(int id);
}
