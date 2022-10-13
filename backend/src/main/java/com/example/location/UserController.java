package com.example.location;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.LinkedList;

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
	public List<String> getPassword (@PathVariable String username) throws InterruptedException, ExecutionException {
        LinkedList<String> res = new LinkedList<>();
        res.add(userService.getPasswordByUsername(username));
		return res;
	}

    //create new user
    @CrossOrigin
    @PostMapping("/new-user")
    public void createUser(@RequestBody User user) throws ExecutionException, InterruptedException{
        userService.createUser(user);
    }
}