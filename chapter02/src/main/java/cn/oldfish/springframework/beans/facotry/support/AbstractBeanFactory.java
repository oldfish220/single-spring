package cn.oldfish.springframework.beans.facotry.support;

import cn.oldfish.springframework.beans.BeansException;
import cn.oldfish.springframework.beans.facotry.BeanFactory;
import cn.oldfish.springframework.beans.facotry.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);
}
