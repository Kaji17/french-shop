package com.pevir.frenchshop.models;

public class Article {

	private Integer id;
	private String name;
	private double price;
	private String image;
	private String origin;
	
	
	public Article() {
		super();
	}

	public Article(Integer id, String name, double price2, String image, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.price = price2;
		this.image = image;
		this.origin = origin;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
	
	
}
