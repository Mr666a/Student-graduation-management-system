package com.hack.graduation_project_system.service.impl;

import com.hack.graduation_project_system.dao.LeaderMapper;
import com.hack.graduation_project_system.domain.Leader;
import com.hack.graduation_project_system.domain.LeaderExample;
import com.hack.graduation_project_system.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderMapper leaderMapper;

    @Override
    public int addLeader(Leader leader) {
        return leaderMapper.insert(leader);
    }

    @Override
    public int deleteLeader(Leader leader) {
        return leaderMapper.deleteByPrimaryKey(leader.getLeaderid());
    }

    @Override
    public int updateLeader(Leader leader) {
        return leaderMapper.updateByPrimaryKey(leader);
    }

    @Override
    public Leader getLeaderById(Integer leaderId) {
        return leaderMapper.selectByPrimaryKey(leaderId);
    }

    @Override
    public List<Leader> getAllLeader() {
        LeaderExample leaderExample = new LeaderExample();
        return leaderMapper.selectByExample(leaderExample);
    }
}
