package com.annotation.pojo;
import javax.persistence.*;

@Entity
@Table(name = "Infregularemployee")
@PrimaryKeyJoinColumn(name = "ID")
public class InfRegular_Employee extends InfEmployee {

	@Column(name = "salary")
	private float salary;

	@Column(name = "bonus")
	private int bonus;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
