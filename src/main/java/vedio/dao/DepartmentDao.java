package vedio.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import vedio.Department;

@Repository
public class DepartmentDao  extends JdbcDaoSupport{
	
	@Autowired
	public  void setDataSource2(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public Department get(int id) {
		String sql = "select id , name from dept where id = ?" ; 
		RowMapper<Department> rowMapper = 
				new  BeanPropertyRowMapper<Department>(Department.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper , id);
	}
}
