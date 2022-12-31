package cn.oldfish.springframework;

import cn.oldfish.springframework.beans.UserService;
import cn.oldfish.springframework.beans.facotry.config.BeanDefinition;
import cn.oldfish.springframework.beans.facotry.support.DefaultListableBeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ApiTest {
    @Test
    public void beanFactoryTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "oldfish");
        userService.queryUserInfo();
    }

    @Test
    public void newInstanceTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("oldfish");
        userService.queryUserInfo();
    }

    @Test
    public void getParameter() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<?>[] declaredConstructors = userServiceClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("oldfish");
        userService.queryUserInfo();
    }

    @Test
    public void cglibTest() {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"oldfish"});
        System.out.println(obj);
    }
}
