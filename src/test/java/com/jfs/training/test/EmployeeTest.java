package com.jfs.training.test;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfs.training.GitCheckApplication;
import com.jfs.training.bean.EmployeeBean;
import com.jfs.training.controller.EmployeeController;
import com.jfs.training.service.EmployeeService;

// unit Testing on controller, mockMVC (mock the request) + mockito (Mock the service layer)

@ExtendWith(SpringExtension.class)

@SpringBootTest(classes = GitCheckApplication.class)

public class EmployeeTest {

	// mock the service layer

	@Mock
	private EmployeeService service;

	@InjectMocks
	private EmployeeController controller;

	protected MockMvc mockMVC;

	@BeforeEach
	public void mySetup() {
		MockitoAnnotations.openMocks(this);

		mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testGetAllEmployees() throws Exception {

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/emp/getAll");

		when(service.getAllEmployees()).thenReturn(getAllEmployees());

		ResultActions result = mockMVC.perform(request);

		MvcResult mvcResult = result.andReturn();

		String responseBody = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();

		ObjectMapper mapper = new ObjectMapper();

		List<EmployeeBean> employees = mapper.readValue(responseBody, new TypeReference<List<EmployeeBean>>() {
		});
		
		Assertions.assertNotNull(employees);
		Assertions.assertEquals(2, employees.size());
		Assertions.assertEquals(HttpStatus.OK.value(), status);

	}

	private List<EmployeeBean> getAllEmployees() {
		return Arrays.asList(new EmployeeBean("Santosh", "emp1"), new EmployeeBean("Subbu", "emp2"));
	}

}
