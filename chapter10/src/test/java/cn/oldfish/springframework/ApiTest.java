package cn.oldfish.springframework;

import cn.oldfish.springframework.context.support.ClassPathXmlApplicationContext;
import cn.oldfish.springframework.event.CustomEvent;
import org.junit.Test;

public class ApiTest {
    @Test
    public void eventTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        applicationContext.publishEvent(new CustomEvent("自定义事件", System.currentTimeMillis(), "事件消费成功"));
        applicationContext.registerShutdownHook();
    }
}
