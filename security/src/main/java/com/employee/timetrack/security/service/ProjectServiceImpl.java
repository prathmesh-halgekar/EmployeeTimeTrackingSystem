package com.employee.timetrack.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.timetrack.security.model.Project;
import com.employee.timetrack.security.repository.ProjectRepository;

@Service("projectService")
public class ProjectServiceImpl implements ProjectServiceI {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		List<Project> projects = new ArrayList<Project>();
		projectRepo.findAll().forEach(projects::add);
		return projects;
	}

}
