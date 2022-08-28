package com.srm.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.srm.core.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

    public List<Employee> getByUserid(String userid);
}
