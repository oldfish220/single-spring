package cn.oldfish.springframework.beans.facotry;

import cn.oldfish.springframework.beans.BeansException;
import cn.oldfish.springframework.beans.facotry.config.AutowireCapableBeanFactory;
import cn.oldfish.springframework.beans.facotry.config.BeanDefinition;
import cn.oldfish.springframework.beans.facotry.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
