package com.xml.concepts.inheritence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xml.pojo.Cheque;
import com.xml.pojo.Cheque1;
import com.xml.pojo.Cheque2;
import com.xml.pojo.CreditCard;
import com.xml.pojo.CreditCard1;
import com.xml.pojo.CreditCard2;
import com.xml.util.HibernateUtil;

public class Inheritence {
	
	public static  void onetableInheritencce() {
		
		  Session session = HibernateUtil.getSessionFactory().openSession();

	        CreditCard c=new CreditCard();

	        c.setPaymentId(10);
	        c.setAmount(2500);
	        c.setCreditCardType("Visa");

	        Cheque c1=new Cheque();

	        c1.setPaymentId(11);
	        c1.setAmount(2600);
	        c1.setChequeType("ICICI");

	        Transaction tx = session.beginTransaction();
	        session.save(c);
	        session.save(c1);
	        System.out.println("Object saved successfully.....!!");
	        tx.commit();
	        session.close();
	}
	
	public static  void tablePerClassInheritencce() {
		
		  Session session = HibernateUtil.getSessionFactory().openSession();

	        CreditCard1 c=new CreditCard1();

	        c.setPaymentId(10);
	        c.setAmount(2500);
	        c.setCreditCardType("Visa");

	        Cheque1 c1=new Cheque1();

	        c1.setPaymentId(11);
	        c1.setAmount(2600);
	        c1.setChequeType("ICICI");

	        Transaction tx = session.beginTransaction();
	        session.save(c);
	        session.save(c1);
	        System.out.println("Object saved successfully.....!!");
	        tx.commit();
	        session.close();
	}
	public static  void tablePerConcreteClassInheritencce() {
		
		  Session session = HibernateUtil.getSessionFactory().openSession();

	        CreditCard2 c=new CreditCard2();

	        c.setPaymentId(10);
	        c.setAmount(2500);
	        c.setCreditCardType("Visa");

	        Cheque2 c1=new Cheque2();

	        c1.setPaymentId(11);
	        c1.setAmount(2600);
	        c1.setChequeType("ICICI");

	        Transaction tx = session.beginTransaction();
	        session.save(c);
	        session.save(c1);
	        System.out.println("Object saved successfully.....!!");
	        tx.commit();
	        session.close();
	}

}
