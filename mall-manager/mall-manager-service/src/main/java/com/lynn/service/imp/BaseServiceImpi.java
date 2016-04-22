package com.lynn.service.imp;

import java.io.Serializable;
import java.util.List;

import com.lynn.service.BaseService;

import tk.mybatis.mapper.common.BaseMapper;

public abstract class BaseServiceImpi<T,ID extends Serializable> implements BaseService<T,ID> {
	private BaseMapper<T> baseMapper;

	@Override
	public T selectOne(T record) {
		// TODO Auto-generated method stub
		return baseMapper.selectOne(record);
	}

	@Override
	public List<T> select(T record) {
		// TODO Auto-generated method stub
		return baseMapper.select(record);
	}

	@Override
	public List<T> selectAll() {
		// TODO Auto-generated method stub
		return baseMapper.selectAll();
	}

	@Override
	public int selectCount(T record) {
		// TODO Auto-generated method stub
		return baseMapper.selectCount(record);
	}

	@Override
	public T selectByPrimaryKey(ID id) {
		// TODO Auto-generated method stub
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		// TODO Auto-generated method stub
		return baseMapper.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		// TODO Auto-generated method stub
		return baseMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return baseMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		// TODO Auto-generated method stub
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(T record) {
		// TODO Auto-generated method stub
		return baseMapper.delete(record);
	}

	@Override
	public int deleteByPrimaryKey(ID id) {
		// TODO Auto-generated method stub
		return baseMapper.deleteByPrimaryKey(id);
	}
	
}
