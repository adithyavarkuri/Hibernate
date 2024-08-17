package com.concepts.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Student;

public class CacheEvict {
	
	 public static void main(String[] args) { 
	        
	        ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
	       
		      
	        SessionFactory sessionFactory= ctx.getBean("sessionFactory",SessionFactory.class);
	        Session session = sessionFactory.openSession(); 
	        Transaction tx = session.beginTransaction(); 
	  
	     // Enable second-level cache for the entity 
	        sessionFactory.getCache().evictEntityRegion(Student.class); 
	        // insert 
	        
	        Student s =session.load(Student.class, new Integer(101));
	        session.update(s); 
	        
	     // Evict the cache for the entity 
	        sessionFactory.getCache().evictEntity(Student.class, s.getId()); 
	        tx.commit(); 
	        session.close();
	  
	    } 

}
