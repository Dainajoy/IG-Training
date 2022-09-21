package com.junit.test.SpringBootJunitTest;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRep;
@Test
@Order(1)
@Rollback(value=false)
    public void saveTest(){
        Employee emp=Employee.builder()

                .emp_name("Sita")
                .emp_age(26)
                .build();

        employeeRep.save(emp);
    Assertions.assertThat(emp.getEmpId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    @Rollback(value=false)
    public void getEmployee(){
    Employee employee=employeeRep.findById(5).get();
    Assertions.assertThat(employee.getEmpId()).isEqualTo(5);
    }
    @Test
    @Order(3)
    @Rollback(value=false)
    public void getEmployeeList(){
    List<Employee> empList=employeeRep.findAll();
    Assertions.assertThat(empList.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback(value=false)
    public void updateEmployee(){
        Employee employee=employeeRep.findById(4).get();
        employee.setEmp_age(32);
        Employee empUpdate=employeeRep.save(employee);
        Assertions.assertThat(empUpdate.getEmp_age()).isEqualTo(32);
    }
    @Test
    @Order(5)
    @Rollback(value=false)
    public void deleteEmployee(){
        Employee employee=employeeRep.findById(4).get();

        employeeRep.delete(employee);
        Employee emp1=null;
        Optional<Employee>optionalEmployee=employeeRep.findById(4);

        Assertions.assertThat(optionalEmployee.isPresent()).isEqualTo(false);
}
}
