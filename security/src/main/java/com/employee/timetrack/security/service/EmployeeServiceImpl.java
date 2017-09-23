package com.employee.timetrack.security.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.timetrack.security.model.Employee;
import com.employee.timetrack.security.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static LocalTime breakStartTime = null;
	private static LocalTime breakStopTime = null;
	
	@Override
	public String storeTime(String empName, String type) {
		// Assuming name for simplicity.
		Employee employee = employeeRepository.getEmployeeByEmployeeName(empName);
	
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Time : "+dateFormat.format(date));
		if("inTime".equalsIgnoreCase(type)){
			employee.setInTime(dateFormat.format(date));
		}else{
			employee.setOutTime(dateFormat.format(date));	
		}
		employeeRepository.save(employee);
		return dateFormat.format(date);
	}
	
	public void breakStartTime(HttpSession session){
		breakStartTime = LocalTime.now();
		session.setAttribute("breakStartTime", breakStartTime);
		System.out.println("Break Time start : "+breakStartTime);
	}
	public void breakStopTime(HttpSession session){
		breakStopTime = LocalTime.now();
		session.setAttribute("breakStopTime", breakStopTime);
		System.out.println("Break Time stop : "+breakStopTime);
	}
	public String getTotalPauseTime(HttpSession session){
		LocalTime breakStartTime = (LocalTime) session.getAttribute("breakStartTime");
		LocalTime breakStopTime = (LocalTime) session.getAttribute("breakStopTime");
		
		session.setAttribute("breakStartTime", null);
		session.setAttribute("breakStopTime", null);
		System.out.println("Break Pause Time : "+Long.toString(Duration.between(breakStopTime, breakStartTime).toMinutes()));
		
		//Employee employee = employeeRepository.findOne(empId);
		//employeeRepository.save(employee);
		return Long.toString(Duration.between(breakStopTime, breakStartTime).toMinutes());
		
	}

}
