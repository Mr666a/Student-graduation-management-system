package com.hack.graduation_project_system;

import com.hack.graduation_project_system.domain.Class;
import com.hack.graduation_project_system.service.ClassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class ClassTest {

    @Autowired
    private ClassService classService;

    @Test
    public void addClass(){
        Class c1 = new Class();
        c1.setClassid("D02");
        c1.setClassname("大数据1班");

        classService.addClass(c1);
    }

    @Test
    public void deleteClass() {
        Class c = classService.getClassById("D02");
        classService.deleteClass(c);

    }

    @Test
    public void updateClass() {
        Class c = classService.getClassById("D01");
        c.setClassname("大数据2班");
        classService.updateClass(c);
    }

    @Test
    public void TestClass() {

    }
}
