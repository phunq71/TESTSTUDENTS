package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpenController {	
	@GetMapping("/rest/studentManagement")
	public String getApp1(){
		return "Student";
	}
}
