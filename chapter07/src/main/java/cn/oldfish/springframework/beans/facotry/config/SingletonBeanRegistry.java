package cn.oldfish.springframework.beans.facotry.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
