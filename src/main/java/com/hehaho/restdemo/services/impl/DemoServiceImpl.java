/**
 * 
 */
package com.hehaho.restdemo.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.hehaho.restdemo.beans.Person;
import com.hehaho.restdemo.persistence.PersonDao;
import com.hehaho.restdemo.services.DemoService;

/**
 * @author Kevin
 *
 */
@Component
public class DemoServiceImpl implements DemoService {

	private PersonDao personDao;
	
	public DemoServiceImpl() {
		super();
		System.out.println("DemoServiceImpl init...");
	}

	@Override
	public String sayHello(String name) {
		return "Hello " + name + "!";
	}

	@Override
	public void addPerson(Person p) {
		personDao.addPerson(p);
	}

	@Override
	public List<Person> getAllPerson() {
		List<Person> list = personDao.getAllPerson();
		return list;
	}

	@Override
	public void deletePerson(String id) {
		personDao.deletePerson(id);
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	@Autowired
	@Required
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
