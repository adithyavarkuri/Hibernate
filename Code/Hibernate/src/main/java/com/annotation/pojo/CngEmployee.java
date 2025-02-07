package com.annotation.pojo;

import javax.persistence.*;

@Entity
@Table(name = "cngemployee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class CngEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
