package vedio.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vedio.service.BookShopService;
import vedio.service.Cashier;

@Service("cashier")
public class CashierImp implements Cashier{
	
	@Autowired
	BookShopService bookShopService  ; 

	/**
	 * 
	 */
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			bookShopService.purchaseBook(username, isbn);
		}
	}

}
