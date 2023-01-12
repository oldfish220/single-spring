package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.IUserService;
import cn.oldfish.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ApiTest {
    @Test
    public void aopTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
