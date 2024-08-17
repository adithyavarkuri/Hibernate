package com.xml.concepts.mappings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xml.pojo.OmCustomer;
import com.xml.pojo.OmVendor;
import com.xml.util.HibernateUtil;

public class OnetoMaymapping {
	
	public static void main(String[] args) {
		insert();
		//delete();
		load();
	}
	public static void insert() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//parent object
		OmVendor v =new OmVendor();

		v.setVendorId(101);
		v.setVendorName("java4s");

		//creating 3 child objects
		OmCustomer c1=new OmCustomer();

		c1.setCustomerId(504);
		c1.setCustomerName("customer4");

		OmCustomer c2=new OmCustomer();

		c2.setCustomerId(505);
		c2.setCustomerName("customer5");

		OmCustomer c3=new OmCustomer();

		c3.setCustomerId(506);
		c3.setCustomerName("customer6");

		// adding child objects to set, as we taken 3rd property set in parent
		Set s=new HashSet();

		s.add(c1);
		s.add(c2);
		s.add(c3);

		v.setChildren(s);

		Transaction tx = session.beginTransaction();

		session.save(v);

		tx.commit();
		session.close();
		
	}
	//Deleting Single Parent Object With All Child
	public static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Object o = session.get(OmVendor.class, new Integer(101));
		OmVendor v = (OmVendor)o;

		Transaction tx = session.beginTransaction();
		session.delete(v);
		tx.commit();

		session.close();
		System.out.println("One To Many is Done for deleting..!!");
	}
	
	public  static void load() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Object o=session.get(OmVendor.class, new Integer(101));
		OmVendor v=(OmVendor)o;
		System.out.println(v.getVendorId());
		System.out.println(v.getVendorName());

		Set s=v.getChildren();
		Iterator it = s.iterator();

		while(it.hasNext())
		{

		Object o1 = it.next();
		OmCustomer c = (OmCustomer) o1;
		System.out.println("---------------------------");
		System.out.println("Customer objects...");
		System.out.println("---------------------------");
		System.out.println(c.getCustomerId());
		System.out.println(c.getCustomerName());
		System.out.println(c.getForevenId());
		System.out.println("---------------------------");
		}

		session.close();
		System.out.println("One To Many is Done for selecting.....!");
	}

}
