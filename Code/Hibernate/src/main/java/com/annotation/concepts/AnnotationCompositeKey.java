package com.annotation.concepts;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.annotation.pojo.EmployeeCompositePk;
import com.annotation.util.HibernateUtilAnnotation;

public class AnnotationCompositeKey {
	
public static void main(String[] args) {
        
	EmployeeCompositePk em1 = new EmployeeCompositePk(1,1,"Mary Smith", 25);
        EmployeeCompositePk em2 = new EmployeeCompositePk(1,2,"John Aces", 32);
        EmployeeCompositePk em3 = new EmployeeCompositePk(1,3,"Ian Young", 29);
        
        System.out.println(" =======CREATE =======");
        create(em1);
        create(em2);
        create(em3);
        
        System.out.println(" =======READ =======");
        List<EmployeeCompositePk> ems1 = read();
        for(EmployeeCompositePk e: ems1) {
            System.out.println(e.toString());
        }
        
        /**
        
        System.out.println(" =======UPDATE =======");
        em1.setAge(44);
        em1.setName("Mary Rose");
        update(em1);
        System.out.println(" =======READ =======");
        List<EmployeeCompositePk> ems2 = read();
        for(EmployeeCompositePk e: ems2) {
            System.out.println(e.toString());
        }
        System.out.println(" =======DELETE ======= ");
        delete(em2.getId());
        System.out.println(" =======READ =======");
        List<EmployeeCompositePk> ems3 = read();
        for(EmployeeCompositePk e: ems3) {
            System.out.println(e.toString());
        }
        System.out.println(" =======DELETE ALL ======= ");
        deleteAll();
        System.out.println(" =======READ =======");
        List<EmployeeCompositePk> ems4 = read();
        for(EmployeeCompositePk e: ems4) {
            System.out.println(e.toString());
        }
        **/
    
}
	public static Integer create(EmployeeCompositePk e) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + e.toString());
        return e.getId();
    }
    public static List<EmployeeCompositePk> read() {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<EmployeeCompositePk> EmployeeCompositePks = session.createQuery("FROM EmployeeCompositePk").list();
        session.close();
        System.out.println("Found " + EmployeeCompositePks.size() + " EmployeeCompositePks");
        return EmployeeCompositePks;
    }
    public static void update(EmployeeCompositePk e) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        EmployeeCompositePk em = (EmployeeCompositePk) session.load(EmployeeCompositePk.class, e.getId());
        em.setName(e.getName());
        em.setAge(e.getAge());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + e.toString());
    }
    public static void delete(Integer id) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        EmployeeCompositePk e = findByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());
    }
    public static EmployeeCompositePk findByID(Integer id) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        EmployeeCompositePk e = (EmployeeCompositePk) session.load(EmployeeCompositePk.class, id);
        session.close();
        return e;
    }
    
    public static void deleteAll() {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM EmployeeCompositePk ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all EmployeeCompositePks.");
    }

}
