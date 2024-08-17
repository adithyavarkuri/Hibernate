package com.xml.concepts.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.xml.pojo.Product;
import com.xml.util.HibernateUtil;

public class Criterias {

	public static void load() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Product.class);
		Criterion cn = Restrictions.gt("price", new Double(17000));
		crit.add(cn);
		List l = crit.list();
		System.out.println("List total size..._" + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Product p = (Product) it.next();
			System.out.println(p.getProductId());
			System.out.println(p.getProName());
			System.out.println(p.getPrice());
			System.out.println("-----------------");
		}

		session.close();

	}

	public static void sortorder() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Product.class);
		Criterion cn = Restrictions.gt("price", new Double(17000));
		crit.add(cn);
		crit.addOrder(Order.asc("price"));
		List l = crit.list();
		System.out.println("List total size..._" + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Product p = (Product) it.next();
			System.out.println(p.getProductId());
			// System.out.println(p.getProName());
			// System.out.println(p.getPrice());
		}

		session.close();

	}

	public static void projections() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Product.class);
		crit.setProjection(Projections.property("proName"));
		List l = crit.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}

		/*
		 * crit.setProjection(Projections.property("price")); List l=crit.list();
		 * Iterator it=l.iterator();
		 * 
		 * while(it.hasNext()) { Double s=(Double)it.next(); System.out.println(s); }
		 */

		session.close();
	}
	
	public static void multipleProjections() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Product.class);	

		ProjectionList p1=Projections.projectionList();
		         p1.add(Projections.property("proName"));
		         p1.add(Projections.property("price"));	

		crit.setProjection(p1);		

		List l=crit.list();

		Iterator it=l.iterator();

		while(it.hasNext())
		{
			Object ob[] = (Object[])it.next();
			System.out.println(ob[0]+"--------"+ob[1]);
		}

		session.close();
	}

}
