package com.xml.concepts.composite;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xml.pojo.Product;
import com.xml.util.HibernateUtil;

public class CompositePrimaryKey {
	
	public static void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 

		Product p=new Product();

		p.setProductId(101);
                p.setProName("iPhone");
                p.setPrice(25000); 

	       Transaction tx=session.beginTransaction();
	          session.save(p);
	          System.out.println("Object Loaded successfully.....!!");
	       tx.commit();     

		session.close();
	}
	
	public static void load() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		//we need to pass both key to get datat from database
		Product p=new Product();

		p.setProductId(101);
                p.setProName("iPhone");

	    Object o=session.get(Product.class, p);
	    // here p must be an serializable object,

	    Product p1=(Product)o;

	    System.out.println("The price is: "+p1.getPrice());	    

		System.out.println("Object Loaded successfully.....!!");
		session.close();
		
	}

}
