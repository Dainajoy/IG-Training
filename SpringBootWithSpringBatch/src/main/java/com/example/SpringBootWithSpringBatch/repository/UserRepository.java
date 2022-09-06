package com.example.SpringBootWithSpringBatch.repository;

import com.example.SpringBootWithSpringBatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
