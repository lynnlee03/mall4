package com.lynn.dao.meta;

public class BuyList {
	
	private Integer id;
	
	private String title;
	
	private String image;
	
	private Integer buyPrice;
	
	private Long buyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Integer buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Long getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Long buyTime) {
		this.buyTime = buyTime;
	}
	
	

}
