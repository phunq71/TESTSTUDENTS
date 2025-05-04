package com.demo.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.entity.Student;



public interface StudentService {
	List<Student> findAll();
	Student findByEmail(String username);
	Student create(Student Student);
	void update(Student Student);
	void deleteByEmail(String username);
	Page<Student> searchByName(String keyword, Pageable pageable);
}
