package com.example.max_market.service;

import com.example.max_market.model.Role;
import com.example.max_market.model.User;
import com.example.max_market.repository.RoleRepository;
import com.example.max_market.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService, UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository repository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }
        return user.get();
    }
    @Override
    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(new User());
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1L,"ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<User> usergtList(Long idMin) {
        return entityManager.createQuery("select u from User u where u.id =: paramId")
                .setParameter("paramId",idMin).getResultList();
    }
}
