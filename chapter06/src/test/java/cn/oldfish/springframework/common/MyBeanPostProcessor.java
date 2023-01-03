package cn.oldfish.springframework.common;

import cn.oldfish.springframework.beans.BeansException;
import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.beans.facotry.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setScale("100人以上");
        }
        return bean;
    }

}
