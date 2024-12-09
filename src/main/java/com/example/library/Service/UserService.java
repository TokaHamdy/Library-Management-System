package com.example.library.Service;

import com.example.library.Entity.BorrowBooks;
import com.example.library.Entity.User;
import com.example.library.Repository.BorrowBookRepository;
import com.example.library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BorrowBookRepository borrowBookRepository;


    @Autowired
    public UserService(UserRepository userRepository, BorrowBookRepository borrowBookRepository){
        this.userRepository=userRepository;
        this.borrowBookRepository = borrowBookRepository;
    }

    // Create a new user
    public User createUser(User user){

        return userRepository.save(user);
    }

    // Get uer details
    public User getUserById(long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found with id:" + id));
    }

    // Get books borrowed by a user
    public List<BorrowBooks> getBorrowedBooksByUserId(long id){
        return  borrowBookRepository.findByUserIdAndStatus(id,"BORROWED");
    }



    // Method to check if a user exists by email
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // Retrieves a User by their email,using Optional to handle the case where no user is found
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
