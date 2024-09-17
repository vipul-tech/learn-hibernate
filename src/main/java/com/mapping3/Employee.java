package com.mapping3;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@ManyToMany()
	@JoinTable(name="employee_learn", 
			joinColumns= {@JoinColumn(name="eid")}, 
			inverseJoinColumns = {@JoinColumn(name="pid")}
		)
	private List<Project> projects;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, List<Project> projects) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.projects = projects;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
