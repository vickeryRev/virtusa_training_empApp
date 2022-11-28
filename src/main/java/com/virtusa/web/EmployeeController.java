package com.virtusa.web;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.virtusa.modles.Employee;
import com.virtusa.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private EmployeeService empService;
	
	@Autowired
	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
		
	}
	
	//add
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		
		
		
		return ResponseEntity.ok(empService.add(employee));
		
	}
	
	//get all employees by departments
	@GetMapping("/all")
	public ResponseEntity<Set<Employee>> getAll(){
		return ResponseEntity.ok(empService.getAllByDepartment());
	}

	  
}
