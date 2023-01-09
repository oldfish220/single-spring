package cn.oldfish.springframework.context.event;

import cn.oldfish.springframework.context.ApplicationEvent;
import cn.oldfish.springframework.context.ApplicationListener;

public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster {

    @Override
    public void addApplicationEventListener(ApplicationListener<?> listener) {

    }

    @Override
    public void removeApplicationEventListener(ApplicationListener<?> listener) {

    }

    @Override
    public void multicastEvent(ApplicationEvent event) {

    }
}
