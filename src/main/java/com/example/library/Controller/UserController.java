package com.example.library.Controller;

import com.example.library.Entity.BorrowBooks;
import com.example.library.Entity.User;
import com.example.library.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users Controller", description = "Endpoints for managing users in the library system")

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }



    // create new user
    @Operation(summary = "Create a User", description = "Register a new user in the system.")
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
    @Operation(summary = "Get User Details", description = "Retrieve the details of a specific user by their ID.")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Get books borrowed by a user
    @Operation(summary = "Get Borrowed Books by User", description = "Retrieve a list of books currently borrowed by a specific user.")
    @GetMapping("/{id}/borrowed-books")
    public ResponseEntity<List<BorrowBooks>> getBorrowedBooks(@PathVariable long id){
        return ResponseEntity.ok(userService.getBorrowedBooksByUserId(id));
    }


}
