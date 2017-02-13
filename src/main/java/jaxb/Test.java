package jaxb;


import com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.castor.CastorMarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String args[]) throws JAXBException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextJAXB.xml");
        Marshaller marshaller = context.getBean("jaxbMarshallerBean", Marshaller.class);
        Employee employee = new Employee(101, "Lala", 69);
        marshaller.marshal(employee, new StreamResult(new FileWriter("employee.xml")));
        System.out.println("xml created successfully");

        Unmarshaller unmarshaller = JAXBContext.newInstance(Employee.class).createUnmarshaller();
        Employee employee1 = (Employee) unmarshaller.unmarshal(new File("employee.xml"));
        System.out.println(employee1.toString());

        Marshaller marshaller1 = context.getBean("castorMarshallerBean", Marshaller.class);
        marshaller1.marshal(employee, new StreamResult(new FileWriter("emp.xml")));
    }
}
