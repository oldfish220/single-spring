package cn.oldfish.springframework.beans.facotry.support;

import cn.hutool.core.util.StrUtil;
import cn.oldfish.springframework.beans.BeansException;
import cn.oldfish.springframework.beans.facotry.DisposableBean;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {
    private Object bean;

    private String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, String destroyMethodName) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = destroyMethodName;
    }

    @Override
    public void destroy() throws Exception {
        // 通过接口执行初始化方法
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 读取配置信息并通过反射方式执行初始化方法
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (destroyMethod == null) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
