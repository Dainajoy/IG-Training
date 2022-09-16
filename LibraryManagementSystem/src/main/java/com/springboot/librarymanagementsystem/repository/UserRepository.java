package com.springboot.librarymanagementsystem.repository;


import com.springboot.librarymanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users_info u where u.user_name=?", nativeQuery = true)
    public List<User> findByuserName(String name);

    @Query(value = "select * from users_info u where u.user_id=?", nativeQuery = true)
    public Optional<User> findByuserId(Long value);
}
