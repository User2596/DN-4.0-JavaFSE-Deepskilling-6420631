package com.example.hibernatevsjpa.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.hibernatevsjpa.Employee;

public class EmployeeDao {

	  public Integer addEmployee(Employee employee){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      
	  try {
	      tx = session.beginTransaction();
	      employeeID = (Integer) session.save(employee); 
	      tx.commit();
      } catch (HibernateException e) {
          if (tx != null) tx.rollback();
          	e.printStackTrace(); 
      } finally {
          session.close(); 
      }
      return employeeID;
  }
}
