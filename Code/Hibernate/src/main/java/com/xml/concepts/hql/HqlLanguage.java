package com.xml.concepts.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xml.pojo.Product;
import com.xml.util.HibernateUtil;

public class HqlLanguage {

	public static void selectwholeob() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("from Product p");

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			Product p = (Product) o;
			System.out.println("Product id : " + p.getProductId());
			System.out.println("Product Name : " + p.getProName());
			System.out.println("Product Price : " + p.getPrice());
			System.out.println("----------------------");
		}
		session.close();

	}

	public static void selectpartiob() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("select p.productId,p.proName from Product p");

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o[] = (Object[]) it.next();

			System.out.println("Product id : " + o[0] + "Product Name : " + o[1]);

			System.out.println("----------------");
		}
		session.close();

	}

	public static void selectsingleval() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("select p.productId from Product p");

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.println("Product id : " + i.intValue());
			System.out.println("---------------------------");

		}
		session.close();

	}

	public static void runtimevallabel() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("from Product p where p.productId= :java4s");
		qry.setParameter("java4s", 101);

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			Product p = (Product) o;
			System.out.println("Product Name : " + p.getProName());
			System.out.println("Product Price : " + p.getPrice());
			System.out.println("---------------------------");

		}

	}

	public static void runtimevalquesmark() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("from Product p where p.productId= ?");
		qry.setParameter(0, 101);

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			Product p = (Product) o;
			System.out.println("Product Name : " + p.getProName());
			System.out.println("Product Price : " + p.getPrice());
			System.out.println("---------------------------");

		}
	}

	public static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("delete from Product p where p.productId=:java4s");
		qry.setParameter("java4s", 110);
		int res = qry.executeUpdate();

		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected due to delete query" + res);

		session.close();
	}

	public static void update() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery("update Product p set p.proName=? where p.productId=111");
		qry.setParameter(0, "updated..");
		int res = qry.executeUpdate();

		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected due to update query" + res);

		session.close();
	}

	public static void insert() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query qry = session.createQuery(
				"insert into Product(productId,proName,price) select i.itemId,i.itemName,i.itemPrice from Items i where i.itemId= ?");
		qry.setParameter(0, 600);
		int res = qry.executeUpdate();

		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected...," + res);

		session.close();
	}

}
