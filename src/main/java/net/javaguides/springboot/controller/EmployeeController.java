package net.javaguides.springboot.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.jasperreportservice.ReportService;
//import net.javaguides.springboot.jasperreportservice.ReportService;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employees")
 

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	  @Autowired
	    private ReportService jrservice;
	
	   @GetMapping("/report/{format}")
	    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
	        return jrservice.exportReport(format);
	    }
	
	
//	build create employee Rest API
	@PostMapping("save")
	public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);	
	}
	
	//build getall employee Rest API
	@GetMapping
	public List<Employee>getAllEmployee(){
		return employeeService.getAllEmployee();
				
	}
	//build get employee by id Rest API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);	
		
		
	}
	//build get employee by id Rest API
	//http://localhost:8080/api/emloyees/1
	@PutMapping("{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
		
		
	}
	//build delete employee Rest APi
	//http://localhost:8080/api/emloyee/1
	@DeleteMapping ("{id}")
	public ResponseEntity<Map<String,Boolean>>deleteEmployee(@PathVariable("id")long id){
		//delete employee from DB
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<Map<String,Boolean>>(HttpStatus.OK);
		
		
	}

}