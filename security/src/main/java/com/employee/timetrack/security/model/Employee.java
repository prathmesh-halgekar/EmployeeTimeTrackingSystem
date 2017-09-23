package com.employee.timetrack.security.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emps")
public class Employee  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	private String employeeId;
	
	@Column(name = "emp_name")
	private String employeeName;
	
	@Column(name = "in_time")
	//@Temporal(TemporalType.TIMESTAMP)
	private String inTime;
	
	@Column(name = "out_time")
	private String outTime;
	
	@Column(name = "project_id")
	private String projectsId;
	
	@Column(name = "total_Pause")
	private String totalPause;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}


	public String getProjectsId() {
		return projectsId;
	}

	public void setProjectsId(String projectsId) {
		this.projectsId = projectsId;
	}

	public String getTotalPause() {
		return totalPause;
	}

	public void setTotalPause(String totalPause) {
		this.totalPause = totalPause;
	}

	@Override
	public String toString() {
		return "Employeee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", inTime=" + inTime
				+ ", outTime=" + outTime + ", projects=" + projectsId + ", totalPause=" + totalPause + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((inTime == null) ? 0 : inTime.hashCode());
		result = prime * result + ((outTime == null) ? 0 : outTime.hashCode());
		result = prime * result + ((projectsId == null) ? 0 : projectsId.hashCode());
		result = prime * result + ((totalPause == null) ? 0 : totalPause.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (inTime == null) {
			if (other.inTime != null)
				return false;
		} else if (!inTime.equals(other.inTime))
			return false;
		if (outTime == null) {
			if (other.outTime != null)
				return false;
		} else if (!outTime.equals(other.outTime))
			return false;
		if (projectsId == null) {
			if (other.projectsId != null)
				return false;
		} else if (!projectsId.equals(other.projectsId))
			return false;
		if (totalPause == null) {
			if (other.totalPause != null)
				return false;
		} else if (!totalPause.equals(other.totalPause))
			return false;
		return true;
	}
		
	
	

}
