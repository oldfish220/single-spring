package cn.oldfish.springframework.event;

import cn.oldfish.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到消息：" + event.getSource());
        System.out.println("事件：" + event.getId());
        System.out.println("内容：" + event.getMessage());
    }
}
