package com.example.bean;

public class CryptoInfo {
	private String name;
	private Float price;
	private Float rate;
	private String value;
	
	public CryptoInfo() {
		
	}
	public CryptoInfo(String name,Float price,Float rate,String value) {
		this.name=name;
		this.price=price;
		this.rate=rate;
		this.value=value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public void setValue(String value) {
		this.value=value;
	}
	public String getValue() {
		return value;
	}
	
	
	
}
