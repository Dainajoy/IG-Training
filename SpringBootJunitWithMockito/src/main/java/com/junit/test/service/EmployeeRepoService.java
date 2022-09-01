package com.junit.test.service;

import com.junit.test.model.Employee;
import com.junit.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRepoService  {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee emp){

        return employeeRepository.save(emp);
    }
    public List<Employee> getEmployee(){
        List<Employee>empList=employeeRepository.findAll();
        return empList;
    }
 public void deleteUser(Employee emp){
        employeeRepository.delete(emp);
 }
}
