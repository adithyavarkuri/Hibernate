package com.annotation.concepts;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.annotation.pojo.AccContract_Employee;
import com.annotation.pojo.AccEmployee;
import com.annotation.pojo.AccRegular_Employee;
import com.annotation.pojo.CngContract_Employee;
import com.annotation.pojo.CngEmployee;
import com.annotation.pojo.CngRegular_Employee;
import com.annotation.pojo.InfContract_Employee;
import com.annotation.pojo.InfEmployee;
import com.annotation.pojo.InfRegular_Employee;
import com.annotation.util.HibernateUtilAnnotation;

public class Inheritence {
	
	public static void main(String[] args) {
		//tablperhier();
		//tableperconcrete();
		tablesudclss();
	}
	
	public static void tablperhier() {
		Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();    
        
        AccEmployee e1=new AccEmployee();    
        e1.setName("Gaurav Chawla");    
            
        AccRegular_Employee e2=new AccRegular_Employee();    
        e2.setName("Vivek Kumar");    
        e2.setSalary(50000);    
        e2.setBonus(5);    
            
        AccContract_Employee e3=new AccContract_Employee();    
        e3.setName("Arjun Kumar");    
        e3.setPay_per_hour(1000);    
        e3.setContract_duration("15 hours");    
            
        session.persist(e1);    
        session.persist(e2);    
        session.persist(e3);    
            
        t.commit();    
        session.close();    
        System.out.println("success");  
		
	}
	
	public static void tableperconcrete() {
		Session session = HibernateUtilAnnotation.getSessionFactory().openSession();  
          
	        Transaction t=session.beginTransaction();  
	          
	        CngEmployee e1=new CngEmployee();  
	        e1.setName("Gaurav Chawla");  
	          
	        CngRegular_Employee e2=new CngRegular_Employee();  
	        e2.setName("Vivek Kumar");  
	        e2.setSalary(50000);  
	        e2.setBonus(5);  
	          
	        CngContract_Employee e3=new CngContract_Employee();  
	        e3.setName("Arjun Kumar");  
	        e3.setPay_per_hour(1000);  
	        e3.setContract_duration("15 hours");  
	          
	        session.persist(e1);  
	        session.persist(e2);  
	        session.persist(e3);  
	          
	        t.commit();  
	        session.close();  
	}
	
	public static void tablesudclss() {
		Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
		 Transaction t=session.beginTransaction();    
         
         InfEmployee e1=new InfEmployee();    
         e1.setName("Gaurav Chawla");    
             
         InfRegular_Employee e2=new InfRegular_Employee();    
         e2.setName("Vivek Kumar");    
         e2.setSalary(50000);    
         e2.setBonus(5);    
             
         InfContract_Employee e3=new InfContract_Employee();    
         e3.setName("Arjun Kumar");    
         e3.setPay_per_hour(1000);    
         e3.setContract_duration("15 hours");    
             
         session.persist(e1);    
         session.persist(e2);    
         session.persist(e3);    
             
         t.commit();    
         session.close();    
	}

}
