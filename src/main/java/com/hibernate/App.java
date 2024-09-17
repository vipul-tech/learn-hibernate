package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
        System.out.println(factory.isOpen());
        
        //creating student object
        Student st = new Student();
        st.setId(103);
        st.setName("Sunny Kumar");
        st.setCity("Bengaluru");
        System.out.println(st);
        
        //creating address object
        
        Address ad = new Address();
        ad.setStreet("26, F Block, Bellandur");
        ad.setCity("Bengaluru");
        ad.setAddedDate(new Date());
        ad.setOpen(true);
        ad.setX(123.345);
        
        //reading image
        FileInputStream fis = new FileInputStream("src/main/java/1348624.jpeg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        fis.close();
        
        System.out.println("Done...");
    }
}
