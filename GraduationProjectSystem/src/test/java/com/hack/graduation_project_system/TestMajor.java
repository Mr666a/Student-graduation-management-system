package com.hack.graduation_project_system;


import com.hack.graduation_project_system.dao.MajorMapper;
import com.hack.graduation_project_system.domain.Major;
import com.hack.graduation_project_system.service.MajorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class TestMajor {

    @Autowired
    private MajorService majorService;

    @Test
    public void TestMapper() {

        List<Major> list = majorService.getAllMajor();

        for (Major m: list){
            System.out.println(m.getMajorid());
        }
    }
}
