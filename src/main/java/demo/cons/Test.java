package demo.cons;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {
    public static void main(String argc[]){
        ClassPathResource resource = new ClassPathResource("applicationContextCons.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        Employee employee1 = (Employee) factory.getBean("employee1");
        System.out.println(employee1.toString());
    }
}
