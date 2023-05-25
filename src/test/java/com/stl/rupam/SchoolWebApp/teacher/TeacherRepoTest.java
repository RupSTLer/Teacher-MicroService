package com.stl.rupam.SchoolWebApp.teacher;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.stl.rupam.SchoolWebApp.teacher.entity.Teacher;
import com.stl.rupam.SchoolWebApp.teacher.repo.TeacherRepo;


//@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@EnableAutoConfiguration(exclude=AutoConfigureTestDatabase.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class TeacherRepoTest {
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	//JUnit test for save teacher
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTeacherTest()
	{
		Teacher teacher = Teacher.builder()
				.id(2L)
				.teacherId("SMT002")
				.userName("ram123")
				.password("ram@pass")
				.name("Ramesh")
				.email("ram@gmail.com")
				.build();
		
		teacherRepo.save(teacher);
		
		Assertions.assertThat(teacher.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
//	@Rollback(value = false)
	public void getTeacherTest()
	{
		Teacher teacher = teacherRepo.findById(3L).get();
		
		Assertions.assertThat(teacher.getId()).isEqualTo(3L);
	}
	
	@Test
	@Order(3)
//	@Rollback(value = false)
	public void getListOfTeachersTest()
	{
		
		List<Teacher> teachers = teacherRepo.findAll();
		
		Assertions.assertThat(teachers.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTeacherTest()
	{
		Teacher teacher = teacherRepo.findById(3L).get();
		
		teacher.setEmail("ramesh@gmail.com");
		
		Teacher teacherUpdated = teacherRepo.save(teacher);
		
		Assertions.assertThat(teacherUpdated.getEmail()).isEqualTo("ramesh@gmail.com");
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteTeacherTest()
	{
		Teacher teacher = teacherRepo.findById(3L).get();
		
		teacherRepo.delete(teacher);
		
//		studentRepo.deleteById(2L);
		
		Teacher teacher2 = null;
		
		Optional<Teacher> optionalTeacher = teacherRepo.findByEmail("ramesh@gmail.com");
		
		if(optionalTeacher.isPresent())
		{
			teacher2 = optionalTeacher.get();
		}
		
		Assertions.assertThat(teacher2).isNull();
	}

}

//https://stackoverflow.com/questions/53002232/spring-boot-datajpatest-unit-test-reverting-to-h2-instead-of-mysql
//https://www.springboottutorial.com/junit-tutorial-for-beginners


