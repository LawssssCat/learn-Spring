package video;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import vedio.Department;
import vedio.Employee;
import vedio.Employee_deptId;
import vedio.dao.DepartmentDao;
import vedio.dao.EmployeeDao;

/**
 * spring jdbc ... 另外一个c3p0
 *
 */
public class JDBCTest {

	private ClassPathXmlApplicationContext cpax = null ;
	private JdbcTemplate jdbcTemplate  = null ;
	private EmployeeDao employeeDao = null ;
	private DepartmentDao departmentDao = null ; 
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null ; 
	{
		cpax = new ClassPathXmlApplicationContext(
				"vedio/applicationContext-jdbc.xml") ;
		
		jdbcTemplate = cpax.getBean(JdbcTemplate.class);
		employeeDao = cpax.getBean(EmployeeDao.class);
		departmentDao = cpax.getBean(DepartmentDao.class) ;
		namedParameterJdbcTemplate = 
				cpax.getBean(NamedParameterJdbcTemplate.class) ;
		
	}
	
	/**
	 * 使用具名参数时，可以使用 update(String sql , SqlParameterSource paramSource) 方法进行更新操作
	 * 1. SQL 语句中的参数名和类的属性一致
	 * 2. 使用 SqlParameterSource 的BeanPropertySqlParameterSource 实现类作为参数
	 */
	@Test
	public void testNamedParameterJdbcTemplateInsert2() {
		String sql = "Insert Into emp(last_name, email , dept_id) values(:name, :email , :dept_id);" ;
		
		
		Employee_deptId emp = new Employee_deptId();
		emp.setName("尼古拉斯");
		emp.setEmail("22222222222@赵四");
		emp.setDept_id(2);
		
		SqlParameterSource paramSource  = new BeanPropertySqlParameterSource(emp); 
		
		namedParameterJdbcTemplate.update(sql, paramSource) ; 
	}
	
	/**
	 * 可以为参数起名了！
	 * 1. 好处：若有多个参数，则不用再去对应位置，直接对应参数名，便于维护。
	 * 2. 缺点：较为麻烦 （x） 
	 */
	//@Test
	public void testNamedParameterJdbcTemplateInsert() {
		//冒号
		//Insert Into emp(last_name, email , dept_id) values(:ln, :email , :deptid)
		String sql = "Insert Into emp(last_name, email , dept_id) values(:ln, :email , :deptid)"; 
		
		Map<String, Object > paramMap = new HashMap<>() ;
		
		paramMap.put("ln", "路飞") ;
		paramMap.put("email", "1111111111@qq.com") ;
		paramMap.put("deptid", "1") ;
		
		namedParameterJdbcTemplate.update(sql, paramMap) ; 
	}
	
	@Test
	public void testDepartmentDaoGet() {
		Department department = departmentDao.get(1);
		System.out.println(department);
	}
	
	
	@Test
	public void testEmployeeDaoGet() {
		Employee employee = employeeDao.get(1);
		System.out.println(employee);
	}
	
	
	/**
	 * 执行批量更新：批量的 Insert，update ， delete
	 * 最后一个阐述是object[] 的 list 类型。
	 */
	//@Test
	public void testBatchInsert() {
		String sql = "INSERT INTO emp(last_name,email , dept_id) values(? , ? , ?) ; " ;
		
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{"AA" , "aa@atguigu" , 1}) ; 
		list.add(new Object[]{"BB" , "bb@atguigu" , 2}) ; 
		list.add(new Object[]{"CC" , "cc@atguigu" , 1}) ; 
		list.add(new Object[]{"DD" , "dd@atguigu" , 1}) ; 
		list.add(new Object[]{"EE" , "ee@atguigu" , 1}) ; 
		
		jdbcTemplate.batchUpdate(sql, list); 
	}
	
	//@Test
	public void testBatchDelete() {
		String sql = "DELETE FROM  emp WHERE LAST_NAME = ? " ;
		
		List<Object[]> list = new ArrayList<>() ;
		list.add(new Object[] {"AA"}) ; 
		list.add(new Object[] {"BB"}) ; 
		list.add(new Object[] {"CC"}) ; 
		list.add(new Object[] {"DD"}) ; 
		list.add(new Object[] {"EE"}) ; 
		
		jdbcTemplate.batchUpdate(sql, list) ; 
	}
	
	
	@Test
	public void testUpdate() {
		String sql = "update emp set last_name = ? where id = ? " ; 
		jdbcTemplate.update(sql , "李尔王" , 2 ) ; 
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = cpax.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	
	/**
	 * 获取单个列的值，或做统计查询
	 * 使用 方法  queryForObject(String sql, Class<?> requiredType)
	 */
	@Test
	public void testQueryForObject2() {
		String sql = "select count(id) from emp ; ";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		System.out.println("总人数："+ count);
	}
	
	
	
	/**
	 * 从数据库中获取一条记录，实际得到对应的一个对象
	 * 
	 * 注意，不是用 
	 * queryForObject
	 * (String sql , Class<?> requiredType, Object ... args )
	 * 
	 * 注意，
	 * queryForObject(sql, RowMapper<?>  rowMapper, Object... args) )
	 * ?中有构造方法会报错
	 * 
	 * 1. 其中 RowMapper 指定如何去映射结构集的行，常用的实现类为BeanPropertyRowMapper
	 * 2. 使用SQL中列的别名来完成列名和类的属性名的映射，例如 last_name 和 name
	 * 3. 不支持级联属性，JdbcTemplate 到底是一个 JDBC的小工具，而不是 ORM 框架
	 */
	@Test
	public void testQueryForObject() {
		String sql = "select id , last_name name , email from emp where id=?" ; 
		
		RowMapper<Employee> rowMapper = 
				new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper ,  1 );
		
		System.out.println(employee);
	}
	
	
	
	
	/**
	 * 查到实例类的集合
	 * 注意调用的不是 queryForList 方法
	 */
	@Test
	public void testQueryForListObject() {
		String sql = "select id , last_name name , email from emp ; " ;
		RowMapper<Employee> rowMapper = 
				new BeanPropertyRowMapper<>(Employee.class) ; 
		List<Employee > employes = jdbcTemplate.query(sql, rowMapper) ;
		for (Employee employee : employes) {
			System.out.println(employee);
		}
	}
	
}
