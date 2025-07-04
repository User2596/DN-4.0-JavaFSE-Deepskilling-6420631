package com.example.hibernatevsjpa.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.hibernatevsjpa.Employee;

@Component
public class SpringDataRun {

    private final EmployeeService service;

    @Autowired
    public SpringDataRun(EmployeeService service) {
        this.service = service;
    }

    public void addEmployee(Employee emp) {
        service.addEmployee(emp);
        System.out.println("Spring Data JPA - Employee saved");
    }
}