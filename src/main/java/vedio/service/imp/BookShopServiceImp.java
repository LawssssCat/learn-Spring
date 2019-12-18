package vedio.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vedio.dao.BookShopDao;
import vedio.dao.UserBalanceException;
import vedio.service.BookShopService;

@Service
public class BookShopServiceImp implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao ; 
	
	/**
	 * 添加事务注解
	 * 1. 使用 propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时，
	 * 2. 如何使用事务，
	 * REQUIRED (默认取值) ， 即使用调用方法的事务
	 * REQUIRES_NEW ，必须启动一个新事务，并在自己的事务内运行，
	 * 		如果有事务在运行，就应该先挂起它
	 * 3. 。。。。。
	 * 4. 使用 readOnly 指定事务是否为只读。（如果只是只读，可以不加锁）
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW , 
			isolation = Isolation.READ_COMMITTED , 
			noRollbackFor = {UserBalanceException.class} , 
			readOnly = false) 
	@Override
	public void purchaseBook(String username, String isbn) {
		//1. 书单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2.书库存-1
		bookShopDao.updateBookStockDownByIsbn(isbn);
		
		//3. 用户余额-price
		bookShopDao.updateUserAccount(username, price);
		
	}

	

}
