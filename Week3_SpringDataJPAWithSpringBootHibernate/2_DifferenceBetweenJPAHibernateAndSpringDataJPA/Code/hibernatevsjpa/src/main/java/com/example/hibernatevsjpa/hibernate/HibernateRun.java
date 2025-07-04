package com.example.hibernatevsjpa.hibernate;

import org.springframework.stereotype.Component;
import com.example.hibernatevsjpa.Employee;

@Component
public class HibernateRun {

	public void addEmployee(Employee emp) {
		Integer id = new EmployeeDao().addEmployee(emp);
		System.out.println("Hibernate - Employee saved with ID: " + id);
	}
}
