package com.test.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.security.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
