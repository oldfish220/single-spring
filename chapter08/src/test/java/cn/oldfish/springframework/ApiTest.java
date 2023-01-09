package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ApiTest {
    @Test
    public void awareTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
    }
}
