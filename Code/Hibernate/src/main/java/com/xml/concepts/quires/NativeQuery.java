package com.xml.concepts.quires;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.xml.pojo.Product;
import com.xml.util.HibernateUtil;

public class NativeQuery {
	
	public  static void load() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		SQLQuery qry = session.createSQLQuery("select * from products").addEntity(Product.class);
		List l = qry.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Product p = (Product) it.next();
			System.out.println(p.getProductId());
			System.out.println(p.getProName());
			System.out.println(p.getPrice());
			System.out.println("-----------------");
		}
	}

}
