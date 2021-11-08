package firstdoublure;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.unilim.iut.HashProvider;
import fr.unilim.iut.User;
import fr.unilim.iut.UserService;
import fr.unilim.iut.UserServiceImpl;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

	@Test
	public void should_create_user_with_hashed_password() {
    
    	HashProvider hashProvider = mock(HashProvider.class);
    	when(hashProvider.hash("secret")).thenReturn("hash");
       	UserService userService = new UserServiceImpl(hashProvider);
     	
    	User user = userService.createUser("Bob", "secret");

     	assertEquals(user.firstName(), "Bob"); 
     	assertEquals(user.hashedPassword(), "hash"); 
}
}