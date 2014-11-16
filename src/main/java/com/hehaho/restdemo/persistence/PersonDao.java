/**
 * 
 */
package com.hehaho.restdemo.persistence;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hehaho.restdemo.beans.Person;

/**
 * @author kevin
 *
 */
@Transactional()
public interface PersonDao {

	public void addPerson(Person p);
	public List<Person> getAllPerson();
	public void deletePerson(String id);
	
}
