package com.stl.rupam.SchoolWebApp.teacher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.rupam.SchoolWebApp.teacher.entity.User;


public interface UserRepo extends JpaRepository<User, String> {

}
