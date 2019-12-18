package video;

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
	
	public void showStatus(String username , String isbn) {
		String name = bookShopDao.findBookNameByIsbn(isbn);
		int price = bookShopDao.findBookPriceByIsbn(isbn); 
		int stock = bookShopDao.findBookStockByIsbn(isbn);
		int balance = bookShopDao.findUserBalanceByUsername(username);
		System.out.println("-------------");
		System.out.println("isbn"+isbn);
		System.out.println("name="+ name);
		System.out.println("price="+price);
		System.out.println("stock="+stock);
		System.out.println("username:"+ username+ ",balance:"+balance);
	}
}
