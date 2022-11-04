package com.virtusa.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.data.EmployeeRepository;
import com.virtusa.modles.Employee;


@Service
public class EmployeeService {

	private EmployeeRepository empRepo;

	@Autowired
	public EmployeeService(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee add(Employee emp) {
		System.out.println("Worked");
		return empRepo.save(emp);

	}
	@Transactional(readOnly = true)
	public Set<Employee> getAllByDepartment(){
		System.out.println("get all emps attempted");
		return empRepo.findAllByOrderByDepartmentAsc().stream().collect(Collectors.toSet()); 
	}

}
