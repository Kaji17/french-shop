package com.pevir.frenchshop.models;

public class LinkBody {

	private String path;
	private String origin;
	
	
	public LinkBody() {
		super();
	}
	public LinkBody(String path, String origin) {
		super();
		this.path = path;
		this.origin = origin;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
}
