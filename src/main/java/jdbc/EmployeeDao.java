package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveEmployee(Employee e){
        StringBuilder query = new StringBuilder();
        query.append(String.format("insert into employee(id,name,salary) values(%s,'%s',%s)", e.getId(),e.getName(),e.getSalary()));
        return jdbcTemplate.update(query.toString());
    }

    public int updateEmployee(Employee e){
        StringBuilder query = new StringBuilder();
        query.append(String.format("update employee set name='%s', salary=%s where id=%s", e.getName(),e.getSalary(), e.getId()));
        return jdbcTemplate.update(query.toString());
    }

    public int deleteEmployee(Employee e){
        StringBuilder query = new StringBuilder();
        query.append(String.format("delete from employee where id=%s", e.getId()));
        return jdbcTemplate.update(query.toString());
    }
}
