package com.hack.graduation_project_system.service.impl;

import com.hack.graduation_project_system.dao.ClassMapper;
import com.hack.graduation_project_system.dao.StudentMapper;
import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.ClassExample;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.domain.StudentExample;
import com.hack.graduation_project_system.service.ClassService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addClass(Class c) {
        return classMapper.insert(c);
    }

    @Override
    public int deleteClass(Class c) {
        return classMapper.deleteByPrimaryKey(c.getClassid());
    }

    @Override
    public int updateClass(Class c) {
        return classMapper.updateByPrimaryKey(c);
    }

    @Override
    public Class getClassById(String classid) {
        return classMapper.selectByPrimaryKey(classid);
    }

    @Override
    public List<Class> getAllClass() {
        ClassExample classExample = new ClassExample();
        List<Class> classList = classMapper.selectByExample(classExample);
        return classList;
    }

    @Override
    public List<Student> getStudent(Class c) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (StringUtils.isNotBlank(c.getClassid())) {
            criteria.andClassidEqualTo(c.getClassid());
        }
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        return studentList;
    }
}
