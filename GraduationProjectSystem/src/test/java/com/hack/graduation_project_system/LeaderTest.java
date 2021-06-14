package com.hack.graduation_project_system;

import com.hack.graduation_project_system.domain.Leader;
import com.hack.graduation_project_system.service.LeaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class LeaderTest {

    @Autowired
    private LeaderService leaderService;

    @Test
    public void addLeader() {
        Leader leader = new Leader();
        leader.setLeadername("张领导");
        leader.setGender("男");
        leader.setMajorid("M01");
        leader.setPassword("456789");
        leader.setRole("专业负责人");
        leaderService.addLeader(leader);
    }

    @Test
    public void deleteLeader() {
        Leader leader = leaderService.getLeaderById(6);
        System.out.println(leader);
        leaderService.deleteLeader(leader);
    }

    @Test
    public void updateLeader() {
        Leader leader = leaderService.getLeaderById(100);
        System.out.println(leader);
        leader.setGender("女");
        leaderService.updateLeader(leader);
    }
}
