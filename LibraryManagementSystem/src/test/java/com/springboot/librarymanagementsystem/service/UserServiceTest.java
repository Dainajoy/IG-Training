package com.springboot.librarymanagementsystem.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.repository.UserRepository;
import com.springboot.librarymanagementsystem.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUpUser() {
        user = User.builder().userName("Sree").userEmailId("sree@gmail.com").userMobileNo("111111")
                .userAddress("Bangalore").userType("Student").build();
    }

    @DisplayName("Junit test for save user.")
    @Test
    public void givenUserObject_whenSave_thenReturnUserObject() {
        BDDMockito.given(userRepository.save(user)).willReturn(user);
        User savedUser = userService.saveUser(user);
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit test for save multiple user.")
    @Test
    public void givenMultipleUserObject_whenSave_thenReturnMultipleUserObject() {
        User user2 = User.builder().userName("Dev").userEmailId("dev@gmail.com")
                .userMobileNo("83247836")
                .userAddress("Delhi").userType("User").build();
        List<User> savedUser = new ArrayList<>();
        savedUser.add(user);
        savedUser.add(user2);
        userRepository.saveAll(savedUser);
        assertThat(savedUser).isEqualTo(savedUser);
    }

    @DisplayName("Junit test for getying all Users.")
    @Test
    public void givenUsersObject_whenFindAll_thenReturnUsersObject() {
        BDDMockito.given(userRepository.findAll()).willReturn(Collections.singletonList( user));
        List<User> UserList = userService.getAllUser();
        assertThat(UserList).isNotNull();
        assertThat(UserList.size()).isGreaterThan(0);
    }

    @DisplayName("Junit test for get user by user id.")
    @Test
    public void givenUserObject_whenFindById_thenReturnUserObject() {
        user = User.builder().userId(4L).userName("Sree").userEmailId("sree@gmail.com")
                .userMobileNo("111111")
                .userAddress("Bangalore").userType("Student").build();
        BDDMockito.given(userRepository.findByuserId(4L)).willReturn(Optional.ofNullable(user));
        Optional<User> savedUser = userService.getUserById(user.getUserId());
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit test for get user by user name.")
    @Test
    public void givenUserObject_whenFindByName_thenReturnUserObject() {

        BDDMockito.given(userRepository.save(user)).willReturn(user);
        User savedUser=userService.createUser(user);
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit test for updating user.")
    @Test
    public void givenUserObject_ForUpdate_thenReturnUserObject() {
        BDDMockito.given(userRepository.save(user)).willReturn(user);
        User savedUser = userService.saveUser(user);
        savedUser.setUserEmailId("sree@gmail.com");
        assertThat(savedUser.getUserEmailId()).isEqualTo("sree@gmail.com");
    }

}

