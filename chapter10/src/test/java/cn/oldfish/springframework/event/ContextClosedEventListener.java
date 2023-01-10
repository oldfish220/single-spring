package cn.oldfish.springframework.event;

import cn.oldfish.springframework.context.ApplicationListener;
import cn.oldfish.springframework.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
