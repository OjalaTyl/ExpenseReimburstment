package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import models.User;
import service.UserService;

public class UserServiceTest {

	UserService service = mock(UserService.class);
	User u;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		u = new User(1, "sam", false);
	}

	@Test
	public void getUserTest() {
		when(service.getUser("sam", "sam")).thenReturn(u);
		

		assertEquals(u, service.getUser("sam", "sam"));
		verify(service, times(1)).getUser("sam", "sam");

	}

}
