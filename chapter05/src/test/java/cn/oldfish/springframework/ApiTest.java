package cn.oldfish.springframework;

import cn.hutool.core.io.IoUtil;
import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.beans.facotry.support.DefaultListableBeanFactory;
import cn.oldfish.springframework.beans.facotry.xml.XmlBeanDefinitionReader;
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

    @Test
    public void urlTest() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/oldfish220/single-spring/test.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));
    }

    @Test
    public void xmlTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:beans.xml");
        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }
}
