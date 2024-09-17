package com.cascade;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping2.Author;
import com.mapping2.Book;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Book> books = new ArrayList<>();
		LocalDate localDate = LocalDate.of(1908, 5, 25);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date dob = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		Author a1 = new Author(102, "Mahadevi Verma", dob, books);
		
		Book b1 = new Book(21, "Hare Krishna", "1934", a1);
		Book b2 = new Book(22, "Hare Ram", "1931", a1);
		Book b3 = new Book(23, "Om Shree", "1946", a1);
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		Transaction tx = session.beginTransaction();
		
		session.save(a1);
//		session.save(b1);
//		session.save(b2);
//		session.save(b3);
		//saved using cascading (Code in Author class)
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}

}
