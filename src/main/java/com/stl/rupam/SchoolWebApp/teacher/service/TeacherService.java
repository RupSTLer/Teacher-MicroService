package com.stl.rupam.SchoolWebApp.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stl.rupam.SchoolWebApp.teacher.entity.Teacher;
import com.stl.rupam.SchoolWebApp.teacher.exception.ResourceNotFoundException;
import com.stl.rupam.SchoolWebApp.teacher.repo.TeacherRepo;


@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
//	public Teacher saveTeacher(Teacher teacher)
//	{
//		return teacherRepo.save(teacher);	
//	}
	
	public Teacher saveTeacher(Teacher teacher)
	{
		
		//checking duplicate entries via email
		try {
			
		teacherRepo.findByEmail(teacher.getEmail()).get();
		    
			
		}
		catch(Exception ex)
		{
//			ex.printStackTrace();
			return teacherRepo.save(teacher);
		}
		
		return null;
		
	}
	
	public List<Teacher> listAllTeachers()
	{
		return teacherRepo.findAll();
	}
	
	public Teacher getTeacherByID(Long id)
	{
		return teacherRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));
	}

	public Teacher updateTeacher(Teacher teacher, Long id)
	{
		Teacher existingTeacher = teacherRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));
		
//		existingTeacher.setId(teacher.getId());
		existingTeacher.setUserName(teacher.getUserName());
		existingTeacher.setName(teacher.getName());
//		existingTeacher.setPassword(getEncodedPassword(teacher.getPassword()));
		existingTeacher.setEmail(teacher.getEmail());
		
		teacherRepo.save(existingTeacher);
		return existingTeacher;
	}
	
	public void deleteTeacher(Long id)
	{
		teacherRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));
		teacherRepo.deleteById(id);
	}
	
	public Long countTeacher()
	{
		return teacherRepo.count();
	}
	
	
//	public String getEncodedPassword(String password) {
//		return passwordEncoder.encode(password);
//	}
//	
	
//	try {
//		Teacher s = new Teacher();
//		
//		s = teacherRepo.findByEmail(s.getEmail()).get();
//		
//		System.out.println(s);
//	}
//	catch(Exception ex)
//	{
//		
//	}

}
