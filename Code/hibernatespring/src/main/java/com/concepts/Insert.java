package com.concepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.entity.Student;

public class Insert { 
    public static void main(String[] args) { 
        
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml"); 
       
	      
        StudentDao studentDao=ctx.getBean("stDao",StudentDao.class); 
  
        // insert 
        Student s=new Student(102,"Nisha"); 
        studentDao.insert(s); 
  
    } 
}
