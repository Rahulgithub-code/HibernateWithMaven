package com.oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToManyDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		// file path is optional
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// create question object
		QuestionA q1 = new QuestionA();
		q1.setQuestionId(1);
		q1.setQuestion("What is Java. ?");

		// create answer object
		AnswerA ans = new AnswerA();
		ans.setAnswerId(101);
		ans.setAnswer("Java is programming language.");
		ans.setQuestion(q1);

		// create answer object
		AnswerA ans1 = new AnswerA();
		ans1.setAnswerId(102);
		ans1.setAnswer("With the help of java we can create software's.");
		ans1.setQuestion(q1);

		// create answer object
		AnswerA ans2 = new AnswerA();
		ans2.setAnswerId(103);
		ans2.setAnswer("Java has different type of framework.");
		ans2.setQuestion(q1);
		
		List<AnswerA> list = new ArrayList<AnswerA>(); 
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		q1.setAnswers(list);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//save
//		session.save(q1);
//		session.save(ans);
//		session.save(ans1);
//		session.save(ans2);
		
		//fetch
		QuestionA questionA = (QuestionA) session.get(QuestionA.class, 1);
		System.out.println(questionA.getQuestion());
		for (AnswerA answerA : questionA.getAnswers()) {
			System.out.println(answerA.getAnswer());
		}
		
		
		tx.commit();
		session.close();
		factory.close();
		
	}

}
