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
	
	@GetMapping("/teacherApp")
	public String teacher_controller()
	{
		return "This is Teacher service application";
	}
	
	@PostMapping("/addTeacher")
	public ResponseEntity<String> saveTeacher(@Valid @RequestBody Teacher teacher)
	{
		return new ResponseEntity<String>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
	}
	
	@PutMapping("/{teacherId}")
	public ResponseEntity<String> updateTeacher(@Valid @PathVariable String teacherId, @RequestBody Teacher teacher)
	{
		return new ResponseEntity<String>(teacherService.updateTeacher(teacherId, teacher), HttpStatus.OK);
	}
	
	@GetMapping("/{teacherId}")
	public ResponseEntity<Teacher> getTeacherByTeacherID(@PathVariable String teacherId)
	{
		return new ResponseEntity<Teacher>(teacherService.getTeacherByTeacherId(teacherId), HttpStatus.OK);
	}
	
	@GetMapping("/listTeachers")
	public List<Teacher> listAllTeachers()
	{
		return teacherService.listAllTeachers();
	}
	
	@DeleteMapping("/{teacherId}")
	public ResponseEntity<String> deleteTeacher(@PathVariable String teacherId)
	{
		teacherService.deleteTeacher(teacherId);
		return new ResponseEntity<String>("Teacher deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/countTeacher")
	public ResponseEntity<Long> countTeacher() {
		Long n1 = teacherService.countTeacher();
		return new ResponseEntity<Long>(n1, HttpStatus.OK);
	}
	

}



//call the student microservice to get the student assigned to this teacher
//@GetMapping("/{id}")
//public ResponseEntity<Teacher> getTeacher(@PathVariable String id)
//{
//	Student student = rest.getForObject("http://locahost:9003/student?id=" + id, Student.class);
//	
//	Teacher teacher = new Teacher(id, student);
//	
//	return ResponseEntity.ok(teacher);
//}
//

