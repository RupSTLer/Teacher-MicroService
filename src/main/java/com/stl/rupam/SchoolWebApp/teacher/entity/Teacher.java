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
	
	@NotEmpty(message = "username not valid")
	private String userName;
	
	@NotEmpty(message = "password not valid")
	private String password;
	
	@NotEmpty(message = "name not valid")
	private String name;
	
	@Email(message = "email not valid")
//	@Pattern(regexp = "^([a-zA-Z0-9_\\\\-\\\\.]+)@([a-zA-Z0-9_\\\\-\\\\.]+)\\\\.([a-zA-Z]{2,5})$")
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

