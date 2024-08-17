package com.xml.concepts.mappings;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xml.pojo.OOAddress;
import com.xml.pojo.OOStudent;
import com.xml.util.HibernateUtil;

public class OnetoOne {
	
	public static void main(String[] args) {
		insert();
		get();
	}
	
	public static void insert() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		OOStudent s=new OOStudent();
		s.setStudentId(100);
		s.setStudentName("java4s");

		OOAddress ad = new OOAddress();
		ad.setAddressId(509);
		ad.setCity("Carry");
		ad.setState("NC");
		ad.setOostudent(s);	

		    Transaction tx = session.beginTransaction();

		              session.save(ad);

		    tx.commit();

		    session.close();
	}
	
	public static void get() {
		Session session = HibernateUtil.getSessionFactory().openSession();	

        Object o = session.get(OOAddress.class, new Integer(100));
        OOAddress a = (OOAddress)o;
        System.out.println(a.getCity());

        OOStudent s=a.getOostudent();
        System.out.println(s.getStudentName());

		    session.close();
		    System.out.println("One to One is Done..!!");
	}

}
