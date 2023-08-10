package com.example.max_market.repository;

import com.example.max_market.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select user from User user where user.username =: username")
    Optional<User> findByUsername(String username);

}
