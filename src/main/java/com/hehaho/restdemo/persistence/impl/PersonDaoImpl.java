/**
 * 
 */
package com.hehaho.restdemo.persistence.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hehaho.restdemo.beans.Person;
import com.hehaho.restdemo.beans.Puppy;
import com.hehaho.restdemo.persistence.PersonDao;

/**
 * @author kevin
 *
 */
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	/* (non-Javadoc)
	 * @see com.hehaho.restdemo.persistence.PersonDao#addPerson(com.hehaho.restdemo.beans.Person)
	 */
	@Override
	public void addPerson(Person p) {
		getHibernateTemplate().merge(p);

	}

	/* (non-Javadoc)
	 * @see com.hehaho.restdemo.persistence.PersonDao#getAllPerson()
	 */
	@Override
	public List<Person> getAllPerson() {
		List<Person> list = getHibernateTemplate().find("from Person p");
		return list;
	}

	/* (non-Javadoc)
	 * @see com.hehaho.restdemo.persistence.PersonDao#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String id) {
		Person p = new Person();
		p.setId(id);
		getHibernateTemplate().delete(p);

	}

}
