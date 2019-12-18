package vedio.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vedio.dao.BookShopDao;
import vedio.dao.BookStackException;
import vedio.dao.UserBalanceException;

@Repository
public class BookShopDaoImp implements BookShopDao{

	@Autowired
	private JdbcTemplate jdbcTemplate ;  
	
	/*====================  book  =======================*/
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "select price from book where isbn = ? " ; 
		return jdbcTemplate.queryForObject(sql, Integer.class , isbn);
	}
	
	@Override
	public String findBookNameByIsbn(String isbn) {
		String sql = "select bookname from book where isbn = ?" ; 
		return jdbcTemplate.queryForObject(sql, String.class, isbn);
	}
	
	
	/*====================  book_stock  =================*/
	@Override
	public int findBookStockByIsbn(String isbn) {
		String sql = "select stock from book_stock where isbn = ? " ; 
		return jdbcTemplate.queryForObject(sql, Integer.class , isbn);
	}

	@Override
	public void updateBookStockDownByIsbn(String isbn) {
		int stock = findBookStockByIsbn(isbn);
		if(stock==0) {
			throw new BookStackException("库存为零.."+"isbn="+isbn);
		}
		String sql = "update book_stock set stock=stock-1 where isbn = ? " ; 
		jdbcTemplate.update(sql ,isbn) ; 
	}
	@Override
	public void updateBookStockUpByIsbn(String isbn) {
		String sql = "update book_stock set stock=stock+1 where isbn = ? " ; 
		jdbcTemplate.update(sql ,isbn) ; 
		
	}
	
	/*====================  account  ====================*/

	@Override
	public void updateUserAccount(String username, int price) {
		int balance = findUserBalanceByUsername(username);
		if(balance < price) {
			throw new UserBalanceException("用户余额不足..."+ "username="+username);
		}
		
		
		String sql = "update account set balance=balance-? where username=?" ; 
		jdbcTemplate.update(sql,price,username) ; 
	}

	@Override
	public int findUserBalanceByUsername(String username) {
		String sql = "select balance from account where username=?" ; 
		return jdbcTemplate.queryForObject(sql,Integer.class,username);
	}





}
