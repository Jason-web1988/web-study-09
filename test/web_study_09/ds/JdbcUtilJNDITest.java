package web_study_09.ds;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JdbcUtilJNDITest {

	@Test
	public void testGetConnection() {
		Connection con = JdbcUtilJNDI.getConnection();
		Assert.assertNotNull(con);
		System.out.println("con : " + con);
	}//여기서는 테스트가 안됨


}
