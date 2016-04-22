package com.lynn.service;

import java.util.List;

import com.lynn.dao.meta.Product;
import com.lynn.dao.meta.ProductList;
import com.lynn.meta.Content;

public interface ContentService extends BaseService<Content, Integer> {
	//获取所有商品
	public List<Content> getAllProductList();
	//获取用户商品
	public List<ProductList> getProductList(Integer userId) throws Exception;
	public Product getProduct(Integer productId, Integer userId) throws Exception;
	//插入
	public Product insertProduct(Product product) throws Exception;
	//修改
	public Product updateProduct(Product product) throws Exception;
	public Product selectProduct(Integer contentId) throws Exception;
}