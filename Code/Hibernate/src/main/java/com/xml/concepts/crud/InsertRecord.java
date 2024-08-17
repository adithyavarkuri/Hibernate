package com.xml.concepts.crud;

import java.util.Date;

import org.hibernate.Session;

import com.xml.pojo.User;
import com.xml.util.HibernateUtil;

public class InsertRecord {
	
	public static void insert() {

        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();
        User user = new User();
 
        user.setUserId(2);
        user.setUsername("Mukesh");
        user.setCreatedBy("Google");
        user.setCreatedDate(new Date());
 
        session.save(user);
        session.getTransaction().commit();
        session.close();
 
    
	}

}
