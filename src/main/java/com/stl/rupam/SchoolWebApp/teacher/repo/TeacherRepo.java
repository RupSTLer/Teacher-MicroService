package com.stl.rupam.SchoolWebApp.teacher.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.rupam.SchoolWebApp.teacher.entity.Teacher;


public interface TeacherRepo extends JpaRepository<Teacher, Long> {
	
	@Query(value = "select * from teachers where email=?", nativeQuery = true)
	Optional<Teacher> findByEmail(String email);

}
