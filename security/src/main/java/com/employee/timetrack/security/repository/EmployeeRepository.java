package com.employee.timetrack.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.employee.timetrack.security.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

	public Employee getEmployeeByEmployeeName(String name);
}
