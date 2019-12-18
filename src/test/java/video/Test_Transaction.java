package video;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vedio.dao.BookShopDao;
import vedio.service.BookShopService;

public class Test_Transaction {
	private ClassPathXmlApplicationContext ctx = null ;
	private BookShopDao bookShopDao = null ;
	private BookShopService bookShopService = null ; 
	{
		ctx = new ClassPathXmlApplicationContext(
				"classpath:vedio/applicationContext-bookshop.xml") ;
		bookShopDao = ctx.getBean(BookShopDao.class) ; 
		bookShopService = ctx.getBean(BookShopService.class) ; 
	}
	
	@Test
	public void testCheckout() {
		String username="AA" ; 
		List<String> isbns = new ArrayList<>();
		isbns.add("1001") ;
		isbns.add("1002");
		
		showStatus(username, isbns.get(0) , isbns.get(1));
		try {
			bookShopService.checkout(username, isbns);
		}catch(Exception e) {
			System.out.println(e);
		}
		showStatus(username, isbns.get(0) , isbns.get(1));
		
	}
	
	
	//@Test
	public void testPurchaseBook() {
		String username  = "AA" ; 
		String isbn = "1001" ; 
		
		
		
		showStatus(username, isbn);
		try {
			bookShopService.purchaseBook(username, isbn);
		}catch (Exception e) {
			System.out.println(e);
		}
		showStatus(username, isbn);
	}
	
	public void showStatus(String username , String ... isbns) {
		System.out.println("-------------");
		for (String isbn : isbns) {
			String bookname = bookShopDao.findBookNameByIsbn(isbn);
			int price = bookShopDao.findBookPriceByIsbn(isbn); 
			int stock = bookShopDao.findBookStockByIsbn(isbn);
			System.out.println("isbn"+isbn);
			System.out.println("bookname="+ bookname);
			System.out.println("price="+price);
			System.out.println("stock="+stock);
		}
		int balance = bookShopDao.findUserBalanceByUsername(username);
		System.out.println("username:"+ username+ ",balance:"+balance);
	}
}
