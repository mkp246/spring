package demo.aop.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TrackOperation {

    @Pointcut("execution(* Operation.*())")
    public void k(){}

    @Before("k()")
    public void myAdvice(JoinPoint jp){
        System.out.println("addition before concerns");
    }

    @After("k()")
    public void myAfterAdvice(JoinPoint jp){
        System.out.println("addition after concerns");
    }

    @AfterReturning(pointcut = "k()", returning = "result")
    public void myAfterReturningAdvice(JoinPoint jp, Object result){
        System.out.println("additional concern after returning advice");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Result in advice: "+ result);
        System.out.println("end of after returning advice...");
    }

    @Around("k()")
    public Object myAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Additional Concern in around advice Before calling actual method");
        Object obj= pjp.proceed();
        System.out.println("Additional Concern in around advice After calling actual method");
        return obj;
    }

    @AfterThrowing(value = "execution(* demo.aop.Validator.*(..))", throwing = "err")
    public void myThrowAdvice(JoinPoint jp, Throwable err){
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception is: "+ err);
        System.out.println("end of after throwing advice...");
    }
}
