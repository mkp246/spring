package demo.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAOP.xml");
        A a = context.getBean("proxy", A.class);
        System.out.println("proxy class details : " + a.getClass().getName());
        a.m(null);
        System.out.println("//===========================================//");
        Validator validator = context.getBean("throwBean", Validator.class);
        validator.validate(32);
        try {
            validator.validate(12);
        } catch (Exception e){
            System.out.println("an error occurred");
        }
        System.out.println("//===========================================//");

    }
}
