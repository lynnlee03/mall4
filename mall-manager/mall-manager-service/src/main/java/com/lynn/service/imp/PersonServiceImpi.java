package com.lynn.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.dao.PersonMapper;
import com.lynn.dao.meta.User;
import com.lynn.meta.Person;
import com.lynn.service.PersonService;

@Service("personService")
public class PersonServiceImpi extends BaseServiceImpi<Person,Integer> implements PersonService{
	@Autowired
	private PersonMapper personMapper;

	@Override
	public boolean login(String userName, String password) {
		Person person = new Person();
		person.setUsername(userName);
		person.setPassword(password);
		//if find
		if(personMapper.selectOne(person) != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User getUser(String userName) {
		Person person = new Person();
		person.setUsername(userName);
		Person person1 = personMapper.selectOne(person);
		User user = new User();
		user.setUsername(person1.getNickname());
		user.setUsertype(person1.getUsertype());
		user.setId(person1.getId());
		return user;
	}	
}
