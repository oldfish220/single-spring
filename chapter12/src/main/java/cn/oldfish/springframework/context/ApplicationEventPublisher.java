package cn.oldfish.springframework.context;

public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}
