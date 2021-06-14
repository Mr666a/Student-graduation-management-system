package com.hack.graduation_project_system.service;

import com.hack.graduation_project_system.domain.Major;

import java.util.List;

public interface MajorService {

    public int addMajor(Major major);

    public int deleteMajor(Major major);

    public int updateMajor(Major major);

    public List<Major> getAllMajor();

    public Major getMajorById(String majorid);
}
