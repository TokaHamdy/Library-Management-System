package com.example.library.Repository;

import com.example.library.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


        boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}


