/**
 * 
 */
package com.hehaho.restdemo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Kevin
 *
 */
@Entity
@Table(name="Person")
public class Person {

	private String id;
	private String name;
	private int age;
	private String email;
	
	private List<Puppy> puppies;

	public Person() {
		this.puppies = new ArrayList<Puppy>();
	}

	@Id
	@Column(name="id", unique=true, nullable=false, length=36)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="name", nullable=false, length=45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="age" )
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	@Column(name="email", length=45)
	@Transient
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
	//@JoinTable(name="Puppy", joinColumns=@JoinColumn(name="id"), inverseJoinColumns=@JoinColumn(name="personId"))
	public List<Puppy> getPuppies() {
		return puppies;
	}

	public void setPuppies(List<Puppy> puppies) {
		this.puppies = puppies;
	}

}
