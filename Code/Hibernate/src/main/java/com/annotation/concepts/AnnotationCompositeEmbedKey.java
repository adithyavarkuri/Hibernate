package com.annotation.concepts;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.annotation.pojo.EmpIdEmbed;
import com.annotation.pojo.EmployeeCompositeEmbed;
import com.annotation.util.HibernateUtilAnnotation;

public class AnnotationCompositeEmbedKey {
	
public static void main(String[] args) {
	
	EmpIdEmbed emd1 = new EmpIdEmbed(1,1);
	EmpIdEmbed emd2 = new EmpIdEmbed(1,2);
	EmpIdEmbed emd3 = new EmpIdEmbed(1,3);
        
		EmployeeCompositeEmbed em1 = new EmployeeCompositeEmbed(emd1,"Mary Smith", 25);
		EmployeeCompositeEmbed em2 = new EmployeeCompositeEmbed(emd2,"John Aces", 32);
		EmployeeCompositeEmbed em3 = new EmployeeCompositeEmbed(emd3,"Ian Young", 29);
        
        System.out.println(" =======CREATE =======");
        create(em1);
        create(em2);
        create(em3);
        
        System.out.println(" =======READ =======");
        List<EmployeeCompositeEmbed> ems1 = read();
        for(EmployeeCompositeEmbed e: ems1) {
            System.out.println(e.toString());
        }
        
        /**
        
        System.out.println(" =======UPDATE =======");
        em1.setAge(44);
        em1.setName("Mary Rose");
        update(em1);
        System.out.println(" =======READ =======");
        List<EmployeeCompositeEmbed> ems2 = read();
        for(EmployeeCompositeEmbed e: ems2) {
            System.out.println(e.toString());
        }
        System.out.println(" =======DELETE ======= ");
        delete(em2.getId());
        System.out.println(" =======READ =======");
        List<EmployeeCompositeEmbed> ems3 = read();
        for(EmployeeCompositeEmbed e: ems3) {
            System.out.println(e.toString());
        }
        System.out.println(" =======DELETE ALL ======= ");
        deleteAll();
        System.out.println(" =======READ =======");
        List<EmployeeCompositeEmbed> ems4 = read();
        for(EmployeeCompositeEmbed e: ems4) {
            System.out.println(e.toString());
        }
        **/
    
}
	public static Integer create(EmployeeCompositeEmbed e) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + e.toString());
        return e.getId().getId();
    }
    public static List<EmployeeCompositeEmbed> read() {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<EmployeeCompositeEmbed> EmployeeCompositeEmbeds = session.createQuery("FROM EmployeeCompositeEmbed").list();
        session.close();
        System.out.println("Found " + EmployeeCompositeEmbeds.size() + " EmployeeCompositeEmbeds");
        return EmployeeCompositeEmbeds;
    }
    public static void update(EmployeeCompositeEmbed e) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        EmployeeCompositeEmbed em = (EmployeeCompositeEmbed) session.load(EmployeeCompositeEmbed.class, e.getId());
        em.setName(e.getName());
        em.setAge(e.getAge());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + e.toString());
    }
    public static void delete(Integer id) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        EmployeeCompositeEmbed e = findByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());
    }
    public static EmployeeCompositeEmbed findByID(Integer id) {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        EmployeeCompositeEmbed e = (EmployeeCompositeEmbed) session.load(EmployeeCompositeEmbed.class, id);
        session.close();
        return e;
    }
    
    public static void deleteAll() {
        Session session = HibernateUtilAnnotation.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM EmployeeCompositeEmbed ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all EmployeeCompositeEmbeds.");
    }

}
