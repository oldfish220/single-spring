package cn.oldfish.springframework.context;

import cn.oldfish.springframework.beans.BeansException;
import cn.oldfish.springframework.beans.facotry.Aware;

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
