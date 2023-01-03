package cn.oldfish.springframework;

import cn.hutool.core.io.IoUtil;
import cn.oldfish.springframework.core.io.DefaultResourceLoader;
import cn.oldfish.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void classpathTest() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:test.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));
    }

    @Test
    public void fileTest() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/test.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));
    }
}
