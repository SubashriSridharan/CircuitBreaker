package com.example.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.college.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	@Autowired
	CollegeService collegeService;
	
	@GetMapping("/students")
	public String getStudentInfo() {
		
		return collegeService.getStudentInfo();
	}
}
