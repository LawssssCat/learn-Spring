package vedio.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vedio.dao.BookShopDao;

@Repository
public class BookShopDaoImp implements BookShopDao{

	@Autowired
	private JdbcTemplate jdbcTemplate ;  
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "select price from book where isbn = ? " ; 
		return jdbcTemplate.queryForObject(sql, Integer.class , isbn);
	}
	
	@Override
	public int findBookStockPriceByIsbn(String isbn) {
		String sql = "select stock from book_stock where isbn = ? " ; 
		return jdbcTemplate.queryForObject(sql, Integer.class , isbn);
	}

	@Override
	public void updateBookStockDownByIsbn(String isbn) {
		String sql = "update book_stock set stock=stock-1 where isbn = ? " ; 
		jdbcTemplate.update(sql ,isbn) ; 
	}
	@Override
	public void updateBookStockUpByIsbn(String isbn) {
		String sql = "update book_stock set stock=stock+1 where isbn = ? " ; 
		jdbcTemplate.update(sql ,isbn) ; 
		
	}

	@Override
	public void updateUserAccount(String username, int price) {
		String sql = "update account set balance=balance+? where username=?" ; 
		jdbcTemplate.update(sql,price,username) ; 
	}

	@Override
	public int findUserBalanceByUsername(String username) {
		String sql = "select balance from account where username=?" ; 
		return jdbcTemplate.queryForObject(sql,Integer.class,username);
	}





}
