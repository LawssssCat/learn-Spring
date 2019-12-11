package spring5.vedio.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test_C3P0 {
	@Test
	public void testFindAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//创建一个连接池对象(池子:会包含很多连接) 
		//每个池，都必须继承 sun公司的 接口 - DataSource
		// c3p0
		ComboPooledDataSource pool = 
				new ComboPooledDataSource();
		
		try {
			//设置连接数据库的基本信息
			pool.setDriverClass("com.mysql.jdbc.Driver");
			pool.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jt_db?characterEncoding=gbk");
			pool.setUser("root");
			pool.setPassword("root");
			//如果能连接，会默认获取一批连接放在池中。
			//修改，通过pool获得连接
			//conn = pool.getConnection();
			conn = JdbcUtil.getConn();
			//到下面 close 代码
			
			String sql = "select * from account;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double money = rs.getDouble("money");
				System.out.println(id + " : " + name + " : " + money);
			}

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*
			 * ---------
			 * 之前
			 * ---------
			 * 我们自己创建连接对象，
			 * 这个连接对象是没有经过任何修改的，
			 * 原生的连接对象。
			 * conn.close();
			 * 是将连接关闭。
			 * 
			 * -----
			 * 现在
			 * -----
			 * 如果是通过连接池获取了一个连接池对象，
			 * 整个连接池对象在返回时就已经被修改。
			 * 其中的close方法被改成了将连接还回到连接池中，
			 */
			JdbcUtil.close(conn, ps, rs);
		}
	}
}

