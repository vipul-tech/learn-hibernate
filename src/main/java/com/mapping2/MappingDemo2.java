package com.mapping2;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo2 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Author author = new Author();
        author.setAuthorId(101);
        author.setAuthorName("Ramdhari Singh Dinkar");
        LocalDate localDate = LocalDate.of(1908, 5, 25);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        author.setBithDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
        
        List<Book> books = new ArrayList<Book>();
        
        Book book1 = new Book();
        book1.setBookId(11);
        book1.setAuthor(author);
        book1.setPublicationYear("1952");
        book1.setTitle("Rashmirathi");
        
        Book book2 = new Book();
        book2.setBookId(12);
        book2.setAuthor(author);
        book2.setPublicationYear("1965");
        book2.setTitle("Kurukshetra");
        
        Book book3 = new Book();
        book3.setBookId(13);
        book3.setAuthor(author);
        book3.setPublicationYear("1962");
        book3.setTitle("Bharat Bhakti");
        
        books.add(book1);
        books.add(book2);
        books.add(book3);
        
        author.setBooks(books);
        
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(author);
        
        transaction.commit();
        
        Author a = (Author)session.get(Author.class, 101);
        System.out.println(a.getAuthorId());
        System.out.println(a.getAuthorName());
        
        //lazy and eager loading
        System.out.println(a.getBooks().size());
        
        for(Book b : a.getBooks()) {
        	System.out.println(b.getTitle());
        }
        
        session.close();
        factory.close();
	}

}
