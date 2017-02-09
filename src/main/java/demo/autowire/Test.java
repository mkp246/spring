package demo.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAutowire.xml");
        A a = context.getBean("a", A.class);
        a.display();
    }
}
