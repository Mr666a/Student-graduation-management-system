package com.hack.graduation_project_system;

import com.hack.graduation_project_system.Utils.FileOperation;
import com.hack.graduation_project_system.Utils.ReadHtmlFileUtil;
import com.hack.graduation_project_system.pojo.Message;
import com.hack.graduation_project_system.pojo.ProgressInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class MyTest {
    @Test
    public void testReadFile(){
        ProgressInfo progressInfo = new ProgressInfo();
        progressInfo.setPercentage(100);
        progressInfo.setProgressMsg("任务完成 !");
        Message message = new Message();
        message.setMid(1);
        message.setMessage("完成了吗");
        progressInfo.setMessage(message);
        FileOperation.writeFile("test", progressInfo);

        ProgressInfo progressInfo1 = FileOperation.readFile("test");
        System.out.println(progressInfo1.getProgressMsg());

    }
}
