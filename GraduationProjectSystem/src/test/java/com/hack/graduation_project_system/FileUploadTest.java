package com.hack.graduation_project_system;

import com.hack.graduation_project_system.Utils.WordAndHtmlExchangeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class FileUploadTest {

    public final static String UPLOAD_PATH_PREFIX = "static/uploadFile/";

    @Test
    public void uploadTest() throws Exception {

    }
}
