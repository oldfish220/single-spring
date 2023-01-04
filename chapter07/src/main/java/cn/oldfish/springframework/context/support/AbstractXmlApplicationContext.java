package cn.oldfish.springframework.context.support;

import cn.oldfish.springframework.beans.facotry.support.DefaultListableBeanFactory;
import cn.oldfish.springframework.beans.facotry.xml.XmlDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlDefinitionReader beanDefinitionReader = new XmlDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
