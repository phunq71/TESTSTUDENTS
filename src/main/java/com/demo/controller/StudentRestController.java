package com.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;
import com.demo.service.StudentService;

@CrossOrigin("*")
@RestController
public class StudentRestController {
	@Autowired
	StudentService studentService;

//	@GetMapping("/rest/students")
//	public List<Student> getAll(){
//		return studentService.findAll();
//	}
	
	@GetMapping("/rest/students")
	public Page<Student> getPage(
	    @RequestParam(defaultValue = "") String keyword,
	    @RequestParam(defaultValue = "0") int page,
	    @RequestParam(defaultValue = "10") int size
	) {
	    Pageable pageable = PageRequest.of(page, size);
	    return studentService.searchByName(keyword, pageable);
	}
	
	@GetMapping("/rest/students/{email}")
	public Student getOne(@PathVariable("email") String email){
		return studentService.findByEmail(email);
	}
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@PostMapping("/rest/students")
	public Student post(@RequestBody Student student){
	    Student created = studentService.create(student);
	    messagingTemplate.convertAndSend("/topic/students", "created");
	    return created;
	}

	@PutMapping("/rest/students")
	public Student put(@RequestBody Student student){
	    studentService.update(student);
	    messagingTemplate.convertAndSend("/topic/students", "updated");
	    return student;
	}

	@DeleteMapping("/rest/students/{email}")
	public void delete(@PathVariable("email") String email){
	    studentService.deleteByEmail(email);
	    messagingTemplate.convertAndSend("/topic/students", "deleted");
	}

	


}
