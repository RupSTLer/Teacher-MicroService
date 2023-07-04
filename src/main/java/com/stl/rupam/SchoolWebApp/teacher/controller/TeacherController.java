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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/teacher")
//@PreAuthorize("hasAnyRole('User', 'Admin', 'Teacher')")
@Api(tags = "Teacher Service APIs", value = "Teacher Controller", description = "it will handle the web requests of teacher service")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@ApiOperation(value = "test teacher service")
	@GetMapping("/teacherApp")
	public String teacher_controller()
	{
		return "This is Teacher service application";
	}
	
	@ApiOperation(value = "Add a new Teacher into School Management System", notes = "returns a string when successfully added")
	@PostMapping("/addTeacher")
	public ResponseEntity<String> saveTeacher(@Valid @RequestBody Teacher teacher)
	{
		return new ResponseEntity<String>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update an existing teacher details", notes = "returns a string when successfully updated")
	@PutMapping("/{teacherId}")
	public ResponseEntity<String> updateTeacher(@Valid @PathVariable String teacherId, @RequestBody Teacher teacher)
	{
		return new ResponseEntity<String>(teacherService.updateTeacher(teacherId, teacher), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Fetch Teacher details by teacherId", notes = "returns the fetched teacher object")
	@GetMapping("/{teacherId}")
	public ResponseEntity<Teacher> getTeacherByTeacherID(@PathVariable String teacherId)
	{
		return new ResponseEntity<Teacher>(teacherService.getTeacherByTeacherId(teacherId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "List all the teachers present in the system", notes = "returns a list of teachers")
	@GetMapping("/listTeachers")
	public List<Teacher> listAllTeachers()
	{
		return teacherService.listAllTeachers();
	}
	
	@ApiOperation(value = "Delete a teacher by teacherId", notes = "returns a string when successfully deleted")
	@DeleteMapping("/{teacherId}")
	public ResponseEntity<String> deleteTeacher(@PathVariable String teacherId)
	{
		teacherService.deleteTeacher(teacherId);
		return new ResponseEntity<String>("Teacher deleted successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Count no of teachers present in system", notes = "returns the fetched count of teachers")
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

