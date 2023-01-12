package cn.oldfish.springframework.aop;

public interface PointcutAdvisor extends Advisor {

    PointCut getPointcut();

}
