package demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.naming.NamingException;


public class Test {
    public static void main(String[] args) throws NamingException {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        Student student=(Student)factory.getBean("studentBean");
        System.out.println(student.toString());

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student) context.getBean("studentBean");
        System.out.println(student1.toString());
        Question q1 = (Question) factory.getBean("q1");
        System.out.println(q1.toString());
        /*Properties properties = new Properties();
        properties.put(Context.URL_PKG_PREFIXES, "demo.Student");
        Context ctx = new InitialDirContext(properties);
        Context stdContext = (Context) ctx.lookup("java:demo");
        Student student2 = (Student) stdContext.lookup("Student");
        student2.displayInfo();*/
        Student student2 = (Student) factory.getBean("studentBean2");
        System.out.println(student2.toString());
        student1 = (Student) factory.getBean("studentBean1");
        //System.out.println(student1.toString());
        //============================================================//
        //============================================================//
        //=========dependency injection by Setter method==============//

    }
}
