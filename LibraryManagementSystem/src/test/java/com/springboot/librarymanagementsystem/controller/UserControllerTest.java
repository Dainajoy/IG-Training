package com.springboot.librarymanagementsystem.controller;

import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.http.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;

    @BeforeEach
    public void setUpUser() {
        user = User.builder().userName("Karthik").userEmailId("karthi@gmail.com").userMobileNo("7654345")
                .userAddress("Jammu").userType("Student").build();
    }


    @DisplayName("Junit test for creating new user using rest api")
    @Test
    public void givenUserObject_whenCreateUser_thenReturnSavedUser() throws Exception {
        given(userService.saveUser(any(User.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));


        ResultActions response = mockMvc.perform(post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        response.andDo(print()).
                andExpect(status().isCreated());

    }

    @DisplayName("Junit test for get all user rest api")
    @Test
    public void givenUserObjectList_whenGetAllUser_thenReturnUserList() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().userName("Ram").userEmailId("ram@gmail.com")
                .userMobileNo("8888889").userAddress("Chennai").userType("User").build());
        userList.add(User.builder().userName("Leela").userEmailId("leela@gmail.com")
                .userMobileNo("777734565").userAddress("Goa").userType("Student").build());
        BDDMockito.given(userService.getAllUser()).willReturn(userList);
        ResultActions response = mockMvc.perform(get("/getAllUser"));
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(userList.size())));
    }

    @DisplayName("Junit test for get user by id rest api")
    @Test
    public void givenUserObject_whenGetbyId_thenReturnUserObject() throws Exception {
        BDDMockito.given(userService.getUserById(user.getUserId())).willReturn(Optional.ofNullable(user));
        ResultActions response = mockMvc.perform(get("https://localhost:8081/getUserById/1", user.getUserId()));
        response.andExpect(status().isOk()).andDo(print());
    }

    @DisplayName("Junit test for get user by name rest api")
    @Test
    public void givenUserObject_whenGetbyname_thenReturnUserObject() throws Exception {
        BDDMockito.given(userService.getsUserByName(user.getUserName())).willReturn((List<User>) user);
        ResultActions response = mockMvc.perform(get("https://localhost:8081/getUserByName/Ram",
                user.getClass()));
        response.andExpect(status().isOk()).andDo(print());

    }


    @DisplayName("Junit test for update user rest api")
    @Test
    public void givenUserObject_whenUpdateUser_thenReturnUserObject() throws JsonProcessingException, Exception {
        Optional<User> savedUser = Optional.ofNullable(User.builder().userId(1L).userName("Marcel").userEmailId("ram@gmail.com")
                .userAddress("Chennai").userType("User").build());
        User updateUser = User.builder().userName("Ram").userEmailId("ram@gmail.com")
                .userAddress("Chennai").userType("User").build();

        BDDMockito.given(userService.getUserById(1l)).willReturn(savedUser);
        BDDMockito.given(userService.updateUser(any(User.class))).willAnswer(invocation -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(put("/updateUser").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateUser)));
        response.andExpect(status().isOk()).andDo(print());
//	   .andExpect(jsonPath("$.userAddress", is(updateUser.getUserAddress())));
    }

}

