package com.tcs.ilp.model;

import javax.persistence.*;
@Entity
@Table(name="FQ_LOGIN")
public class FqLogin {
	
private String userType;

@Id
private String userName;
private String password;
private String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
