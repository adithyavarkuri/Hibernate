package com.xml.concepts.crud;

import java.util.Date;

import org.hibernate.Session;

import com.xml.pojo.User;
import com.xml.util.HibernateUtil;

public class Update {
	
	public static void updatewithoutcall() {



        Session session = HibernateUtil.getSessionFactory().openSession();
 
        Object a =session.load(User.class, new Integer(1));
        User user = (User) a;
        session.getTransaction().begin();
        System.out.println("user name is "+user.getUsername());
        user.setUsername("adithyachanged");
        user.setUsername("adithyachangedd");
        user.setUsername("adithyachangeddf");
        session.getTransaction().commit();
        session.close();
    
	
	
	}
	
	public static void updatewithcall() {



        Session session = HibernateUtil.getSessionFactory().openSession();
 
        Object a =session.load(User.class, new Integer(1));
        
        User user = new User();
        user.setUserId(1);
        user.setUsername("adithay2");
        user.setCreatedBy("varkuri");
        user.setCreatedDate(new Date());
        
        session.getTransaction().begin();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    
	
	
	}

}
