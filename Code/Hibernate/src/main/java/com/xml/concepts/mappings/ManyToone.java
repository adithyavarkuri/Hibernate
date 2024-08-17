package com.xml.concepts.mappings;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xml.pojo.MoCustomer;
import com.xml.pojo.MoVendor;
import com.xml.util.HibernateUtil;

public class ManyToone {
	
	public static void main(String[] args) {
		//insert();
		//load();
		//loadall();
		delete();
	}
	
	public  static void insert() {
		Session session = HibernateUtil.getSessionFactory().openSession();		

		MoVendor v =new MoVendor();

		            v.setVendorId(101);
		            v.setVendorName("java4s");

		 MoCustomer c1=new MoCustomer();

		             c1.setCustomerId(504);
		             c1.setCustomerName("customer4");
		             c1.setParentObjects(v);

		             MoCustomer c2=new MoCustomer();

		             c2.setCustomerId(505);
		             c2.setCustomerName("customer5");
		             c2.setParentObjects(v);

		             MoCustomer c3=new MoCustomer();

		             c3.setCustomerId(506);
		             c3.setCustomerName("customer6");
		             c3.setParentObjects(v);           		             

		    Transaction tx = session.beginTransaction();

		                      session.save(c1);
		                      session.save(c2);
		                      session.save(c3);

		    tx.commit();
		    session.close();
	}
	
	public  static void load() {
		Session session = HibernateUtil.getSessionFactory().openSession();	

		Object o = session.get(MoCustomer.class, new Integer(506));
		MoCustomer c = (MoCustomer)o;

		System.out.println(c.getCustomerName());
		MoVendor v=c.getParentObjects();
		System.out.println(v.getVendorName()); 

		    session.close();
	}
	
	public  static void loadall() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry=session.createQuery("from MoCustomer c");

	    List l=qry.list();
	    Iterator it = l.iterator();
	    while(it.hasNext())
	    {
	    	Object o = it.next();
	    	MoCustomer c = (MoCustomer)o;
	    	System.out.println(c.getCustomerName());
	    	MoVendor v=c.getParentObjects();
	    	System.out.println(v.getVendorName());
	    }

	    session.close();
	}
	
	public static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Object o = session.get(MoCustomer.class, new Integer(506));
		MoCustomer c = (MoCustomer)o;		

		    Transaction tx = session.beginTransaction();
		                     session.delete(c);
		    tx.commit();

		    session.close();
		    System.out.println("many to one delete done..!!");
	}

}
