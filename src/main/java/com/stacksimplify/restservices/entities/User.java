package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;
//import org.springframework.hateoas.ResourceSupport;

//Entity 		// the classnames have changed--ResourceSupport changed to RepresentationModel
@Entity
@Table(name = "user")
public class User extends RepresentationModel {
	@Id
	@GeneratedValue
	private Long userid;

	@NotEmpty(message = "UserName is mandatory  field. Please provide username")
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	private String username;

	@Size(min = 2, message = "First name should have atleast 2 character")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstname;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "ROLE", length = 50, nullable = false)
	private String role;

	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;

	@OneToMany(mappedBy = "user") // For one user we can have multiple order
	private List<Order> orders; // so it is OneToMany relation

	// NO argument constructor
	public User() {

		// TODO Auto-generated constructor stub
	}

	// Fields constructor
	public User(Long userid,
			@NotEmpty(message = "UserName is mandatory  field. Please provide username") String username,
			@Size(min = 2, message = "First name should have atleast 2 character") String firstname, String lastname,
			String email, String role, String ssn, List<Order> orders) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
	}

	// Getters and Setters

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	// To string
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
	}

}
