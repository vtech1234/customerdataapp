package com.java.login.bean;

public class LoginBean {
	

	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private int zip;
	private String state;
	private String country;
	private long phone ;
	private String userLoginId;
	private String password;
	
	
	
	
	
	
	
	
	public LoginBean() {
		super();
	}
	public LoginBean(String userLoginId, String password) {
		super();
		this.userLoginId = userLoginId;
		this.password = password;
	}
	public LoginBean(String firstname, String lastname, String address, String city, int zip, String state,
			String country, long phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.country = country;
		this.phone = phone;
	}
/*	public LoginBean(int partyid ,String firstname, String lastname, String address, String city, int zip, String state,
			String country, long phone ,String userLoginId, String password) {
		super();
		this.partyid=partyid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.userLoginId = userLoginId;
		this.password = password;
	}
	public LoginBean(int partyid ,String firstname, String lastname, String address, String city, int zip, String state,
			String country, long phone ) {
		super();
		this.partyid=partyid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.country = country;
		this.phone = phone;
		
	}*/
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
		
	}
	
	
	
	

