package com.example.location;

import org.springframework.web.bind.annotation.*;
// import com.example.User;

@RestController
@RequestMapping("/users")
public class UserController {

    //checks if username exists in database
    @GetMapping ("/findUser/{username}")
    public boolean findUsernameExists (@PathVariable String username) {
        return UserService.findUser(username);
    }

    //returns the corresponding password to inputted username
	@GetMapping("/match-credentials/{username}")
	public String getPassword (@PathVariable String username, @PathVariable String password) {
		return UserService.getPasswordByUsername(username);
	}

    //create new user
    @RequestBody
    @PostMapping("/newUser")
    public HttpStatus createUser(@RequestBody User user) {
        UserService.createUser(user);
        return HttpStatus.OK;
    }
}