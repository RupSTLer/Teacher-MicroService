package com.stl.rupam.SchoolWebApp.teacher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.stl.rupam.SchoolWebApp.teacher.entity.Teacher;
import com.stl.rupam.SchoolWebApp.teacher.repo.TeacherRepo;
import com.stl.rupam.SchoolWebApp.teacher.repo.UserRepo;
import com.stl.rupam.SchoolWebApp.teacher.service.TeacherService;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = { TeacherServiceTest.class })
public class TeacherServiceTest {
	
	@Mock
	TeacherRepo teacherRepo;
	
	@Mock
	UserRepo userRepo;
	
	@InjectMocks
	TeacherService teacherService;
	
	//JUnit test for save teacher
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTeacherTest()
	{
		Teacher mockTeacher = new Teacher("SMT001", "ram123", "Ram@pass", "Ramesh", "rami@gmail.com");
		
		when(teacherRepo.save(mockTeacher)).thenReturn(mockTeacher);
		assertEquals(mockTeacher, teacherService.saveTeacher(mockTeacher));
		verify(teacherRepo, times(1)).save(mockTeacher);
	}
	
	//JUnit test for getTeacherByTeacherID
	@Test
	@Order(2)
	@Rollback(value = false)
	public void getTeacherByTeacherIDTest()
	{
		String teacherId = "SMT001";
		Teacher teacher = new Teacher(teacherId, "ram123", "Ram@pass", "Ramesh", "rami@gmail.com");
		
		when(teacherRepo.getTeacherByTeacherId(teacherId)).thenReturn(Optional.of(teacher));
		
		Teacher mockService = teacherService.getTeacherByTeacherId(teacherId);

		assertEquals(teacher, mockService);
		verify(teacherRepo, times(1)).getTeacherByTeacherId(teacherId);
	}
	
	//JUnit test for getListOfTeachers
	@Test
	@Order(3)
	@Rollback(value = false)
	public void getListOfTeachersTest()
	{
		List<Teacher> teacherList = new ArrayList<Teacher>();

		teacherList.add(new Teacher("SMS001", "ram123", "Ram@pass", "Ramesh", "rami@gmail.com"));
		teacherList.add(new Teacher("SMS002", "sam123", "Sam@pass", "Sama", "sam@gmail.com"));

		when(teacherRepo.findAll()).thenReturn(teacherList);   //mocking

		List<Teacher> mockService = teacherService.listAllTeachers();

		assertEquals(teacherList, mockService);
		verify(teacherRepo, times(1)).findAll();
	}
	 
	//JUnit test for update teacher details
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTeacherTest()
	{
		String teacherId = "SMT001";
		Teacher existingTeacher = new Teacher(teacherId, "ram123", "Ram@pass", "Ramesh", "ram@gmail.com");
		Teacher updatedTeacher = new Teacher(teacherId, "ram123", "Ram@pass", "Ramesh", "ramesh@gmail.com");

		when(teacherRepo.getTeacherByTeacherId(teacherId)).thenReturn(Optional.of(existingTeacher));
		when(teacherRepo.saveAndFlush(existingTeacher)).thenReturn(updatedTeacher);

		Teacher mockService = teacherService.updateTeacher(teacherId, existingTeacher);

		assertEquals(updatedTeacher, mockService);
		verify(teacherRepo, times(1)).getTeacherByTeacherId(teacherId);
		verify(teacherRepo, times(1)).saveAndFlush(existingTeacher);

	}
	

	//JUnit test for count teachers
	@Test
	@Order(5)
	@Rollback(value = false)
	public void countTeacherTest() {
		Long count = 5L;

		when(teacherRepo.count()).thenReturn(count);

		Long mockService = teacherService.countTeacher();

		assertEquals(count, mockService);
		verify(teacherRepo, times(1)).count();

	}
	
	//JUnit test for delete teacher
	@Test
	@Order(6)
	@Rollback(value = false)
	public void deleteTeacherTest()
	{
		String teacherId = "SMT001";
		
		Teacher teacher = new Teacher(teacherId, "ram123", "Ram@pass", "Ramesh", "ram@gmail.com");
		
		when(teacherRepo.getTeacherByTeacherId(teacherId)).thenReturn(Optional.of(teacher));  //mocking
		
		teacherService.deleteTeacher(teacherId);
		
		verify(teacherRepo,times(1)).getTeacherByTeacherId(teacherId);
		verify(teacherRepo,times(1)).deleteById(teacherId);;
	}

}

//https://stackoverflow.com/questions/53002232/spring-boot-datajpatest-unit-test-reverting-to-h2-instead-of-mysql
//https://www.springboottutorial.com/junit-tutorial-for-beginners


