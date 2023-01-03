package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ApiTest {
    @Test
    public void xmlTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }
}
