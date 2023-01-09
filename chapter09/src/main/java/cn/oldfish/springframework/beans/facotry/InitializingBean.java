package cn.oldfish.springframework.beans.facotry;

public interface InitializingBean {
    /**
     * Bean 处理完属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
