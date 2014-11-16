/**
 * 
 */
package com.hehaho.restdemo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hehaho.restdemo.beans.Person;
import com.hehaho.restdemo.beans.Puppy;
import com.hehaho.restdemo.persistence.PersonDao;
import com.hehaho.restdemo.services.DemoService;

/**
 * @author Kevin
 *
 */
@Component
@Transactional
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
		for(Person person: list){
//			person.setPuppies(null);
			List<Puppy> puppies = person.getPuppies();
			
			for(Puppy p : puppies){
				System.out.println(p.getId());
				p.setPerson(null);
			}
		}
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
