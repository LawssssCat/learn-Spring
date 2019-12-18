package vedio.dao;

public interface BookShopDao {
	
	/**
	 * 查询价格
	 */
	public int findBookPriceByIsbn(String isbn)  ; 
	
	/**
	 * 查询库存
	 */
	public int findBookStockPriceByIsbn(String isbn)  ; 
	/**
	 * 库存减一
	 */
	public void updateBookStockDownByIsbn(String isbn) ; 
	/**
	 * 库存加一
	 */
	public void updateBookStockUpByIsbn(String isbn) ; 
	
	/**
	 * 增加用户预付款
	 */
	public void updateUserAccount(String username , int price) ;
	/**
	 * 查询用户预付款
	 */
	public int findUserBalanceByUsername(String username) ;
	
}
