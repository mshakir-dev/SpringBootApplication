package com.mshakir.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Create the name of the table
@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -690010790881382828L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;
	@Column(nullable = false, length = 100)
	private String firstName;
	@Column(nullable = false, length = 100)
	private String lastName;
	@Column(nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 5)
	private int age;
	@Column(nullable = false, length = 100)
	private String encryptedPassword;
	private String coolStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getCoolStatus() {
		return coolStatus;
	}

	public void setCoolStatus(String coolStatus) {
		this.coolStatus = coolStatus;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", age=" + age + ", encryptedPassword=" + encryptedPassword + ", coolStatus="
				+ coolStatus + "]";
	}

}
