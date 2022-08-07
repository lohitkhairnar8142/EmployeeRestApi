package com.BikkadIT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BikkadIT.Model.Employee;
import com.BikkadIT.Repository.EmpRepo;

public class ServiceIMPL implements ServiceI {
 
	@Autowired
	private EmpRepo empRepo;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
        Employee save = empRepo.save(employee); 
		
		return save;
	}

	@Override
	public List<Employee> saveMultiEmployee(List<Employee> employee) {
		List<Employee> saveAll = empRepo.saveAll(employee);
		return saveAll;
	}

	@Override
	public Employee getEmpById(int id) {
		Employee employee = empRepo.findById(id).get();
		
		return employee;
	}


	@Override
	public Employee updateEmp(Employee employee) {
          Employee save = empRepo.save(employee);
		return save;
	}

	@Override
	public List<Employee> updateMultiEmp(List<Employee> employee) {
		List<Employee> saveAll = empRepo.saveAll(employee);
		
		return saveAll;
	}

	@Override
	public Employee loginCheck(Employee employee) {
		Employee employee2 = empRepo.findByIdAndEmpName(employee.getEmpId(),employee.getEmpName());
		return employee2;
	}

	@Override
	public boolean deleteById(int id) {
		boolean existsById = empRepo.existsById(id);
		if(existsById) {
			empRepo.deleteById(id);
			return true;
		}else
		return false;
		
		
	}

	@Override
	public void deleteAllEmp() {
		empRepo.deleteAll();
		
	}

	@Override
	public List<Employee> employeesAge(int age) {

		List<Employee> lessThanEqual = empRepo.findByEmpAgeLessThanEqual(age);
		return lessThanEqual;
	}

	
 
	
}
