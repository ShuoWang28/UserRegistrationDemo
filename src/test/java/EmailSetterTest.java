import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.flexon.userregistration.User;

public class EmailSetterTest {

	@Test
	public void testEmailSetter() {
		String email1 = "shuowang@flexon.com";
		String email2 = "shuo.wang@flexon.com";
		String email3 = "shuowang^&@gmail.com";
		String email4 = "www.google.com";
		
		User testUser = new User();
		
		System.out.println("Test first email: " + email1);
		testUser.setEmailAddress(email1);
		assertEquals(testUser.getEmailAddress(), email1);
		System.out.println("********* 1st email test passed. ********** \n");
		
		System.out.println("Test second email: " + email2);
		testUser.setEmailAddress(email2);
		assertEquals(testUser.getEmailAddress(), email2);
		System.out.println("********* 2nd email test passed. ********** \n");
		
		System.out.println("Test third email: " + email3);
		testUser.setEmailAddress(email3);
		assertNotEquals(testUser.getEmailAddress(), email3);
		System.out.println("********* 3rd email test passed. ********** \n");
		
		System.out.println("Test forth email: " + email4);
		testUser.setEmailAddress(email4);
		assertNotEquals(testUser.getEmailAddress(), email4);
		System.out.println("********* 4th email test passed. ********** \n");
	}
}
