package com.hack.graduation_project_system.service.impl;

import com.hack.graduation_project_system.dao.ProgressMapper;
import com.hack.graduation_project_system.dao.ProjectMapper;
import com.hack.graduation_project_system.dao.StudentMapper;
import com.hack.graduation_project_system.domain.*;
import com.hack.graduation_project_system.service.ProgressService;
import com.hack.graduation_project_system.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressMapper progressMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public int addProgress(Progress progress) {
        Student student = studentMapper.selectByPrimaryKey(progress.getStudentid());
        student.setProjectid(progress.getProjectid());
        studentMapper.updateByPrimaryKey(student);

        Project project = projectMapper.selectByPrimaryKey(progress.getProjectid());
        project.setChoose(true);
        projectMapper.updateByPrimaryKey(project);

        return progressMapper.insert(progress);
    }

    @Override
    public int deleteProgress(Progress progress) {
        ProgressKey progressKey = new ProgressKey(progress.getStudentid(), progress.getProjectid());
        return progressMapper.deleteByPrimaryKey(progressKey);
    }

    @Override
    public int updateProgress(Progress progress) {
        Student student = studentMapper.selectByPrimaryKey(progress.getStudentid());
        student.setProjectid(progress.getProjectid());
        studentMapper.updateByPrimaryKey(student);

        Project project = projectMapper.selectByPrimaryKey(progress.getProjectid());
        project.setChoose(true);
        projectMapper.updateByPrimaryKey(project);

        return progressMapper.updateByPrimaryKey(progress);
    }

    @Override
    public Progress getProgressByStudentId(Integer studentId) {
        ProgressExample progressExample = new ProgressExample();
        ProgressExample.Criteria criteria = progressExample.createCriteria();
        if (studentId != null) {
            criteria.andStudentidEqualTo(studentId);
        }
        return progressMapper.selectByExample(progressExample).get(0);
    }

    @Override
    public List<Progress> getProgressByClassId(String classId) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
        if (StringUtils.isNotBlank(classId)) {
            studentExampleCriteria.andClassidEqualTo(classId);
        }
        List<Student> studentList = studentMapper.selectByExample(studentExample);

        List<Progress> progressList = new ArrayList<>();
        for (Student student :  studentList) {
            progressList.add(getProgressByStudentId(student.getStudentid()));
        }
        return progressList;
    }

    @Override
    public Progress getProgressByProjectId(Integer projectId) {
        ProgressExample progressExample = new ProgressExample();
        ProgressExample.Criteria criteria = progressExample.createCriteria();
        criteria.andProjectidEqualTo(projectId);
        return progressMapper.selectByExample(progressExample).get(0);
    }


}
