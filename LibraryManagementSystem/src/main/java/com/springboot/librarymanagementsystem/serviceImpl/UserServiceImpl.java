package com.springboot.librarymanagementsystem.serviceImpl;

import com.springboot.librarymanagementsystem.exception.ResourceNotFoundException;
import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.repository.UserRepository;
import com.springboot.librarymanagementsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User userTable) {
        log.info("User service called for save book.");
        return userRepository.save(userTable);
    }

    @Override
    public User createUser(User user) {
        Optional<User> savedUser = userRepository.findByEmail(user.getUserEmailId());
        if (savedUser.isPresent()) {
            throw new ResourceNotFoundException("User already exist with given email :" + user.getUserEmailId());
        }
        return userRepository.save(user);
    }
    public List<User> SaveAllUser(List<User> userTable) {
        log.info("User service called for saving all users.");
        return userRepository.saveAll(userTable);
    }

    public List<User> getAllUser() {
        log.info("User service called for getting all users.");
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        log.info("User service called for getting user by Id.");
        return userRepository.findByuserId(id);
    }

    public List<User> getsUserByName(String name) {
        log.info("User service called for getting user by name.");
        return userRepository.findByuserName(name);
    }


    public User updateUser(User user) {
        log.info("User service called for updating user.");
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        existingUser.setUserName(user.getUserName());

        existingUser.setUserEmailId(user.getUserEmailId());
        existingUser.setUserMobileNo(user.getUserMobileNo());
        existingUser.setUserAddress(user.getUserAddress());
        existingUser.setUserType(user.getUserType());
        return userRepository.save(existingUser);
    }
}
