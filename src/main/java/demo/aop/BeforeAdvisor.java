package demo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvisor implements MethodBeforeAdvice{

    public void before(Method method, Object[] args, Object target) throws Throwable{
        System.out.println("addition concern before actual logic");
        System.out.println("method info : " + method.getName() + " " + method.getModifiers());
        System.out.println("argument info :");
        for (Object object : args){
            System.out.println(object);
        }
        System.out.println("target object " + target);
        System.out.println("target object class name : " + target.getClass().getName());
    }
}
