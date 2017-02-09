package demo.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextFactory.xml");
        A a1 = context.getBean("a1", A.class);
        a1.msg();
        System.out.println(" //===========================//");
        Printable printable = context.getBean("printable", Printable.class);
        printable.print();
        System.out.println(" //===========================//");
        Printable printableNonStatic = context.getBean("printableNonStatic", Printable.class);
        printableNonStatic.print();
    }
}
