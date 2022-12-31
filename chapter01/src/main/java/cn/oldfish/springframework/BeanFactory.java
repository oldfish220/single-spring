package cn.oldfish.springframework;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
