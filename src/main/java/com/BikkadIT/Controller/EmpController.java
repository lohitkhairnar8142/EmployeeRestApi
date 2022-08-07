package com.BikkadIT.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Employee;
import com.BikkadIT.Service.ServiceI;

@RestController
public class EmpController {
	 
	private ServiceI serviceI;
	
	@GetMapping(value = "/saveEmployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee){
      Employee saveEmployee = serviceI.saveEmployee(employee);	
      System.out.println(saveEmployee);
		return new ResponseEntity<Employee>(saveEmployee,HttpStatus.OK);
	}
	
	@GetMapping(value = "/saveMultiEmployee", consumes = "application/json",produces = "application/json")
	public ResponseEntity<Employee> saveMultipleEmployeeDetails(@RequestBody List<Employee> employees){
		List<Employee> list = serviceI.saveMultiEmployee(employees);
		return new ResponseEntity((List<Employee>) list,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getEmpById", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable int id){
		Employee id2 = serviceI.getEmpById(id);
		System.out.println(id2);
		return new ResponseEntity<Employee>(id2, HttpStatus.OK);
	}
	@GetMapping(value = "/updateEmp", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee){
		Employee updateEmp = serviceI.updateEmp(employee);
		System.out.println(updateEmp);
		return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);
		
	}
	@GetMapping(value = "/updateMultiEmp", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> updateMultiEmployee(@RequestBody List<Employee> employee){
		List<Employee> multiEmp = serviceI.updateMultiEmp(employee);
		
		return new ResponseEntity((List<Employee>) multiEmp,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/loginOrCheck", consumes = "application/json", produces = "application/json")
	public String loginCheckEmp (@RequestBody Employee employee){
		Employee logincheck = serviceI.loginCheck(employee);
	
		if (logincheck==null)
		{
			return "login fail";
		}
		
		return "login Success";
		
	}
	@GetMapping(value = "/ageLessThan", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> getAllEmpAgeLessThan( @PathVariable int age){
		List<Employee> age2 = serviceI.employeesAge(age);
		System.out.println(age2);
		return new ResponseEntity((List<Employee>)age2 ,HttpStatus.OK);
		
	}
	
	
}
