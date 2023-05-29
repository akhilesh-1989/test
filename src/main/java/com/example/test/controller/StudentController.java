package com.example.test.controller;

import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Student;
import com.example.test.service.impl.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl service;
	
	@GetMapping(value="/student/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") Long id) {
		
		Student student = service.getStudentById(id);
		if(student == null) {
			throw new StudentNotFountException();
		}
		
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping(value="/student/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		
		List<Student> student = service.getAllStudents();
		if(student == null) {
			throw new StudentNotFountException();
		}
		
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping(value="/student/add/{id}/{name}")
	public ResponseEntity<String> addStudent(@PathVariable("id") Long id, @PathVariable("name") String name) {
		
		service.addStudent(id, name);
		
		
		return new ResponseEntity<>("Succesfully Added", HttpStatus.OK);
	}
}
