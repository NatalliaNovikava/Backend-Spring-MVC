package com.epam.jmp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jmp.dao.EmployeeDAO;
import com.epam.jmp.model.Employee;

@Controller
@RequestMapping("/employees")
public class RestController {
	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> list() {
		return employeeDAO.list();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee) {
		employeeDAO.addEmployee(employee);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Long id) {
		employeeDAO.removeEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> search(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeDAO.findEmployee(firstName, lastName); 
	}
}
