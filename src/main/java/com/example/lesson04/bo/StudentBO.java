package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// input : parameter 4개
	// output : StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber,
			String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestmap 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// input: Student
	// output: x
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input : id
	// output : Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// update
	// input : id, dreamJob
	// output : StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터 조회 => StudentEntity
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// 엔티티의 데이터 값을 변경해놓는다.
		if (student != null) {
			student = studentRepository.save(student.toBuilder() // toBuilder는 기존 필드값은 유지하고 일부만 변경
			.dreamJob(dreamJob)
			.build());// 꼭 객체에 다시 저장
			
		}
		
		return student;
	}
	
	// delete
	// input : id
	// output : x
	public void deleteStudentById(int id) {
		// 방법 1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법 2)
		Optional<StudentEntity> studentOptioanl = studentRepository.findById(id);
		studentOptioanl.ifPresent(s -> studentRepository.delete(s));
	}
}
