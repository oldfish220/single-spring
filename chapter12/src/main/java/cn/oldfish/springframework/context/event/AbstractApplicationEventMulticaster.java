package cn.oldfish.springframework.context.event;

import cn.oldfish.springframework.beans.BeansException;
import cn.oldfish.springframework.beans.facotry.BeanFactory;
import cn.oldfish.springframework.beans.facotry.BeanFactoryAware;
import cn.oldfish.springframework.context.ApplicationEvent;
import cn.oldfish.springframework.context.ApplicationListener;
import cn.oldfish.springframework.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    private final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationEventListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationEventListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationListener> allListeners = new LinkedList<>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    /**
     * 监听器是否支持该事件
     * @param listener
     * @param event
     * @return
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> listener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = listener.getClass();

        Class<?> targetClass = ClassUtils.isCglibClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];
        Type type = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = type.getTypeName();
        Class<?> eventClassName;

        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }

        // 判定此 eventClassName 对象所表示的类或接口与指定的 event.getClass()
        // 参数所表示的类或接口是否相同，或是否是其超类或超接口
        // isAssignableFrom是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，
        // 默认所有的类的终极父类都是Object。如果A.isAssignableFrom(B)结果是true，
        // 证明B可以转换成为A,也就是A可以由B转换而来
        return eventClassName.isAssignableFrom(event.getClass());
    }
}
