package video;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import vedio.dao.BookShopDao;

/**
 * 1. 事务Dao准备
 * 2. 事务绑定 
 *
 */
public class Test_BookShop {
	
	private ClassPathXmlApplicationContext ctx = null ;
	private JdbcTemplate jdbcTemplate = null ;
	private BookShopDao bookShopDao  = null ; 
	
	{
		ctx = new ClassPathXmlApplicationContext("vedio/applicationContext-bookshop.xml") ;
		jdbcTemplate = ctx.getBean(JdbcTemplate.class) ;
		bookShopDao = ctx.getBean(BookShopDao.class) ; 
	}
	
	
	
	
	
	/**
	 * 测试：stock查询、增、删
	 */
	@Test
	public void testBookStock() {
		int stock = 0 ; 
		String isbn = "1001";
		//查stock
		System.out.println("现有库存="+bookShopDao.findBookStockByIsbn(isbn)  );
		
		//stock-1
		bookShopDao.updateBookStockDownByIsbn(isbn);
		System.out.println("库存-1="+bookShopDao.findBookStockByIsbn(isbn)  );
		
		//stock+1
		bookShopDao.updateBookStockUpByIsbn(isbn);
		System.out.println("库存+1="+bookShopDao.findBookStockByIsbn(isbn)  );
	}
	
	/**
	 * 测试：用户查询，预付修改 —— 关联book价格查询
	 */
	@Test
	public void testUpdateUserAccount() {
		String username = "AA";
		System.out.println("现有余额："+bookShopDao.findUserBalanceByUsername(username ));
		String isbn = "1001" ; 
		int price = bookShopDao.findBookPriceByIsbn(isbn) ;
		bookShopDao.updateUserAccount(username, price );
		System.out.println("购书价格："+price);
		System.out.println("扣除后余额："+bookShopDao.findUserBalanceByUsername(username ));
	}

	/**
	 * 测试：查询price
	 */
	@Test
	public void testFindBookPriceByIsbn() {
		//这里，用int 基本类型会报错 
		int price = bookShopDao.findBookPriceByIsbn("1001"); //100
		System.out.println(price);
	}
	
	/**
	 * 测试dataSource连接数据库
	 * @throws SQLException
	 */
	@Test
	public void testJdbcTemplateConnection() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}

}
