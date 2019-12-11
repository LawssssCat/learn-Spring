package spring5.vedio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Main {
	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("resource/vedio/beans-properties.xml");
//		ComboPooledDataSource pool = ac.getBean("dataSource" , ComboPooledDataSource.class) ;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		Connection conn  = null ;
		PreparedStatement ps  = null ;
		ResultSet rs = null ; 
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			System.out.println("启动驱动成功...\n获取连接...");
			
			pool.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jt_db?characterEncoding=gbk");
			pool.setUser("root");
			pool.setPassword("root");
			conn = pool.getConnection();
			System.out.println("-- 获得连接 ：" + conn);
			
			String sql = "select * from stu ; " ; 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("-- 打印查询结果 --");
			show(rs); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn , ps , rs ) ; 
		}
	}

	private static void show(ResultSet rs) { 
		ResultSetMetaData metaData = null ;
		StringBuilder sb = new StringBuilder("[ ");
		String s = ", " ; 
		try {
			metaData  = rs.getMetaData();
			int col = metaData.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i <= col; i++) {
					Object obj = rs.getObject(i);
					sb.append(obj) ; 
					sb.append(s); 
				}
				sb.delete(sb.length() - s.length(), sb.length()) ; 
				sb.append("]") ; 
				System.out.println(sb.toString());
				sb.delete(2, sb.length()) ; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null; 
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps = null ; 
			}
		}
		if(rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs = null ;
			}
		}
	}
}
