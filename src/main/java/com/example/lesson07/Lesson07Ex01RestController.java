package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C : create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "김성준";
		String phoneNumber = "010-3866-9915";
		String email = "jt2302@naver.com";
		String dreamJob = "개발자";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
}