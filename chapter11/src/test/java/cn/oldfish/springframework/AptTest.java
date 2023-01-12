package cn.oldfish.springframework;

import cn.oldfish.springframework.aop.AdvisedSupport;
import cn.oldfish.springframework.aop.MethodMatcher;
import cn.oldfish.springframework.aop.TargetSource;
import cn.oldfish.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.oldfish.springframework.aop.framework.Cglib2AopProxy;
import cn.oldfish.springframework.aop.framework.JdkDynamicAopProxy;
import cn.oldfish.springframework.aop.framework.ReflectiveMethodInvocation;
import cn.oldfish.springframework.beans.IUserService;
import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.beans.UserServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AptTest {
    @Test
    public void proxyMethodTest() {
        Object targetObject = new UserService();

        InvocationHandler handler = new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* cn.oldfish.springframework.beans.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObject.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = new MethodInterceptor() {
                        @Override
                        public Object invoke(MethodInvocation invocation) throws Throwable {
                            long start = System.currentTimeMillis();
                            try {
                                return invocation.proceed();
                            } finally {
                                System.out.println("监控 - Begin By AOP");
                                System.out.println("方法名称：" + invocation.getMethod().getName());
                                System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                                System.out.println("监控 - End\r\n");
                            }
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObject, method, args));
                }
                return method.invoke(targetObject, args);
            }
        };

        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObject.getClass().getInterfaces(), handler);
        System.out.println(proxy.queryUserInfo());
    }

    @Test
    public void dynamicProxyTest() {
        IUserService userService = new UserService();

        AdvisedSupport advised = new AdvisedSupport();
        advised.setTargetSource(new TargetSource(userService));
        advised.setMethodInterceptor(new UserServiceInterceptor());
        advised.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.oldfish.springframework.beans.IUserService.*(..))"));

        IUserService proxyJdk = (IUserService) new JdkDynamicAopProxy(advised).getProxy();
        System.out.println(proxyJdk.queryUserInfo());

        IUserService proxyCglib = (IUserService) new Cglib2AopProxy(advised).getProxy();
        System.out.println(proxyCglib.register("张三"));
    }
}
