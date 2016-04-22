package com.lynn.service;

import com.lynn.dao.meta.User;
import com.lynn.meta.Person;

public interface PersonService extends BaseService<Person, Integer> {
	//判断登录
	boolean login(String userName, String password);
	User getUser(String userName);
}