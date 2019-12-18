package vedio.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vedio.dao.BookShopDao;
import vedio.service.BookShopService;

@Service
public class BookShopServiceImp implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao ; 
	
	/**
	 * 添加事务注解
	 */
	@Transactional
	@Override
	public void purchaseBook(String username, String isbn) {
		//1. 书单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2.书库存-1
		bookShopDao.updateBookStockDownByIsbn(isbn);
		
		//3. 用户余额-price
		bookShopDao.updateUserAccount(username, price);
		
	}

	/**
	 * 
	 */
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			purchaseBook(username, isbn);
		}
	}

}
