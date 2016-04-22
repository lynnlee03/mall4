package com.lynn.dao;

import java.util.List;

import com.lynn.dao.meta.BuyList;
import com.lynn.meta.Trx;

import tk.mybatis.mapper.common.BaseMapper;

public interface TrxMapper extends BaseMapper<Trx> {
	public List<BuyList> getBuyList(Integer userId);
}