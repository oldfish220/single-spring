package cn.oldfish.springframework.aop;

public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
