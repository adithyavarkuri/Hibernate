package com.xml.concepts.mappings;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xml.pojo.Course;
import com.xml.pojo.Student;
import com.xml.util.HibernateUtil;

public class ManytoMany {
	
	public static void main(String[] args) {
		insert();
	}
	
	public static void insert() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student s1=new Student();
		s1.setStudentId(100);
		s1.setStudentName("James");
		s1.setMarks(98);

		Student s2=new Student();
		s2.setStudentId(101);
		s2.setStudentName("Lee");
		s2.setMarks(99);

		Course c1=new Course();
		c1.setCourseId(500);
		c1.setCourseName("Hibernate");
		c1.setDuration(7);

		Course c2=new Course();
		c2.setCourseId(501);
		c2.setCourseName("Java");
		c2.setDuration(30);

		Set s =new HashSet();
		      s.add(c1);
		      s.add(c2);

		s1.setCourses(s);
		s2.setCourses(s);

		    Transaction tx = session.beginTransaction();

		                      session.save(s1);
		                      session.save(s2);

		    tx.commit();

		    session.close();
		    System.out.println("Many To Many Bi-Directional is Done..!!");
	}

}
