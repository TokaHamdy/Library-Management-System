package com.example.library.Controller;

import com.example.library.Entity.BorrowBooks;
import com.example.library.Entity.User;
import com.example.library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    // create new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Check if email already exists using UserService
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(null); // Or throw a specific exception
        }
        // Create the user using the UserService
        return ResponseEntity.ok(userService.createUser(user));
    }
    // get user details
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Get books borrowed by a user
    @GetMapping("/{id}/borrowed-books")
    public ResponseEntity<List<BorrowBooks>> getBorrowedBooks(@PathVariable long id){
        return ResponseEntity.ok(userService.getBorrowedBooksByUserId(id));
    }


}
