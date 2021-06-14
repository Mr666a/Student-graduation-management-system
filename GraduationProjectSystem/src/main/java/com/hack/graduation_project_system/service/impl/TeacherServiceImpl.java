package com.hack.graduation_project_system.service.impl;

import com.hack.graduation_project_system.dao.ClassMapper;
import com.hack.graduation_project_system.dao.MajorMapper;
import com.hack.graduation_project_system.dao.TeacherMapper;
import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.Teacher;
import com.hack.graduation_project_system.domain.TeacherExample;
import com.hack.graduation_project_system.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int deleteTeacher(Teacher teacher) {
        return teacherMapper.deleteByPrimaryKey(teacher.getTeacherid());
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public Teacher getTeacherById(Integer teacherid) {
        return teacherMapper.selectByPrimaryKey(teacherid);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        TeacherExample teacherExample = new TeacherExample();
        return teacherMapper.selectByExample(teacherExample);
    }

    @Override
    public List<Teacher> getAllTeacherByMajorId(String majorId) {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        if(StringUtils.isNotBlank(majorId)) {
            return teacherMapper.selectByExample(teacherExample);
        }
        return null;
    }

    @Override
    public Major getMajor(Teacher teacher) {
        return majorMapper.selectByPrimaryKey(teacher.getMajorid());
    }

    @Override
    public Class getClass(Teacher teacher) {
        return classMapper.selectByPrimaryKey(teacher.getClassid());
    }
    public String getNameById(int id){
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        return teacher.getTeachername();
    }
}
