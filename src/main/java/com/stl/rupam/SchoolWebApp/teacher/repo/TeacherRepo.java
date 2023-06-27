package com.stl.rupam.SchoolWebApp.teacher.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.stl.rupam.SchoolWebApp.teacher.entity.Teacher;


public interface TeacherRepo extends JpaRepository<Teacher, String> {
	
//	@Query(value = "select * from teachers where email=?", nativeQuery = true)
	List<Teacher> findByEmail(String email);
	
	List<Teacher> findByPhoneNo(String phoneNo);
	
	List<Teacher> findByUserName(String userName);
	
	Optional<Teacher> getTeacherByTeacherId(String teacherId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into user_role(user_id, role_id) values (?,?)", nativeQuery = true)
	void setRole(String userName, String user_role);
	
	@Transactional
	@Modifying
	@Query(value = "delete from user_role where user_id = ?", nativeQuery = true)
	void deleteRole(String userName);

}
