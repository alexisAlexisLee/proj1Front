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
    public String findUsernameExists (@PathVariable String username) throws InterruptedException, ExecutionException {
        boolean e = userService.existsUser(username);
        if (e)
            return "true";
        return "false";
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
    public void createUser(@RequestBody User user) throws ExecutionException, InterruptedException{
        userService.createUser(user);
    }
}