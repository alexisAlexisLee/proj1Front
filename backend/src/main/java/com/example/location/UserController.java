package com.example.location;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //checks if username exists in database
    @CrossOrigin
    @GetMapping ("/find-user/{username}")
    public boolean findUsernameExists (@PathVariable String username) throws InterruptedException, ExecutionException {
        return userService.existsUser(username);
    }

    //returns the corresponding password to inputted username
    @CrossOrigin
	@GetMapping("/match-credentials/{username}")
	public String getPassword (@PathVariable String username) throws InterruptedException, ExecutionException {
		return userService.getPasswordByUsername(username);
	}

    //create new user
    @CrossOrigin
    @PostMapping("/new-user")
    public String createUser(@RequestBody User user) throws ExecutionException, InterruptedException{
        return userService.createUser(user);
    }
}