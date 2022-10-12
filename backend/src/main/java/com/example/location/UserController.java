package com.example.location;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // //checks if username exists in database
    // @GetMapping ("/findUser/{username}")
    // public boolean findUsernameExists (@PathVariable String username) throws InterruptedException, ExecutionException {
    //     return userService.existsUser(username);
    // }

    // //returns the corresponding password to inputted username
	// @GetMapping("/match-credentials/{username}")
	// public String getPassword (@PathVariable String username, @PathVariable String password) throws InterruptedException, ExecutionException {
	// 	return userService.getPasswordByUsername(username);
	// }

    //create new user
    @PostMapping("/newUser")
    public String createUser(@RequestBody User user) throws ExecutionException, InterruptedException{
        return userService.createUser(user);
    }
}