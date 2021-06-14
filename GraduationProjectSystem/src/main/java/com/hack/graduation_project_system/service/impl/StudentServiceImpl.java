package com.hack.graduation_project_system.service.impl;

import com.hack.graduation_project_system.dao.ClassMapper;
import com.hack.graduation_project_system.dao.MajorMapper;
import com.hack.graduation_project_system.dao.ProjectMapper;
import com.hack.graduation_project_system.dao.StudentMapper;
import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.StudentExample;
import com.hack.graduation_project_system.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ClassMapper classMapper;

    @Override
    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int deleteStudent(Student student) {
        return studentMapper.deleteByPrimaryKey(student.getStudentid());
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public Student getStudentById(Integer studentid) {
        return studentMapper.selectByPrimaryKey(studentid);
    }

    @Override
    public List<Student> getAllStudent() {
        StudentExample studentExample = new StudentExample();
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        return studentList;
    }

    @Override
    public List<Student> getAllStudentByClassId(String classid) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (StringUtils.isNotBlank(classid)) {
            criteria.andClassidEqualTo(classid);
            List<Student> studentList = studentMapper.selectByExample(studentExample);
            return studentList;
        }
        return null;
    }

    @Override
    public Major getMajor(Student student) {
        if (StringUtils.isNotBlank(student.getMajorid())) {
            return majorMapper.selectByPrimaryKey(student.getMajorid());
        }
        return null;
    }

    @Override
    public Project getProject(Student student) {
        if (student.getProjectid() != null) {
            return projectMapper.selectByPrimaryKey(student.getProjectid());
        }
        return null;
    }

    @Override
    public Class getClass(Student student) {

        if (StringUtils.isNotBlank(student.getClassid())) {
            return classMapper.selectByPrimaryKey(student.getClassid());
        }
        return null;
    }


}
