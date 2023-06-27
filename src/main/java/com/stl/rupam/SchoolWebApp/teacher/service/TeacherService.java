package com.stl.rupam.SchoolWebApp.teacher.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stl.rupam.SchoolWebApp.teacher.entity.User;
import com.stl.rupam.SchoolWebApp.teacher.entity.Teacher;
import com.stl.rupam.SchoolWebApp.teacher.exception.ResourceNotFoundException;
import com.stl.rupam.SchoolWebApp.teacher.repo.TeacherRepo;
import com.stl.rupam.SchoolWebApp.teacher.repo.UserRepo;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepo teacherRepo;

	@Autowired
	private UserRepo userRepo;

	public String saveTeacher(Teacher teacher) {
		Long c = teacherRepo.count();
		String u = "SMT00" + (c + 1);
		teacher.setTeacherId(u);

		String tea = validateTeacher(teacher);

		if (tea == null) {
			Teacher t = teacherRepo.save(teacher);
			userRepo.save(new User(t.getUserName(), t.getPassword(), t.getTeacherId(), t.getName(), t.getAge(),
					t.getBirthDate(), t.getGender(), t.getAddress(), t.getPhoneNo(), t.getEmail(), t.getDepartment()));

			teacherRepo.setRole(t.getUserName(), "Teacher");
			
			return "Teacher added successfully";
		} 
		else {
			return tea;
		}

	}
	
	public String updateTeacher(String teacherId, Teacher teacher) {
		Teacher existingTeacher = teacherRepo.getTeacherByTeacherId(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with teacherId: " + teacherId));

		String tea = validateTeacherUpdate(teacher);

		if (tea == null) {
			Teacher t = teacherRepo.save(teacher);
			userRepo.save(new User(t.getUserName(), t.getPassword(), t.getTeacherId(), t.getName(), t.getAge(),
					t.getBirthDate(), t.getGender(), t.getAddress(), t.getPhoneNo(), t.getEmail(), t.getDepartment()));

			teacherRepo.setRole(t.getUserName(), "Teacher");
			
			return "Teacher details updated successfully";
		} 
		else {
			return tea;
		}
	}

	public String validateTeacher(Teacher teacher) {
		LocalDate minDate = LocalDate.of(1990, 1, 1);
		LocalDate maxDate = LocalDate.of(2000, 12, 31);
		LocalDate birthDate = teacher.getBirthDate();

		try {

			if (birthDate.isBefore(minDate) || birthDate.isAfter(maxDate)) {
				throw new IllegalArgumentException("Invalid date. Date must be in between 1990 to 2000");
			}

			List<Teacher> existingEmail = teacherRepo.findByEmail(teacher.getEmail());

			if (!existingEmail.isEmpty()) {
				throw new IllegalArgumentException("Email already exists");
			}

			List<Teacher> existingUserName = teacherRepo.findByUserName(teacher.getUserName());

			if (!existingUserName.isEmpty()) {
				throw new IllegalArgumentException("Username already exists");
			}

			List<Teacher> existingPhoneNo = teacherRepo.findByPhoneNo(teacher.getPhoneNo());

			if (!existingPhoneNo.isEmpty()) {
				throw new IllegalArgumentException("PhoneNo already exists");
			}

		} catch (Exception ex) {
			return ex.getMessage();
		}

		return null;
	}
	
	public String validateTeacherUpdate(Teacher teacher) {
		LocalDate minDate = LocalDate.of(1990, 1, 1);
		LocalDate maxDate = LocalDate.of(2000, 12, 31);
		LocalDate birthDate = teacher.getBirthDate();

		try {

			if (birthDate.isBefore(minDate) || birthDate.isAfter(maxDate)) {
				throw new IllegalArgumentException("Invalid date. Date must be in between 1990 to 2000");
			}

//			List<Teacher> existingEmail = teacherRepo.findByEmail(teacher.getEmail());
//
//			if (!existingEmail.isEmpty()) {
//				throw new IllegalArgumentException("Email already exists");
//			}
//
//			List<Teacher> existingUserName = teacherRepo.findByUserName(teacher.getUserName());
//
//			if (!existingUserName.isEmpty()) {
//				throw new IllegalArgumentException("Username already exists");
//			}
//
//			List<Teacher> existingPhoneNo = teacherRepo.findByPhoneNo(teacher.getPhoneNo());
//
//			if (!existingPhoneNo.isEmpty()) {
//				throw new IllegalArgumentException("PhoneNo already exists");
//			}

		} catch (Exception ex) {
			return ex.getMessage();
		}

		return null;
	}

	
	public Teacher getTeacherByTeacherId(String teacherId) {
		return teacherRepo.getTeacherByTeacherId(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with teacherId: " + teacherId));
	}


	public List<Teacher> listAllTeachers() {
		return teacherRepo.findAll();
	}

	
	public void deleteTeacher(String teacherId) {
		teacherRepo.getTeacherByTeacherId(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with teacherId: " + teacherId));
		teacherRepo.deleteById(teacherId);
		deleteTeacherUser(teacherId);
	}

	public Long countTeacher() {
		return teacherRepo.count();
	}

	
	public void deleteTeacherUser(String userID) {
		User existingTeacherUser = userRepo.getTeacherByUserID(userID)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with userID: " + userID));
		teacherRepo.deleteRole(existingTeacherUser.getUserName());
		userRepo.deleteUser(userID);
	}

}
