package com.BikkadIT.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Employee;


@Service
public interface ServiceI {
 
	public Employee saveEmployee(Employee employee);
	
	public List<Employee>saveMultiEmployee(List<Employee> employees);
	
	public Employee getEmpById(int id);
	
	public Employee getEmpLessThan(int age);
	
	public Employee updateEmp(Employee employee);
	
	public List<Employee>updateMultiEmp(List<Employee> employee);
	
	public Employee loginCheck(Employee employee);
	
	public boolean deleteById(int id);
	
	public void deleteAllEmp();
}
