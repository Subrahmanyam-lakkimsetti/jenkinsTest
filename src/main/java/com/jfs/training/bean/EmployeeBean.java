package com.jfs.training.bean;

public class EmployeeBean {

	private String name;

	private String salary;


	public EmployeeBean(String name, String salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public EmployeeBean() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
