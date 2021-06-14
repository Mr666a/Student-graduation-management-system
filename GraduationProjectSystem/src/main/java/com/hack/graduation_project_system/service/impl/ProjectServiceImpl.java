package com.hack.graduation_project_system.service.impl;

import com.hack.graduation_project_system.Utils.DateUtils;
import com.hack.graduation_project_system.dao.ProjectMapper;
import com.hack.graduation_project_system.dao.StudentMapper;
import com.hack.graduation_project_system.domain.*;
import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addProject(Project project) {
        return projectMapper.insert(project);
    }

    @Override
    public int deleteProject(Project project) {
        return projectMapper.deleteByPrimaryKey(project.getProjectid());
    }

    @Override
    public int updateProject(Project project) {
        return projectMapper.updateByPrimaryKey(project);
    }

    @Override
    public Project getProjectById(Integer projectid) {
        return projectMapper.selectByPrimaryKey(projectid);
    }

    @Override
    public List<Project> getAllProject() {
        ProjectExample projectExample = new ProjectExample();
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public List<Project> getProjectByTime(Date time) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        if (time != null) {
            criteria.andTimeGreaterThanOrEqualTo(time);

            int nextYear = time.getYear() + 1901;
            Date nextYearStartTime = new Date(DateUtils.getYearStartTime(DateUtils.getYearTimeStamp(String.valueOf(nextYear))));
            criteria.andTimeLessThan(nextYearStartTime);
        }
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public List<Project> getProjectByKeywords(String keywords) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectnameLike('%' + keywords + '%');
        return projectMapper.selectByExample(projectExample);
    }

    //修改方法
    @Override
    public List<Project> getTeacherProjectListBySubmitId(String submitId) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        if (StringUtils.isNotBlank(submitId)) {
            criteria.andSubmitidEqualTo(submitId);
            return projectMapper.selectByExample(projectExample);
        }
        return null;
    }

    @Override
    public List<HashMap<Student, Project>> getProjectListByClassId(Class c) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (StringUtils.isNotBlank(c.getClassid())) {
            criteria.andClassidEqualTo(c.getClassid());
        }
        List<Student> studentList = studentMapper.selectByExample(studentExample);

        List list = new ArrayList();
        for (Student student : studentList) {
            Map<Student, Project> map = new HashMap<>();
            map.put(student, projectMapper.selectByPrimaryKey(student.getProjectid()));
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Project> getSpecialProject() {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andSpecialprojectIsNotNull();
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public List<Project> getNotStatusProject() {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andStatusIsNull();
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public boolean isSpecialProject(Project project) {
        return project.getSpecialproject();
    }

    @Override
    public boolean getChoose(Project project) {
        return project.getChoose();
    }

    @Override
    public boolean isStatus(Project project) {
        return project.getStatus();
    }


    /**
     * v 0.0.1.201215
     * @Author hgl
     * 新增内容：未被学生选择的毕业课题获取
     */
    public List<Project> getNotChoiceProjects(){
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andChooseEqualTo(false);
        return projectMapper.selectByExample(projectExample);
    }


    public List<Project> getProjectsBySubmitId(Integer id) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andSubmitidEqualTo(id.toString());
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public Project getProjectByFilenameAndSubmitId(String filename, String submitId) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        if (StringUtils.isNotBlank(filename)) {
            criteria.andProjectnameEqualTo(filename);
        }
        if (StringUtils.isNotBlank(submitId)) {
            criteria.andSubmitidEqualTo(submitId);
        }
        Project project = null;
        project = projectMapper.selectByExample(projectExample).get(0);
        return project;
    }


}
