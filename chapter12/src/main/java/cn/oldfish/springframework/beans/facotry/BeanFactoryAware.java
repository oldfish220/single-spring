package cn.oldfish.springframework.beans.facotry;

import cn.oldfish.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
