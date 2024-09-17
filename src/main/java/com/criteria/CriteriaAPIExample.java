package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.Student;

public class CriteriaAPIExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria c = session.createCriteria(Student.class);
		
		//c.add(Restrictions.eq("city", "New Delhi"));
		//c.add(Restrictions.gt("id", 103));
		//c.add(Restrictions.lt("id", 103));
		c.add(Restrictions.ilike("certificate.course", "M%"));
		
		List<Student> students = c.list();
		
		for(Student st : students) {
			System.out.println(st);
		}
		
		session.close();
		sessionFactory.close();
	}
}
