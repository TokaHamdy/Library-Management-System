package com.example.library.Service;

import com.example.library.Entity.BorrowBooks;
import com.example.library.Entity.User;
import com.example.library.Repository.BorrowBookRepository;
import com.example.library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.util.List;

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
}
