package vedio.dao;

public interface BookShopDao {
	
	/**
	 * 查询价格
	 */
	public int findBookPriceByIsbn(String isbn)  ; 
	
	/**
	 * 查询库存
	 */
	public int findBookStockByIsbn(String isbn)  ; 
	/**
	 * 库存减一
	 */
	public void updateBookStockDownByIsbn(String isbn) ; 
	/**
	 * 库存加一
	 */
	public void updateBookStockUpByIsbn(String isbn) ; 
	
	/**
	 * 扣除用户余额
	 */
	public void updateUserAccount(String username , int price) ;
	/**
	 * 查询用户余额
	 */
	public int findUserBalanceByUsername(String username) ;
	
}
