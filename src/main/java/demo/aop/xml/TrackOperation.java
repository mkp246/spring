package demo.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TrackOperation {

    public void k(){}

    public void myAdvice(JoinPoint jp){
        System.out.println("addition before concerns");
    }

    public void myAfterAdvice(JoinPoint jp){
        System.out.println("addition after concerns");
    }

    public void myAfterReturningAdvice(JoinPoint jp, Object result){
        System.out.println("additional concern after returning advice");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Result in advice: "+ result);
        System.out.println("end of after returning advice...");
    }

    public Object myAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Additional Concern in around advice Before calling actual method");
        Object obj= pjp.proceed();
        System.out.println("Additional Concern in around advice After calling actual method");
        return obj;
    }

    public void myThrowAdvice(JoinPoint jp, Throwable err){
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception is: "+ err);
        System.out.println("end of after throwing advice...");
    }
}
