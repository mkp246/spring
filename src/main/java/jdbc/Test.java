package jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextJDBC.xml");
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        System.out.println(employeeDao.saveEmployee(new Employee(32, "mkp246", 44)));
        System.out.println(employeeDao.updateEmployee(new Employee(32, "mkp247", 45)));
        System.out.println(employeeDao.deleteEmployee(new Employee(32, "mkp247", 45)));
    }
}
