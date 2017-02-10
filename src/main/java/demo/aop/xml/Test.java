package demo.aop.xml;

import demo.aop.Validator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAOPXML.xml");
        Operation operation = context.getBean("operationBean", Operation.class);
        System.out.println("calling msg");
        operation.msg();
        System.out.println("calling m");
        operation.m();
        System.out.println("calling k");
        operation.k();
        System.out.println("==================================");
        Validator validator = context.getBean("throwBean", Validator.class);
        try{
            validator.validate(1);
        } catch (Exception e){
            System.out.println("an err occurred : " + e.getMessage());
        }
        validator.validate(21);
    }
}
