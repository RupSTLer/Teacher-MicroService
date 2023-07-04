package com.stl.rupam.SchoolWebApp.teacher.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@NotNull(message = "please add valid age")
	@Positive(message = "age should be positive")
	@Min(value = 30, message = "age must be atleast 30")
	@Max(value = 50, message = "age must be less than 50")
	private int age;

//	@NotNull(message = "DOB is mandetory")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@NotEmpty(message = "gender is mandetory")
	private String gender;

	@NotEmpty(message = "address is mandetory")
	@Pattern(regexp = "^[a-zA-Z0-9 .,-]+$", message = "please add valid address")
	private String address;

	@NotEmpty(message = "phone no is mandetory")
	@Positive(message = "phoneNo sould be positive")
	@Pattern(regexp = "(0|91)?[6-9][0-9]{9}", message = "please add valid phone no")
	private String phoneNo;

	@NotEmpty(message = "email is mandetory")
	@Email(message = "please give valid email")
	private String email;
	
	@NotEmpty(message = "Department is mandetory")
	@Pattern(regexp = "[a-zA-Z]{3,}", message = "please add valid department")
	private String department;

	
	public Teacher(String teacherId,
			@NotEmpty(message = "username is mandetory") @Pattern(regexp = "[a-zA-Z0-9]{4,}", message = "please give valid userName") String userName,
			@NotEmpty(message = "password is mandetory") @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}", message = "please give valid password") String password,
			@NotEmpty(message = "name is mandetory") @Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please give valid name") String name,
			@NotEmpty(message = "email is mandetory") @Email(message = "please give valid email") String email) {
		super();
		this.teacherId = teacherId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}


	public Teacher(String teacherId,
			@NotEmpty(message = "username is mandetory") @Pattern(regexp = "[a-zA-Z0-9]{4,}", message = "please give valid userName") String userName,
			@NotEmpty(message = "password is mandetory") @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{5,}", message = "please give valid password") String password,
			@NotEmpty(message = "name is mandetory") @Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z ]+", message = "please give valid name") String name,
			LocalDate birthDate,
			@NotEmpty(message = "email is mandetory") @Email(message = "please give valid email") String email) {
		
		super();
		this.teacherId = teacherId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

	
}

