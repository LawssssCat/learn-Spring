package vedio.dao;

public interface BookShopDao {
	
	/*==========  book  ====================*/
	/**
	 * 查询价格
	 */
	public int findBookPriceByIsbn(String isbn)  ;
	/**
	 * 查询书名 
	 */
	public String findBookNameByIsbn(String isbn) ;
	
	/*==========  book_stock  ==============*/
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
	
	/*==========  account  =================*/
	/**
	 * 扣除用户余额
	 */
	public void updateUserAccount(String username , int price) ;
	/**
	 * 查询用户余额
	 */
	public int findUserBalanceByUsername(String username) ;
	
}
