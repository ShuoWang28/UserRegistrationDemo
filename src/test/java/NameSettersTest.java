import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.flexon.userregistration.User;

public class NameSettersTest {
	
	@Test
	public void testFirstNameGetter() {
		User testUser = new User();
		
		System.out.println("Test first name: Shuo");
		String name1 = "Shuo";
		testUser.setFirstName(name1);
		assertEquals(testUser.getFirstName(), name1.toLowerCase());
		System.out.println("********* 1st first name test passed. ********** \n");
		
		System.out.println("Test first name: X Æ A-12");
		String name2 = "X Æ A-12";
		testUser.setFirstName(name2);
		assertNotEquals(testUser.getFirstName(), name2);
		System.out.println("********* 2nd first name test passed. ********** \n");
		
	}
}
