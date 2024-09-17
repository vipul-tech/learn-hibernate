package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question question1 = new Question();
        question1.setQuestionId(2112);
        question1.setQuestion("What is Java?");
        
        Answer answer1 = new Answer();
        answer1.setAnswerId(343);
        answer1.setAnswer("Java is a object oriented programming language.");
        
        question1.setAnswer(answer1);
        answer1.setQuestion(question1);
        
        Question question2 = new Question();
        question2.setQuestionId(412);
        question2.setQuestion("What is Hibernate?");
        
        Answer answer2 = new Answer();
        answer2.setAnswerId(349);
        answer2.setAnswer("Hibernate is a java framework that simplifies the interaction between database.");
        
        question2.setAnswer(answer2);
        answer2.setQuestion(question2);
        
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(question1);
        session.save(question2);
        session.save(answer1);
        session.save(answer2);
        
        transaction.commit();
        
        Question fetchedQuestion = (Question)session.get(Question.class, 412);
        System.out.println(fetchedQuestion.getQuestion());
        System.out.println(fetchedQuestion.getAnswer().getAnswer());
        
        Question fetchedQuestion2 = (Question)session.get(Question.class, 2112);
        System.out.println(fetchedQuestion2.getQuestion());
        System.out.println(fetchedQuestion2.getAnswer().getAnswer());
        
        session.close();
        factory.close();
	}

}
