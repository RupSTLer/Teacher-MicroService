package com.stl.rupam.SchoolWebApp.teacher.service;

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

	public Teacher saveTeacher(Teacher teacher) {
		Long c = teacherRepo.count();
		String u = "SMT00" + (c+1);
		teacher.setTeacherId(u);

		// checking duplicate entries via email
		try {

			teacherRepo.findByEmail(teacher.getEmail()).get();

		} catch (Exception ex) {
//			ex.printStackTrace();
			
			Teacher t = teacherRepo.save(teacher);
			userRepo.save(new User(t.getUserName(), t.getPassword(), t.getTeacherId(), t.getName(), t.getAge(), t.getBirthDate(), t.getGender(), t.getAddress(), t.getPhoneNo(), t.getEmail(), t.getDepartment()));
			
			teacherRepo.setRole(t.getUserName(), "Teacher");
			return t;
		}

		return null;

	}

	public List<Teacher> listAllTeachers() {
		return teacherRepo.findAll();
	}

	public Teacher getTeacherByTeacherId(String teacherId) {
		return teacherRepo.getTeacherByTeacherId(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with teacherId: " + teacherId));
	}

	public Teacher updateTeacher(String teacherId, Teacher teacher) {
		Teacher existingTeacher = teacherRepo.getTeacherByTeacherId(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with teacherId: " + teacherId));

		return teacherRepo.saveAndFlush(teacher);
	}

	public void deleteTeacher(String teacherId) {
		teacherRepo.getTeacherByTeacherId(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with teacherId: " + teacherId));
		teacherRepo.deleteById(teacherId);
	}

	public Long countTeacher() {
		return teacherRepo.count();
	}

}
