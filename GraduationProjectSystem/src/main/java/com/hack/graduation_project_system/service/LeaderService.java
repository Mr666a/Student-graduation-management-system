package com.hack.graduation_project_system.service;

import com.hack.graduation_project_system.domain.Leader;

import java.util.List;

public interface LeaderService {
    public int addLeader(Leader leader);

    public int deleteLeader(Leader leader);

    public int updateLeader(Leader leader);

    public Leader getLeaderById(Integer leaderId);

    public List<Leader> getAllLeader();
}
