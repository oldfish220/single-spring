package cn.oldfish.springframework.context.event;

import cn.oldfish.springframework.context.ApplicationEvent;
import cn.oldfish.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationEventListener(ApplicationListener<?> listener);

    void removeApplicationEventListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
