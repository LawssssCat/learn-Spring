package vedio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vedio.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	public Employee get(Integer id) {
		String sql = "select id , last_name name , email from emp where id=? ; ";
		RowMapper<Employee> rowMapper =  
				new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql , rowMapper, id);
		
		return employee ; 
	}
}
