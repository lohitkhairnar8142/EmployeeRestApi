package com.BikkadIT.Repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.Model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Serializable> {

	public List<Employee>findByEmpAgeLessThanEqual(int age);
	
	public Employee findByIdAndEmpName(int id,String name);
}
