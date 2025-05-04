package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDAO;
import com.demo.entity.Student;
import com.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDAO dao;

	@Override
	public List<Student> findAll() {
		return dao.findAll();
	}

	@Override
	public Student findByEmail(String email) {
		return dao.findById(email).orElse(null);
	}

	@Override
	public Student create(Student student) {
		return dao.save(student);
	}

	@Override
	public void update(Student student) {
		dao.save(student);
	}

	@Override
	public void deleteByEmail(String email) {
		dao.deleteById(email);
	}
	
	@Override
    public Page<Student> searchByName(String keyword, Pageable pageable) {
        return dao.findByFullnameContainingIgnoreCase(keyword, pageable);
    }
}
