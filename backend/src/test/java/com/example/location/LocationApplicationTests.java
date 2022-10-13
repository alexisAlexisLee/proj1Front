package com.example.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LocationApplicationTests {


	UserService userservice;
	User user;


	@Test
	void contextLoads() {
	}

	public void createUserData() throws ExecutionException, InterruptedException {
		user.setUsername("kentster");
		user.setPassword("Password");
		userservice.createUser(user);
	}

	@Test
	public void testUserData() throws ExecutionException, InterruptedException {
		createUserData();
		boolean res = userservice.existsUser("kentster");
		assertEquals(true, res);
	
	}
}
