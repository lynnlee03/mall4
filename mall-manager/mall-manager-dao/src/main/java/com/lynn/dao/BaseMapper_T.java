package com.lynn.dao;

import java.util.List;

public interface BaseMapper_T<T> {
	int deleteByPrimaryKey(Integer id);
    int insert(T record);
	int insertSelective(T record);
	T selectByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(T record);
	int updateByPrimaryKeyWithBLOBs(T record);
	int updateByPrimaryKey(T record);
//	
//	//select
//		T selectOne(T record);
//		List<T> select(T record);
//		List<T> selectAll();
//		int selectCount(T record);
//		T selectByPrimaryKey(ID id);
//		//insert
//		int insert(T record);
//		int insertSelective(T record);
//		//update
//		int updateByPrimaryKey(T record);
//		int updateByPrimaryKeySelective(T record);
//		//delete
//		int delete(T record);
//		int deleteByPrimaryKey(ID id);
}
