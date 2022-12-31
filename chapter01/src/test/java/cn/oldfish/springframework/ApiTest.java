package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void beanFactoryTest() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
