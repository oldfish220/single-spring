package cn.oldfish.springframework.beans.facotry;

import cn.oldfish.springframework.beans.BeansException;

public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;
}
