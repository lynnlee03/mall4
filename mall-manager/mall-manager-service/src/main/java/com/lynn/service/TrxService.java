package com.lynn.service;

import java.util.List;

import com.lynn.dao.meta.BuyList;
import com.lynn.meta.Trx;

public interface TrxService extends BaseService<Trx, Integer> {
	public List<BuyList> getBuyList(Integer id);
	public boolean buy(Integer contentId, Integer id);
}