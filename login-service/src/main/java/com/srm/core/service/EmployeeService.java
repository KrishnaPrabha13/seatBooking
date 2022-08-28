package com.srm.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.srm.core.exception.ResourceNotFoundException;
import com.srm.core.model.Employee;
import com.srm.core.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
	private EmployeeRepository employeerepository;
	
	public Employee create (Employee employee) {
		return employeerepository.save(employee);
		
	}
	public Employee update (Employee emp) {
		return employeerepository.save(emp);
		
	}
	public List<Employee> getalluser() {
		return employeerepository.findAll();
	}
	public List<Employee> getuser(String userid) {
		System.out.println(userid);
		return employeerepository.getByUserid(userid);
	}
	
	
	public Optional <Employee> getbyId(int id) throws ResourceNotFoundException{
		return employeerepository.findById(id);
	}
}
