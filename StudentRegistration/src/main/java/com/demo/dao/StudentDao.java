package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
