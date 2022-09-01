package com.junit.test.controller;

import com.junit.test.model.Employee;
import com.junit.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Add Employee
    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);

    }
    @GetMapping("/get All Employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;

    }

    @GetMapping("/")
    public Employee firstPage() {

        Employee emp = new Employee();
        emp.setEmp_name("Ravi");

        emp.setEmpId(133);
        emp.setEmp_age(30);

        return emp;
    }

}
