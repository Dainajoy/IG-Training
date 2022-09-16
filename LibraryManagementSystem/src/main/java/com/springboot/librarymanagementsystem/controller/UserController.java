package com.springboot.librarymanagementsystem.controller;

import com.springboot.librarymanagementsystem.exception.ResourceNotFoundException;
import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.service.UserService;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        log.info("Adding user through json in user controller.");
        System.out.println("*************************** add user*********************");
        service.saveUser(user);
        return "User Added Successfully!!";
    }

    @PostMapping("/addMultipleUser")
    public String addMultipleUser(@RequestBody List<User> user) {
        log.info("Adding multiple user through json in user controller.");

        service.SaveAllUser(user);
        return "All Users Added Successfully!!";
    }

    @GetMapping("/getAllUser")
    public List<User> findAllUser() {
        log.info("Fetching user in json through user controller.");
        return service.getAllUser();
    }

    @GetMapping("/getUserById/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        Optional<User> user=service.getUserById(id);
        log.info("Fetching user in json through user controller by id.");
        if(user.isPresent())
        {
            return  user;
        }
        else {
            throw new ResourceNotFoundException("No user found for this ID:" + id);
        }


    }

    @GetMapping("/getUserByName/{name}")
    public List<User> findUserByName(@PathVariable String name) {
        log.info("Fetching user in json through user controller by name.");
        List<User> user=service.getsUserByName(name);
        if(user.isEmpty())
        {
            throw new ResourceNotFoundException("No user with this Name:"+name);
        }
        return user;
    }
    @PutMapping("/updateUser")
    public String  updateUser(@RequestBody User user) {
        log.info("Updating user in json through user controller.");
        service.updateUser(user);
        return "User Updated Successfully!!";
    }

}
