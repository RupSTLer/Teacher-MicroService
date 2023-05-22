package com.stl.rupam.SchoolWebApp.teacher.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String userName;
	
	private String password;
	
	private String name;
	
	private String email;
	
//	@ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
//	@Enumerated(EnumType.STRING)
//	@Transient
//	private Set<Role> role;
	
//	@Column(name = "full_name")
//	private String fullName;
//	
//	private String firstName;
//	
//	private String lastName;
//	
////	@Column(name = "gender")
//	private String gender;
//	
////	@Column(name = "email", nullable = false)
//	private String email;
//	
////	@Column(name = "phone_no")
//	private String phoneNo;
//	
////	@Column(name = "DOB", nullable = false)
//	private String DOB;
//	
////	@Column(name = "full_name")
//	private String address;
//	
////	@Column(name = "class")
//	private String classe;
//	
////	@Column(name = "full_name")
//	private String section;

	
	//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "USER_ROLE", 
//				joinColumns = { 
//						@JoinColumn(name = "ROLE_ID") 
//						}, 
//				inverseJoinColumns = {
//						@JoinColumn(name = "STUDENT_ID")  
//						})
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "STUDENT_ROLE", 
//				joinColumns = { 
//						@JoinColumn(name = "STUDENT_ID", referencedColumnName = "id") 
//						}, 
//				inverseJoinColumns = {
//						@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")  
//						})
//	private Set<Role> role;
	
	//////////////////////////////////////////////////////
	
//	private final List<LeaveApplication> leaveApplication;
//	
//	public Student(Long id, String name)
//	{
//		this.id = id;
//		
//		this.name = name;
//		
//		this.leaveApplication = new ArrayList<>();
//		
//	}
//	
//	public LeaveApplication addLeaveApplication(LeaveApplication leaveApplication)
//	{
//		leaveApplication.setId(id);
//		this.leaveApplication.add(leaveApplication);
//		return leaveApplication;
//	}
	
	
	
	
	

}
