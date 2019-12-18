package vedio.service;

import java.util.List;

/**
 * 业务层  
 */
public interface BookShopService {
	public void purchaseBook( String username , String isbn) ;
	public void checkout(String username , List<String> isbns) ;
}
