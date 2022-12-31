package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.beans.facotry.config.BeanDefinition;
import cn.oldfish.springframework.beans.facotry.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {
    @Test
    public void beanFactoryTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        System.out.println(userService);

        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
        System.out.println(userService_singleton);
    }
}
