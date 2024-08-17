package com.annotation.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "employeecompositeembeded")
public class EmployeeCompositeEmbed  implements Serializable{
	@EmbeddedId
   private EmpIdEmbed id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name="age")
    private Integer age;
    
    public EmployeeCompositeEmbed() {
    }
    public EmployeeCompositeEmbed(EmpIdEmbed id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public EmployeeCompositeEmbed(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    
    
    public EmpIdEmbed getId() {
		return id;
	}
	public void setId(EmpIdEmbed id) {
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
        return "Employee: " + this.id.getId() + ", Id1: " + this.id.getId1()  + this.name + ", " + this.age; 
    }
    
}
