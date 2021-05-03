package com.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		// file path is optional
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// create question object
		Question q1 = new Question();
		q1.setQuestionId(1);
		q1.setQuestion("What is Java. ?");

		// create answer object
		Answer ans = new Answer();
		ans.setAnswerId(101);
		ans.setAnswer("Java is programming language.");
		q1.setAnswer(ans);
		
		// create question object
		Question q2 = new Question();
		q2.setQuestionId(2);
		q2.setQuestion("What is collection framework. ?");

		// create answer object
		Answer ans1 = new Answer();
		ans1.setAnswerId(102);
		ans1.setAnswer("API to work with object in java.");
		q2.setAnswer(ans1);

		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// save
		session.save(q1);
		session.save(q2);
		session.save(ans);
		session.save(ans1);

		tx.commit();
		session.close();
		factory.close();
	}

}
