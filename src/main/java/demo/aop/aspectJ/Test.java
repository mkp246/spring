package demo.aop.aspectJ;

import demo.aop.Validator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAOP.xml");
        Operation operation = context.getBean("operationBean", Operation.class);
        System.out.println("calling msg");
        operation.msg();
        System.out.println("calling m");
        operation.m();
        System.out.println("calling k");
        operation.k();

        Validator validator = context.getBean("throwBeanAspectJ", Validator.class);
        validator.validate(32);
        validator.validate(2);

    }
}
