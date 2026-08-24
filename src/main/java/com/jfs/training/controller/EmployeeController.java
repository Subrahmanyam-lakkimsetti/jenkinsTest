package com.jfs.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jfs.training.bean.EmployeeBean;
import com.jfs.training.service.EmployeeService;

@Service
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeBean>> getAllEmployees() {
		return new ResponseEntity<List<EmployeeBean>>(empService.getAllEmployees(), HttpStatus.ACCEPTED);
	}
	
}
