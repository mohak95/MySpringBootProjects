package com.app.techworm.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.techworm.main.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
