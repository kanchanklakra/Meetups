package com.meetups.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="member")
public class Member implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @Column(name = "email")
 private String email;
 
 @Column(name = "password")
 private String password;
 
 @Column(name = "company")
 private String company;
 
 @Column(name = "address")
 private String companyAddress;
 
 @Column(name = "mobile")
 private String mobile;
 
 @Column(name = "capabilities")
 private String capabilities;
 
 @Column(name = "experience")
 private Integer experience;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getCompanyAddress() {
	return companyAddress;
}

public void setCompanyAddress(String companyAddress) {
	this.companyAddress = companyAddress;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getCapabilities() {
	return capabilities;
}

public void setCapabilities(String capabilities) {
	this.capabilities = capabilities;
}

public Integer getExperience() {
	return experience;
}

public void setExperience(Integer experience) {
	this.experience = experience;
}
 
 



}
