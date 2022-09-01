package com.junit.test.SpringBootJunitTest;


import com.junit.test.controller.TestController;
import com.junit.test.model.Employee;
import com.junit.test.repository.EmployeeRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeControllerTest {
    @InjectMocks
    private TestController empController;
    @Mock
    EmployeeRepository employeeRepository;
    @Test
    public void testAddEmployee() {

        Employee employee = new Employee(1, "giri", 34);
        empController.addEmployee(employee);
        assertNotNull(employee);
        verify(employeeRepository, times(1)).save(employee);
    }
    @Test
    public void testGetAllEmployees() {
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(4, "Sita", 26));
        empList.add(new Employee(5, "krish", 28));


        when(empController.getAllEmployees()).thenReturn(empList);
        List<Employee> empList1 = (List<Employee>) empController.getAllEmployees();
        assertThat(empList1).isNotNull();
        assertThat(empList1.size()).isEqualTo(2);

    }
}
