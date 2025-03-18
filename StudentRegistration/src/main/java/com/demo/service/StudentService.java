package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.StudentDao;
import com.demo.entity.Student;
import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentDao Dao;

	public void saveStudent(Student s) {
		Dao.save(s);
	}

	public void deleteStudent(int id) {
		Dao.deleteById(id);
	}

	public Student update(int id) {
		return Dao.findById(id).get();

	}

	public List<Student> getAllStudents() {
		return Dao.findAll();
	}
}
