package com.example.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "callStudentFallback")
	public String getStudentInfo() {

		String response = restTemplate.exchange("http://localhost:8083/student/all", HttpMethod.GET, null, String.class)
				.toString();

		return "Successful Response of the student" + response;
	}

	public String callStudentFallback() {

		return "Student Fallback Error - Circuit Breaker Enabled.";
	}
}
