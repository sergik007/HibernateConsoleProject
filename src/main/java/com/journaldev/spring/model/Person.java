package com.journaldev.spring.model;

import org.hibernate.annotations.ListIndexBase;

import javax.persistence.*;

@Entity
@Table(name="Person", schema = "test")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Basic
	@Column(name = "name")
	private String name;

	@Basic
	@Column(name = "country")
	private String country;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country;
	}
}
