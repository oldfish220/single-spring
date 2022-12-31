package cn.oldfish.springframework.beans.facotry;

import cn.oldfish.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
