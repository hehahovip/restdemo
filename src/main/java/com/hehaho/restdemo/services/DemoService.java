/**
 * 
 */
package com.hehaho.restdemo.services;

import java.util.List;

import com.hehaho.restdemo.beans.Person;

/**
 * @author Kevin
 *
 */
public interface DemoService {

	public String sayHello(String name);
	
	public void addPerson(Person p);
	public List<Person> getAllPerson();
	public void deletePerson(String id);
	
}
