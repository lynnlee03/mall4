package com.lynn.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {
	//select
	T selectOne(T record);
	List<T> select(T record);
	List<T> selectAll();
	int selectCount(T record);
	T selectByPrimaryKey(ID id);
	//insert
	int insert(T record);
	int insertSelective(T record);
	//update
	int updateByPrimaryKey(T record);
	int updateByPrimaryKeySelective(T record);
	//delete
	int delete(T record);
	int deleteByPrimaryKey(ID id);
}