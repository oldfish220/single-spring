package cn.oldfish.springframework.event;

import cn.oldfish.springframework.context.ApplicationListener;
import cn.oldfish.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
