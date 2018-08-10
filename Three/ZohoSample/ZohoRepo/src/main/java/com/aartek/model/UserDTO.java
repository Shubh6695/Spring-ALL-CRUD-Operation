package com.aartek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Step no:- 9(b) create Package com.aartek.model & UserDTO Class*/

/*Step no:- 11(c) make these Class Annotation Based */

@Entity
@Table(name="users")
public class UserDTO {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="F_NAME")
	private String fname;
	
	@Column(name="L_NAME")
	private String lname;
	
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="MOBILE_NO")
	private Long mobileno;
	
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

}
