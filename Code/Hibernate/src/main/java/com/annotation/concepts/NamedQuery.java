package com.annotation.concepts;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.annotation.util.HibernateUtilAnnotation;

public class NamedQuery {
	public static void main(String[] args) {
		select();
	}

	public static void  select() {
		
		 Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
		   Query query = session.getNamedQuery("findByName"); 
		 List res =  query.list();
		 System.out.println("Total Number Of Records : " + res.size());
			Iterator it = res.iterator();

			while (it.hasNext()) {
				String i = (String) it.next();
				System.out.println("name : " + i.toString());
				System.out.println("---------------------------");

			}
			session.close();
		 
		
	}
}
