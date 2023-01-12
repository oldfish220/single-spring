package cn.oldfish.springframework.context;

import cn.oldfish.springframework.beans.facotry.HierarchicalBeanFactory;
import cn.oldfish.springframework.beans.facotry.ListableBeanFactory;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ApplicationEventPublisher {
}
