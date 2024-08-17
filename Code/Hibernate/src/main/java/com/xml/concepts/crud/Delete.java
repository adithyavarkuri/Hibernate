package com.xml.concepts.crud;

import org.hibernate.Session;

import com.xml.pojo.User;
import com.xml.util.HibernateUtil;

public class Delete {
	public static void delete() {



        Session session = HibernateUtil.getSessionFactory().openSession();
 
        Object a =session.load(User.class, new Integer(1));
        User user = (User) a;
        System.out.println("user name is "+user.getUsername());
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    
	
	
	}

}
