package com.annotation.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(EmpIdclass.class)
@Table(name = "employeecompositepk")
public class EmployeeCompositePk  implements Serializable{
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Id
    @Column(name = "id1")
    private Integer id1;
    
    @Column(name = "name")
    private String name;
    
    @Column(name="age")
    private Integer age;
    
    public EmployeeCompositePk() {
    }
    public EmployeeCompositePk(Integer id,Integer id1, String name, Integer age) {
        this.id = id;
        this.id1 =id1;
        this.name = name;
        this.age = age;
    }
    
    public EmployeeCompositePk(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    
    public Integer getId1() {
		return id1;
	}
	public void setId1(Integer id1) {
		this.id1 = id1;
	}
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Employee: " + this.id + ", Id1: " + this.id1  + this.name + ", " + this.age; 
    }
    
}
