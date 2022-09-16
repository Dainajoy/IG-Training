package com.springboot.librarymanagementsystem.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import com.springboot.librarymanagementsystem.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;




@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;


    @BeforeEach
    public void setUpUser() {
        user	=	User.builder().userName("Gowri").userAddress("79 Phase- II").userMobileNo("908765789")
                .userType("Student").userEmailId("gowri@gmail.com").build();
    }

    @DisplayName("Junit test for save user.")
    @Test
    public void givenUserObject_whenSave_thenReturnUser() {
        User users = User.builder().userName("Gowri").userAddress("79 Phase- II").userMobileNo("908765789")
                .userType("Student").userEmailId("gowri@gmail.com").build();
        userRepository.save(users);
        User found = userRepository.findById(users.getUserId()).get();
        assertEquals(users.getUserId(), found.getUserId());
    }

    @DisplayName("Junit test for saving multiple user.")
    @Test
    public void givenUserObject_whenSaveall_thenReturnUser() {
        userRepository.save(user);
        List<User> allBook = userRepository.findAll();
        assertThat(allBook.size()).isGreaterThanOrEqualTo(9);
    }

    @DisplayName("Junit Test for get All Employee.")
    @Test
    public void givenUserListObject_whenFindAll_thenReturnUserList() {

        userRepository.save(user);

        List<User> userList = userRepository.findAll();
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(9);
    }

    @DisplayName("Junit test for getting user by user id.")
    @Test
    public void givenUserObject_whenFindById_thenReturnUser() {
        userRepository.save(user);
        User savedUser = userRepository.findById(user.getUserId()).get();
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit test for getting user by name.")
    @Test
    public void givenUserObject_whenFindByName_thenReturnUser() {
        userRepository.save(user);
        List<User> savedUser = userRepository.findByuserName(user.getUserName());
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit test for update user")
    @Test
    public void givenUserObject_whenUpdate_thenReturnUser() {
        userRepository.save(user);
        User savedUser = userRepository.findById(user.getUserId()).get();
        savedUser.setUserEmailId("fran@gmail.com");
        savedUser.setUserMobileNo("99999911");
        User updateUser = userRepository.save(savedUser);
        assertThat(updateUser.getUserEmailId()).isEqualTo("rahul@gmail.com");
        assertThat(updateUser.getUserMobileNo()).isEqualTo("99999911");
    }

}

