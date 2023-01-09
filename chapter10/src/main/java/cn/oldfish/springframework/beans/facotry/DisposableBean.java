package cn.oldfish.springframework.beans.facotry;

public interface DisposableBean {

    void destroy() throws Exception;
}
