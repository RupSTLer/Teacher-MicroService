package com.stl.rupam.SchoolWebApp.teacher.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Data
public class User {
//	private Long id;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id
	@NotEmpty(message = "username is mandetory")
	@Pattern(regexp = "[a-zA-Z0-9]{4,}")
	private String userName;
	
//	@NotEmpty(message = "firstname is mandetory")
//	@Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name")
//	private String userFirstName;
	
//	@NotEmpty(message = "lastname is mandetory")
//	@Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please add valid name")
//	private String userLastName;
	
	@NotEmpty(message = "password is mandetory")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}")
	private String userPassword;
	
	public User(String userName, String password)
	{
		this.userName = userName;
		this.userPassword = password;
	}
	
	public User()
	{
		
	}


	
}