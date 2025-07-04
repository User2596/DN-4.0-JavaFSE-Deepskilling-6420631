package com.example.hibernatevsjpa.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hibernatevsjpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
