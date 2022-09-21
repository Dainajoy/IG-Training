package com.springboot.librarymanagementsystem.service;

import com.springboot.librarymanagementsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface UserService {
    public User saveUser(User userTable);

    public List<User> SaveAllUser(List<User> userTable);

    public List<User> getAllUser();
    public User createUser(User user);

    public Optional<User> getUserById(Long id);

    public List<User> getsUserByName(String name);


    public User updateUser(User userTable);
}
