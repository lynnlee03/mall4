package com.lynn.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lynn.dao.ContentMapper;
import com.lynn.dao.TrxMapper;
import com.lynn.dao.meta.Product;
import com.lynn.dao.meta.ProductList;
import com.lynn.meta.Content;
import com.lynn.meta.Trx;
import com.lynn.service.ContentService;
import com.lynn.util.CopyUtil;

@Service("contentService")
public class ContentServiceImpi  extends BaseServiceImpi<Content, Integer>  implements ContentService{
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private TrxMapper trxMapper;
	@Override
	public List<Content> getAllProductList() {
		return contentMapper.selectAll();
	}

	@Override
	public List<ProductList> getProductList(Integer userId) throws Exception {
		List<ProductList> productList = new ArrayList<ProductList>();	
		//for each content
		for(Content content: contentMapper.selectAll()){
			ProductList proList = new ProductList();
			CopyUtil.Copy(content, proList);
			if(userId != null){
				//get trx
				for(Trx trx1: trxMapper.selectAll()){
					if(trx1.getContentId() == content.getId()){
						proList.setIsBuy(true);
						proList.setIsSell(true);
					}
				}
			}
			productList.add(proList);
		}
//		System.out.println(productList.get(0).getId()+ " "+productList.get(0).getIsBuy() +
//				" " + productList.get(0).getIsSell());
		return productList;
	}

	@Override
	public Product getProduct(Integer productId, Integer userId) throws Exception {
		Product product = new Product();
		Trx trx = new Trx();
		//获取相应的内容信息--id,title,image,summary,detail,price
		Content content = contentMapper.selectByPrimaryKey(productId);
		CopyUtil.Copy(content, product);
		trx.setPersonId(userId);
		trx.setContentId(productId);
		List<Trx> trx1 = trxMapper.select(trx);
		if(trx1.size() != 0){
			//buyPrice
			product.setBuyPrice(trx1.get(0).getBuyPrice());
			product.setIsBuy(true);
			product.setIsSell(true);
		}
		return product;
	}

	@Override
	public Product insertProduct(Product product) throws Exception {
		Content content = new Content();
		CopyUtil.Copy(product, content);
		contentMapper.insertSelective(content);
		product.setId(content.getId());
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws Exception {
		Content content = new Content();
		CopyUtil.Copy(product, content);
		contentMapper.updateByPrimaryKey(content);
		product.setId(content.getId());
		return product;
	}

	@Override
	public Product selectProduct(Integer contentId) throws Exception {
		Content content = contentMapper.selectByPrimaryKey(contentId);
		Product product = new Product();
		CopyUtil.Copy(content, product);
		return product;
	}
}