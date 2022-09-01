package com.junit.test.repository;

import com.junit.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
