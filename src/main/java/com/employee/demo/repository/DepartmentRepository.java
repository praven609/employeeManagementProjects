package com.employee.demo.repository;

import com.employee.demo.document.Department;
import com.employee.demo.document.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Integer>{
}
