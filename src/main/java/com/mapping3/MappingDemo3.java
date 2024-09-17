package com.mapping3;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo3 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		
		Employee e1 = new Employee();
		e1.setEmployeeId(11);
		e1.setEmployeeName("Mohit Kumar");
		
		Employee e2 = new Employee();
		e2.setEmployeeId(12);
		e2.setEmployeeName("Vipul Kumar");
		
		Project p1 = new Project();
		p1.setProjectId(101);
		p1.setProjectName("Chat Bot");
		
		Project p2 = new Project();
		p2.setProjectId(102);
		p2.setProjectName("Workflow Tracker");
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		
		List<Project> projects = new ArrayList<>();
		projects.add(p1);
		projects.add(p2);
		
		e1.setProjects(projects);
		p2.setEmployees(employees);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		transaction.commit();
		session.close();
		factory.close();
	}

}
