package video;

import org.junit.Test;

import vedio.jdbc.JdbcUtil;

public class Test_path {
	@Test
	public void test01() {
		String path = JdbcUtil.class.getResource("/").getPath();
		System.out.println(path);
	}
}
