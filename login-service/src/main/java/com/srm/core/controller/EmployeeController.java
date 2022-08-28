package com.srm.core.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.srm.core.exception.ResourceNotFoundException;
import com.srm.core.model.Employee;
import com.srm.core.service.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("/adduser")
	public ResponseEntity<?> create(@RequestBody Employee emp) {
		try {
			employeeservice.create(emp);
			return new ResponseEntity<>("User Added", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<?> getalluser(@RequestParam(required = false) Integer id) {
		if (id == null) {
			System.out.println("");
			List<Employee> emp = employeeservice.getalluser();
			return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
		} else if (id != null) {
			Optional<Employee> emp = employeeservice.getbyId(id);
			System.out.println(emp.isPresent());
			if (emp.isPresent()) {
				Optional<Employee> employees = employeeservice.getbyId(id);
				System.out.println(emp);
				return new ResponseEntity<Optional<Employee>>(employees, HttpStatus.OK);
			}
		}
		throw new ResourceNotFoundException("User id is not found");
	}

	@GetMapping("/user")
	public ResponseEntity<?> getuser(@RequestParam(required = false) String username) {

		List<Employee> emp = employeeservice.getuser(username);
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}

}
