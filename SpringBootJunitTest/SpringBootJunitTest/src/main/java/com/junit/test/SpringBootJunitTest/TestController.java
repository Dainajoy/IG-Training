package com.junit.test.SpringBootJunitTest;

import com.junit.test.SpringBootJunitTest.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public Employee firstPage() {

        Employee emp = new Employee();
        emp.setEmp_name("Ravi");

        emp.setEmpId(133);
        emp.setEmp_age(30);

        return emp;
    }
}
