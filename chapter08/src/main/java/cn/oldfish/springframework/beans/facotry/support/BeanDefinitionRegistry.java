package cn.oldfish.springframework.beans.facotry.support;

import cn.oldfish.springframework.beans.facotry.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames(String beanName);
}
