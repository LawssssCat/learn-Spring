package vedio.dao.imp;

public interface BookShopDao {
	
	/**
	 * 查询价格
	 */
	public int findBookPriceByIsbn(int isbn)  ; 
	
	/**
	 * 查询库存
	 */
	public int findBookStockPriceByIsbn(int isbn)  ; 
	/**
	 * 库存减一
	 */
	public void updateBookStockDownByIsbn(int isbn) ; 
	/**
	 * 库存加一
	 */
	public void updateBookStockUpByIsbn(int isbn) ; 
	
	/**
	 * 增加用户预付款
	 */
	public void updateUserAccount(String username , int price) ;
	/**
	 * 查询用户预付款
	 */
	public int findUserBalanceByUsername(String username) ;
	
}
