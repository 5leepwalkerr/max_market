package com.example.max_market.repository;

import com.example.max_market.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.username =: username")
    Optional<User> findByUsername(String username);

    @Query("select i from User i where i.id =: id")
    Optional<User> findById(Long id);

}
