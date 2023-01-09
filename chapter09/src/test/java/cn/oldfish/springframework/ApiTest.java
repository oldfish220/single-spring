package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

public class ApiTest {

    @Test
    public void protoTypeTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-prototype.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        System.out.println("userService01 => " + userService01);
        System.out.println("userService01 测试结果：" + userService01.queryUserInfo());

        System.out.println("userService02 => " + userService02);
        System.out.println("userService02 测试结果：" + userService02.queryUserInfo());
    }

    @Test
    public void singletonTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-singleton.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        System.out.println("userService01 => " + userService01);
        System.out.println("userService01 测试结果：" + userService01.queryUserInfo());

        System.out.println("userService02 => " + userService02);
        System.out.println("userService02 测试结果：" + userService02.queryUserInfo());
    }
}
