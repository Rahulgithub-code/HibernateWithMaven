package com.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		// file path is optional
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(34);
		e1.setEname("Rahul");
		
		e2.setEid(35);
		e2.setEname("Vipul");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(101);
		p1.setPname("Hospital management");
		
		p2.setPid(102);
		p2.setPname("ChatBot");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		e2.setProjects(list2);
		p2.setEmps(list1);
		p1.setEmps(list1);
		
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		
		//save
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		transaction.commit();
		session.close();
		factory.close();
		
	}

}
