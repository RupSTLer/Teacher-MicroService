package com.stl.rupam.SchoolWebApp.teacher.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String teacherId;
	
	@NotEmpty(message = "username is mandetory")
	@Pattern(regexp = "[a-zA-Z0-9]{4,}", message = "please give valid userName")
	private String userName;
	
	@NotEmpty(message = "password is mandetory")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}", message = "please give valid password")
	private String password;
	
	@NotEmpty(message = "name is mandetory")
	@Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please give valid name")
	private String name;
	
	@Email(message = "please give valid email")
	private String email;
	
	
	
	
	
	
	
	
//	@ManyToMany(mappedBy = "USER-ROLE")
//	private Set<Role> role;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "TEACHER_ROLE", 
//				joinColumns = { 
//						@JoinColumn(name = "TEACHER_ID", referencedColumnName = "id") 
//						}, 
//				inverseJoinColumns = {
//						@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")  
//						})
//	private Set<Role> role;

}

