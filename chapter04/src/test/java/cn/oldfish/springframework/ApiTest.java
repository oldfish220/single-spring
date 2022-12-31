package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.PropertyValue;
import cn.oldfish.springframework.beans.PropertyValues;
import cn.oldfish.springframework.beans.UserDao;
import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.beans.facotry.config.BeanDefinition;
import cn.oldfish.springframework.beans.facotry.config.BeanReference;
import cn.oldfish.springframework.beans.facotry.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {
    @Test
    public void beanFactoryTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "007"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
