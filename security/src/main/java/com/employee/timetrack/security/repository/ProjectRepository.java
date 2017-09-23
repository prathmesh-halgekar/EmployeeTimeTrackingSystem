package com.employee.timetrack.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.timetrack.security.model.Project;

public interface ProjectRepository extends CrudRepository<Project, String> {

}
