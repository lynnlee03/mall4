package com.lynn.service.imp;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.dao.ContentMapper;
import com.lynn.dao.TrxMapper;
import com.lynn.dao.meta.BuyList;
import com.lynn.meta.Trx;
import com.lynn.service.TrxService;

@Service("trxService")
public class TrxServiceImpi  extends BaseServiceImpi<Trx, Integer>  implements TrxService{
	@Autowired
	private TrxMapper trxMapper;	
	@Autowired
	private ContentMapper contentMapper;
	@Override
	public List<BuyList> getBuyList(Integer id) {
		return trxMapper.getBuyList(id);
	}
	@Override
	public boolean buy(Integer contentId, Integer id) {
		Trx trx = new Trx();
		trx.setPersonId(id);
		trx.setContentId(contentId);
		trx.setBuyPrice(contentMapper.selectByPrimaryKey(contentId).getPrice().intValue());
		trx.setBuyTime(BigInteger.valueOf(System.currentTimeMillis()));
		if(trxMapper.insertSelective(trx) != 0){
			return true;
		}else{
			return false;
		}
	}	
}

