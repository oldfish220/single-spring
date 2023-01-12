package cn.oldfish.springframework.context.event;

import cn.oldfish.springframework.beans.facotry.BeanFactory;
import cn.oldfish.springframework.context.ApplicationEvent;
import cn.oldfish.springframework.context.ApplicationListener;

public class SimpleApplicationEventMuilticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMuilticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
