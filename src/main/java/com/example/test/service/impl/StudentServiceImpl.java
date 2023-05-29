package com.example.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.entity.StudentEntity;
import com.example.test.model.Student;
import com.example.test.repos.StudentRepository;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentRepository repo;
	
	private static Map<Long, Student> studentMap;
	
	static {
		studentMap = new HashMap<>();
		Student st = new Student();
		st.setId(1l);
		st.setName("default");
		studentMap.put(1l, st);
	}

	public Student getStudentById(long id) {

		return studentMap.get(id);
	}
	
	public List<Student> getAllStudents() {

		List<Student> students = studentMap.values().stream().collect(Collectors.toList());
		
		
		return students;
	}
	
	public void addStudent(Long id, String name) {
		Student st = new Student();
		st.setId(id);
		st.setName(name);
		studentMap.put(id, st);
	}
}
