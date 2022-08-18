package com.java8.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAgeGreaterAndLessThan25 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(23445, "ram", 34, "M", "Sales", 2019, 35000);
        Employee emp2 = new Employee(56245, "Sita", 24, "F", "HR", 2020, 27000);
        Employee emp3 = new Employee(12445, "Dev", 48, "M", "Manager", 2014, 95000);
        Employee emp4 = new Employee(45445, "Ruth", 30, "F", "HR", 2019, 35600);
        Employee emp5 = new Employee(64445, "Krish", 28, "M", "Sales", 2021, 46800);
        Employee emp6 = new Employee(32594, "Abdul", 38, "M", "Manager", 2018, 89400);
        List<Employee> emplist = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
       Map<Boolean,List<Employee>> empGreaterThanLessThan25=
               emplist.stream().collect(Collectors.partitioningBy(e->e.getAge()>25));
       for(Map.Entry<Boolean,List<Employee>> empAge:empGreaterThanLessThan25.entrySet())
       {
           if(empAge.getKey()){
               System.out.println("Employee age greater than \n--------------");
           }else{
               System.out.println("Employee  age less than 25\n----------------");
           }
           for(Employee e:empAge.getValue()){
               System.out.println(e.getName());
           }
       }
    }
}
