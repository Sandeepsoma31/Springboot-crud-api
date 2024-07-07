package com.manage.users.managment.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(length = 15, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false, name = "user_name")
	private String userName;
	
	@Column(nullable = false)
	private String gender;
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//List to string 
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", userName=" + userName + ", gender="
				+ gender + "]";
	}
	
	
	
	
	
	

}
