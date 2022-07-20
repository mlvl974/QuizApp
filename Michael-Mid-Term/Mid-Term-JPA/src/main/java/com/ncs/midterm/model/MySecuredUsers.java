package com.ncs.midterm.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MySecuredUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Size(message = "cannot be null, cannot be less than 5 characters", min = 5)
	private String username;
	@NotNull
	@Size(message = "cannot be null, cannot be less than 5 characters", min = 5)
	private String password;
	@Min(message = "age cannot be less than 18", value = 18)
	private int age;
	@Max(message = "max pincode is 8 digits", value = 99999999)
	private long pincode;
	@NotNull
	private String role;

	public MySecuredUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MySecuredUsers(int id,
			@NotNull @Size(message = "cannot be null, cannot be less than 5 characters", min = 5) String username,
			@NotNull @Size(message = "cannot be null, cannot be less than 5 characters", min = 5) String password,
			@Min(message = "min age is 18", value = 18) int age,
			@Size(message = "max pincode is 8 digits") long pincode, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.pincode = pincode;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, password, pincode, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySecuredUsers other = (MySecuredUsers) obj;
		return age == other.age && id == other.id && Objects.equals(password, other.password)
				&& pincode == other.pincode && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "MySecuredUsers [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", pincode=" + pincode + ", role=" + role + "]";
	}

}// end class
