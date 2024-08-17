package com.xml.concepts.mappings;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xml.pojo.BomCustomer;
import com.xml.pojo.BomVendor;
import com.xml.util.HibernateUtil;

public class Bionetomany {
	
	public static void main(String[] args) {
		insert();
	}
	
	
	public static void insert() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		BomVendor v =new BomVendor();
		            v.setVendorId(101); 
		            v.setVendorName("java4s");

		 BomCustomer c1=new BomCustomer();
		             c1.setCustomerId(504);
		             c1.setCustomerName("customer4");

		             BomCustomer c2=new BomCustomer();

		             c2.setCustomerId(505);
		             c2.setCustomerName("customer5");           

		             BomCustomer c3=new BomCustomer();

		             c3.setCustomerId(506);
		             c3.setCustomerName("customer6");

		   // one-to-many
		   Set s=new HashSet();

				        s.add(c1);
				        s.add(c2);
				        s.add(c3);		        

		              v.setChildren(s);

		   // many-to-one          

		     c1.setParentObjets(v);
		     c2.setParentObjets(v);
		     c3.setParentObjets(v);

		    Transaction tx = session.beginTransaction();

                                      session.save(c1);
		                      //session.save(v);

		    tx.commit();

		    session.close();
		    System.out.println("One To Many Bi-Directional is Done..!!");
	}

}
