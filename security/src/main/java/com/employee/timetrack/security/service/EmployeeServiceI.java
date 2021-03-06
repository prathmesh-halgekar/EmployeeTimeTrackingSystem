package com.employee.timetrack.security.service;

import javax.servlet.http.HttpSession;

import com.employee.timetrack.security.model.Employee;

public interface EmployeeServiceI {

	public String storeTime(String empId, String type);
	
	public void breakStartTime(HttpSession session);
	
	public void breakStopTime(HttpSession session);
	
	public String getTotalPauseTime(HttpSession session);
}
