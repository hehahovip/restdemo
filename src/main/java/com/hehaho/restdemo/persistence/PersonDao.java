/**
 * 
 */
package com.hehaho.restdemo.persistence;

import java.util.List;

import com.hehaho.restdemo.beans.Person;

/**
 * @author kevin
 *
 */
public interface PersonDao {

	public void addPerson(Person p);
	public List<Person> getAllPerson();
	public void deletePerson(String id);
	
}
