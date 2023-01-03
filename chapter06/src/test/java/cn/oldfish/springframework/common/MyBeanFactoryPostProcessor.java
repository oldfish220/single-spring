package cn.oldfish.springframework.common;

import cn.oldfish.springframework.beans.BeansException;
import cn.oldfish.springframework.beans.PropertyValue;
import cn.oldfish.springframework.beans.PropertyValues;
import cn.oldfish.springframework.beans.facotry.ConfigurableListableBeanFactory;
import cn.oldfish.springframework.beans.facotry.config.BeanDefinition;
import cn.oldfish.springframework.beans.facotry.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动"));
    }

}
