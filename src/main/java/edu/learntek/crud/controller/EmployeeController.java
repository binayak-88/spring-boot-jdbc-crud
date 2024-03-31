/**
 * 
 */
package edu.learntek.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.learntek.crud.model.Employee;
import edu.learntek.crud.model.MyUserDeatils;
import edu.learntek.crud.service.EmployeeService;

/**
 * @author ADMIN
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empoyeeService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/employee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
	//pre authentication
	 MyUserDeatils userDeatils = new MyUserDeatils();
	 userDeatils.setUsername(employee.getUserid());
	 userDeatils.setPassword(employee.getPassword());
	 ResponseEntity<String> authResponse =  restTemplate.postForEntity("http://localhost:9091/auth", userDeatils, String.class);
	 if(authResponse.getStatusCode().is4xxClientError()){
		 return new ResponseEntity<String>("Usrname an dpassword is wrong : ", HttpStatus.UNAUTHORIZED);
	 }
	 else if(authResponse.getBody().equals("SUCCESS")) {
	// post authentication 
		  boolean result  =  empoyeeService.saveEmployee(employee.getEid(), employee.getName(), employee.getSal());
		  ResponseEntity<String> responseEntity;
			
		  if(result) {
			  responseEntity = new ResponseEntity<String>("Employee Created Successfully.....", HttpStatus.CREATED);
		  }
	
		  else {
			  responseEntity = new ResponseEntity<String>("Employee Creation Failed  .....", HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		  return responseEntity;
	 }
	 return null;
	}
	
	@DeleteMapping("/employee/{eid}")
	public ResponseEntity<String>  deleteEmployee(@PathVariable("eid") int eid) {
		boolean result  =  empoyeeService.deleteEmployee(eid);
		ResponseEntity<String> responseEntity;
		if(result) {
			  responseEntity = new ResponseEntity<String>("Employee Deleted Successfully.....", HttpStatus.ACCEPTED);
		  }

		  else {
			  responseEntity = new ResponseEntity<String>("Employee Id Not Found  .....", HttpStatus.BAD_REQUEST);
		  }
		  return responseEntity;
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees =  empoyeeService.getAllEmployees();
		ResponseEntity<List<Employee>> resEntity = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		return resEntity;
	}
	
	@GetMapping("/employee/{eid}")
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int eid){
			Optional<Employee> optional = empoyeeService.getEmployee(eid);
			if(optional.isPresent()) {
				ResponseEntity<Employee> res =new ResponseEntity<Employee>(optional.get(),HttpStatus.OK);
				return res;
			}
			else {
				ResponseEntity<String> res = new ResponseEntity<String>("No Eid available : "+eid,HttpStatus.BAD_REQUEST);
				return res;
			}
	}
}
