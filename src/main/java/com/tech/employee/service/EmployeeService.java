package com.tech.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tech.employee.dao.EmployeeDao;
import com.tech.employee.entity.Employee;
import com.tech.employee.exception.Below18Exception;
import com.tech.employee.exception.NameNotFoundException;
import com.tech.employee.exception.AgeNotFoundException;
import com.tech.employee.exception.GenderNotFoundException;
import com.tech.employee.exception.SalaryNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdao;
	
	public String addEmployee(Employee e) {
		return empdao.addEmployee(e);
	}
	
	public String addEmpList(List<Employee> e) {
		return empdao.addEmpList(e);
	}
	
	public Employee getById(int id) {
		return empdao.getById(id);
    }
	
	public List<Employee> getAll() {
        return empdao.getAll();
    }
	
	public String updateEmp(Employee e) {
    	return empdao.updateEmp(e);
    }
	
	public String updateAllEmp(List<Employee> e) {
    	return empdao.updateAllEmp(e);
    }
	
	public String deleteEmp(int id) {
	    return empdao.deleteEmp(id);
	}
	
	public List<Employee> getAllEmpbyName(String name) throws NameNotFoundException {
		List<Employee> allEmp = getAll();
		List<Employee> eem = allEmp.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
		if(eem.isEmpty())
			throw new NameNotFoundException("No name is there");
		else
			return eem;
	}
	
	public List<Employee> getAllEmpbyAge(int age) throws AgeNotFoundException {
		List<Employee> allEmp = getAll();
		List<Employee> eem = allEmp.stream().filter(x -> x.getAge()==age).collect(Collectors.toList());
		if(eem.isEmpty())
			throw new AgeNotFoundException("No Age is there");
		else
			return eem;
	}
	
	public List<Employee> getAllEmpbyGender(String gender) throws GenderNotFoundException {
		List<Employee> allEmp = getAll();
		List<Employee> eem = allEmp.stream().filter(x -> x.getGender().equals(gender)).collect(Collectors.toList());
		if(eem.isEmpty())
			throw new GenderNotFoundException("No Gender is there");
		else
			return eem;
	}
	
	public List<Employee> getAllEmpbySalary(int salary) throws SalaryNotFoundException {
		List<Employee> allEmp = getAll();
		List<Employee> eem = allEmp.stream().filter(x -> x.getSalary()==salary).collect(Collectors.toList());
		if(eem.isEmpty())
			throw new SalaryNotFoundException ("No Salary is there");
		else
			return eem;
	}
	
	public List<Integer> getAllEmpNamebySalary(String name) {
		List<Employee> allEmp = getAll();
		return allEmp.stream().filter(x -> x.getName().equals(name)).map(x -> x.getSalary()).collect(Collectors.toList());
	}
	
	public List<Integer> getAllEmpGenderbySalary(String gender) {
		List<Employee> allEmp = getAll();
		return allEmp.stream().filter(x -> x.getGender().equals(gender)).map(x -> x.getSalary()).collect(Collectors.toList());
	}
	
	public Employee getMaxEmpSalary() {
		 List<Employee> allEmp = getAll();
	    	return allEmp.stream().max(Comparator.comparing(Employee :: getSalary)).get();
	}
	 
	public Employee getMinEmpSalary() {
		 List<Employee> allEmp = getAll();
	    	return allEmp.stream().min(Comparator.comparing(Employee :: getSalary)).get();
	 }
	
	public List<Employee> getByBetweenSalary(int sal1,int sal2) {
		return empdao.getByBetweenSalary(sal1, sal2);
	}
	
	public List<Employee> getEmployeebyAge(int age) {
		return empdao.getEmployeebyAge(age);
	}
	
	public List<Integer> getAge() {
		return empdao.getAge();
	}
	
	public List<Employee> getAgeInAsc() {
		return empdao.getAgeInAsc();
	}
	
	public List<Object> getNameandAge() {
		return empdao.getNameandAge();
	}
	
	public Object getNameSalaryAge(int age) {
			return empdao.getNameSalaryAge(age);
	}
	
	public String tryException(List<Employee> e) throws Below18Exception {
    	return empdao.tryException(e);
    }
}
