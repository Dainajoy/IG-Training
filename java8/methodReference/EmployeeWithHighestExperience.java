package com.java8.methodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeWithHighestExperience {
    public static void main(String[] args) {
        Employee emp1 = new Employee(23445, "ram", 34, "M", "Sales", 2019, 35000);
        Employee emp2 = new Employee(56245, "Sita", 28, "F", "HR", 2020, 27000);
        Employee emp3 = new Employee(12445, "Dev", 48, "M", "Manager", 2014, 95000);
        Employee emp4 = new Employee(45445, "Ruth", 30, "F", "HR", 2019, 35600);
        Employee emp5 = new Employee(64445, "Krish", 28, "M", "Sales", 2021, 46800);
        Employee emp6 = new Employee(32594, "Abdul", 38, "M", "Manager", 2018, 89400);
        List<Employee> emplist = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        Employee highestExperience=emplist.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).
                findFirst().get();
        System.out.println("Employee with highest experience:"+highestExperience);


    }
}
