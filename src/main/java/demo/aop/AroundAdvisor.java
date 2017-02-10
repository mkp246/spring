package demo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvisor implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("additional concern before actual logic form intercepter");
        System.out.println("method name : " + methodInvocation.getMethod().getClass().getName() + " " +methodInvocation.getMethod().getName());
        methodInvocation.proceed();
        System.out.println("additional concern after actual logic form intercepter");
        return null;
    }
}
