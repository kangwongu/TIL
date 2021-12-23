package com.fastcampus.app;

public class Order {
	private String name;
	private String address;
	private String email;
	private String phone;
	private String date;
	private String path;
	private String memo;
	private String product;
	private String pack;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	
	@Override
	public String toString() {
		return "Order [name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + ", date="
				+ date + ", path=" + path + ", memo=" + memo + ", product=" + product + ", pack=" + pack + "]";
	}
	
	
}
