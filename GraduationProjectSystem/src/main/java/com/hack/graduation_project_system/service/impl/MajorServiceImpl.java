package com.hack.graduation_project_system.service.impl;

import com.hack.graduation_project_system.dao.MajorMapper;
import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.domain.MajorExample;
import com.hack.graduation_project_system.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("majorService")
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public int addMajor(Major major) {
        return majorMapper.insert(major);
    }

    @Override
    public int deleteMajor(Major major) {
        return majorMapper.deleteByPrimaryKey(major.getMajorid());
    }

    @Override
    public int updateMajor(Major major) {
        return majorMapper.updateByPrimaryKey(major);
    }

    @Override
    public List<Major> getAllMajor() {
        MajorExample majorExample = new MajorExample();
        List<Major> majorList = majorMapper.selectByExample(majorExample);
        return majorList;
    }

    @Override
    public Major getMajorById(String majorid) {
        return majorMapper.selectByPrimaryKey(majorid);
    }
}
