package cn.oldfish.springframework.beans.facotry.config;

import cn.oldfish.springframework.beans.facotry.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
