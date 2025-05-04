package com.demo.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, String>{
	Page<Student> findByFullnameContainingIgnoreCase(String keyword, Pageable pageable);
}
