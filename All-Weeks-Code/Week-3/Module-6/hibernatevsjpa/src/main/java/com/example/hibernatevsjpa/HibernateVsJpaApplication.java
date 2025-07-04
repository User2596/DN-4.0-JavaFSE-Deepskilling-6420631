package com.example.hibernatevsjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.hibernatevsjpa.hibernate.HibernateRun;
import com.example.hibernatevsjpa.springdata.SpringDataRun;

@SpringBootApplication
public class HibernateVsJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HibernateVsJpaApplication.class, args);

		HibernateRun hr = context.getBean(HibernateRun.class);
		Employee emp1 = new Employee();
		emp1.setName("Varun");
		emp1.setDepartment("CSE");
		hr.addEmployee(emp1);

		SpringDataRun sdr = context.getBean(SpringDataRun.class);
		Employee emp2 = new Employee();
		emp2.setName("Nikita");
		emp2.setDepartment("ECE");
		sdr.addEmployee(emp2);
	}
}
