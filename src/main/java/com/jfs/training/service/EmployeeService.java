package com.jfs.training.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jfs.training.bean.EmployeeBean;

@Service
public class EmployeeService {
	
	public List<EmployeeBean> getAllEmployees() {
		return Arrays.asList(
					new EmployeeBean("santosh", "emp1"),
					new EmployeeBean("Subrahmanyam", "emp2"),
					new EmployeeBean("Venkat", "emp3")
				);
	}
	
}
