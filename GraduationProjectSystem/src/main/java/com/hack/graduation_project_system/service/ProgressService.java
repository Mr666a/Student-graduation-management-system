package com.hack.graduation_project_system.service;

import com.hack.graduation_project_system.domain.Progress;

import java.util.List;

public interface ProgressService {
    public int addProgress(Progress progress);

    public int deleteProgress(Progress progress);

    public int updateProgress(Progress progress);

    public Progress getProgressByStudentId(Integer studentId);

    public List<Progress> getProgressByClassId(String classId);

    public Progress getProgressByProjectId(Integer projectId);
}
