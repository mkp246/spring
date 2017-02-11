package jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Test {
    public static void main(String args[]){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextJDBC.xml");
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        System.out.println(employeeDao.saveEmployee(new Employee(32, "mkp246", 44)));
        System.out.println(employeeDao.updateEmployee(new Employee(32, "mkp247", 45)));
        System.out.println(employeeDao.deleteEmployee(new Employee(32, "mkp247", 45)));
        System.out.println(employeeDao.saveEmployeeByPreparedStatement(new Employee(32, "mkp247", 45)));
        System.out.println(employeeDao.saveEmployeeByPreparedStatement(new Employee(12, "mkp248", 49)));
        List<Employee> employees = employeeDao.getAllEmployee();
        System.out.println("TOTAL EMPLOYEE : " + employees.size());
        for (Employee employee : employees){
            System.out.println(employee.toString());
        }

        employees = employeeDao.getAllEmployeeRowMapper();
        System.out.println("TOTAL EMPLOYEE : " + employees.size());
        for (Employee employee : employees){
            System.out.println(employee.toString());
        }

        System.out.println("=====================================");

        DriverManagerDataSource dataSource = context.getBean("dataSource", DriverManagerDataSource.class);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        EmployeeDao employeeDao1 = new EmployeeDao();
        employeeDao1.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);

        employeeDao1.saveEmployeeByNamedParameter(new Employee(23,"sonoo",50000));
        System.out.println("TOTAL EMPLOYEE : " + employeeDao.getAllEmployee().size());
    }
}
