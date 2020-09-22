import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.flexon.userregistration.User;

public class PasswordSetterTest {
	@Test
	public void testPasswordSetter() {
		String psw1 = "123456";
		String psw2 = "adsfjoew#D";
		String psw3 = "Wjdre34r!34fds";
		String psw4 = "3244rfregf43ff#FDfEF#DES";
		
		User testUser = new User();
		
		System.out.println("Test first password: " + psw1);
		testUser.setPassword(psw1);
		assertNotEquals(testUser.getPassword(), psw1);
		System.out.println("********* 1st password test passed. ********** \n");
		
		System.out.println("Test second password: " + psw2);
		testUser.setPassword(psw2);
		assertNotEquals(testUser.getPassword(), psw2);
		System.out.println("********* 2nd password test passed. ********** \n");
		
		System.out.println("Test third password: " + psw3);
		testUser.setPassword(psw3);
		assertEquals(testUser.getPassword(), psw3);
		System.out.println("********* 3rd password test passed. ********** \n");
		
		System.out.println("Test forth password: " + psw4);
		testUser.setPassword(psw4);
		assertNotEquals(testUser.getPassword(), psw4);
		System.out.println("********* 4th password test passed. ********** \n");
	}
}
