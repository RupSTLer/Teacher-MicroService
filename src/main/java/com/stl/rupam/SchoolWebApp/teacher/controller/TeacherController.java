package com.stl.rupam.SchoolWebApp.teacher.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.stl.rupam.SchoolWebApp.teacher.entity.Student;
import com.stl.rupam.SchoolWebApp.teacher.entity.Teacher;
import com.stl.rupam.SchoolWebApp.teacher.service.TeacherService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/teacher")
//@PreAuthorize("hasAnyRole('User', 'Admin', 'Teacher')")
public class TeacherController {
	
//	@Autowired
//	private JwtUtil jwtutil;
	
	@Autowired
	private TeacherService teacherService;
	
//	@Autowired
//	private RestTemplate rest;
	
//	@Autowired
//	private MessageRepo msgRepo;
	
	@GetMapping("/")
	public String teacher_controller()
	{
		return "This is teacher controller";
	}
	
	@GetMapping("/listTeachers")
	public List<Teacher> listAllTeachers()
	{
		return teacherService.listAllTeachers();
	}
	
	@PostMapping("/addTeacher")
	public ResponseEntity<Teacher> saveTeacher(@Valid @RequestBody Teacher teacher)
	{
		return new ResponseEntity<Teacher>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getTeacherByID(@PathVariable("id") Long id)
	{
		return new ResponseEntity<Teacher>(teacherService.getTeacherByID(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable("id") Long id)
	{
		return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher, id), HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long id)
	{
		teacherService.deleteTeacher(id);
		return new ResponseEntity<String>("Teacher deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/countTeacher")
	public ResponseEntity<Long> countTeacher() {
		Long n1 = teacherService.countTeacher();
		return new ResponseEntity<Long>(n1, HttpStatus.OK);
	}
	
	//call the student microservice to get the student assigned to this teacher
//	@GetMapping("/{id}")
//	public ResponseEntity<Teacher> getTeacher(@PathVariable String id)
//	{
//		Student student = rest.getForObject("http://locahost:9003/student?id=" + id, Student.class);
//		
//		Teacher teacher = new Teacher(id, student);
//		
//		return ResponseEntity.ok(teacher);
//	}
//	
	
//	@GetMapping("/getMessage")
//	public List<MessageToTeacher> getMessage()
//	{
//		return msgRepo.findAll();
//	}
//	
	
	


}
