package jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public void setSimpleJdbcCall(SimpleJdbcInsert simpleJdbcCall) {
        this.simpleJdbcInsert = simpleJdbcCall;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveEmployee(Employee e){
        StringBuilder query = new StringBuilder();
        query.append(String.format("insert into employee(id,name,salary) values(%s,'%s',%s)", e.getId(),e.getName(),e.getSalary()));
        return jdbcTemplate.update(query.toString());
    }

    public Boolean saveEmployeeByPreparedStatement(final Employee employee){
        String query = "insert into employee values(?,?,?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, employee.getId());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setFloat(3, employee.getSalary());
                return preparedStatement.execute();
            }
        });
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

    public List<Employee> getAllEmployee(){
        String query = "select * from employee";
        return jdbcTemplate.query(query, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<Employee>();
                while (resultSet.next()){
                    Employee e = new Employee(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getFloat(3));
                    list.add(e);
                }
                return list;
            }
        });
    }

    public List<Employee> getAllEmployeeRowMapper(){
        String query = "select * from employee";
        return jdbcTemplate.query(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee e = new Employee();
                e.setId(resultSet.getInt(1));
                e.setName(resultSet.getString(2));
                e.setSalary(resultSet.getFloat(3));
                return e;
            }
        });
    }

    public void saveEmployeeByNamedParameter(Employee employee){
        String query = "insert into employee values(:id,:name,:salary)";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", employee.getId());
        map.put("name", employee.getName());
        map.put("salary", employee.getSalary());
        namedParameterJdbcTemplate.execute(query, map, new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                return preparedStatement.executeUpdate();
            }
        });
    }

    public int updateByVarArgs(Employee employee){
        String query = "update employee set name=? where id=?";
        return 0;
    }
}
