package com.hack.graduation_project_system.service;

import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ProjectService {
    public int addProject(Project project);

    public int deleteProject(Project project);

    public int updateProject(Project project);

    public Project getProjectById(Integer projectid);

    public List<Project> getAllProject();

    //根据时间查询题库
    public List<Project> getProjectByTime(Date time);

    //根据关键字查询题库
    public List<Project> getProjectByKeywords(String keywords);

    //查看教师题库
    public List<Project> getTeacherProjectListBySubmitId(String submitId);

    //班级学生题目
    public List<HashMap<Student, Project>> getProjectListByClassId(Class c);

    //特殊选课列表
    public List<Project> getSpecialProject();

    //未审核课题
    public List<Project> getNotStatusProject();

    //是否是特殊选题
    public boolean isSpecialProject(Project project);

    //是否被选择
    public boolean getChoose(Project project);

    //是否被审核
    public boolean isStatus(Project project);

    public List<Project> getNotChoiceProjects();

    public List<Project> getProjectsBySubmitId(Integer id);

    //根据文件名与提交人工号获取Project
    public Project getProjectByFilenameAndSubmitId(String filename, String submitId);
}
