package cn.oldfish.springframework.beans.facotry;

import cn.oldfish.springframework.beans.BeansException;

public interface BeanNameAware extends Aware {
    void setBeanName(String beanName) throws BeansException;
}
