package com.tech.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.employee.entity.Employee;
import com.tech.employee.exception.Below18Exception;
import com.tech.employee.exception.NameNotFoundException;
import com.tech.employee.exception.AgeNotFoundException;
import com.tech.employee.exception.GenderNotFoundException;
import com.tech.employee.exception.SalaryNotFoundException;
import com.tech.employee.service.EmployeeService; 

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    EmployeeService empser;

    @PostMapping(value = "/insert")
    public String addEmployee(@RequestBody Employee e) {
        return empser.addEmployee(e);
    }

    @PostMapping(value = "/insertlist")
    public String addEmpList(@RequestBody List<Employee> e) {
        return empser.addEmpList(e);
    }
    
    @GetMapping(value = "/GetById/{id}")
    public Employee getById(@PathVariable int id) {
        return empser.getById(id);
    }
    
    @GetMapping(value = "/GetAll")
    public List<Employee> getAll() {
        return empser.getAll();
    }
    
    @PutMapping(value = "/update")
    public String updateEmp(@RequestBody Employee e) {
    	return empser.updateEmp(e);
    }
    
    @PutMapping(value = "/updateAll")
    public String updateAllEmp(@RequestBody List<Employee> e) {
    	return empser.updateAllEmp(e);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public String deleteEmp(@PathVariable int id) {
    	return empser.deleteEmp(id);
    }
    
    @GetMapping(value = "/GetAllEmpbyName/{name}")
    public List<Employee> getAllEmpbyName(@PathVariable String name) throws NameNotFoundException {
    	return empser.getAllEmpbyName(name);
    }
    
    @GetMapping(value = "/GetAllEmpbyAge/{age}")
    public List<Employee> getAllEmpbyAge(@PathVariable int age) throws AgeNotFoundException {
    	return empser.getAllEmpbyAge(age);
    }
    
    @GetMapping(value = "/GetAllEmpbyGender/{gender}")
    public List<Employee> getAllEmpbyGender(@PathVariable String gender) throws GenderNotFoundException {
    	return empser.getAllEmpbyGender(gender);
    }
    
    @GetMapping(value = "/GetAllEmpbySalary/{salary}")
    public List<Employee> getAllEmpbySalary(@PathVariable int salary) throws SalaryNotFoundException {
    	return empser.getAllEmpbySalary(salary);
    }
    
    @GetMapping(value = "/GetAllEmpNamebySalary/{name}")
    public List<Integer> getAllEmpNamebySalary(@PathVariable String name) {
    	return empser.getAllEmpNamebySalary(name);
    }
    
    @GetMapping(value = "/GetAllEmpGenderbySalary/{gender}")
    public List<Integer> getAllEmpGenderbySalary(@PathVariable String gender) {
    	return empser.getAllEmpGenderbySalary(gender);
    }
    
    @GetMapping(value = "/GetMaxEmpSalary")
    public Employee getMaxEmpSalary() {
    	return empser.getMaxEmpSalary();
    }
    
    @GetMapping(value = "/GetMinEmpSalary")
    public Employee getMinEmpSalary() {
    	return empser.getMinEmpSalary();
    }
    
    @GetMapping(value = "/salarybtw/{sal1}/{sal2}")
    public List<Employee> getByBetweenSalary(@PathVariable int sal1, @PathVariable int sal2) {
		return empser.getByBetweenSalary(sal1, sal2);
	}
    
    @GetMapping(value = "/getbyage/{age}")
    public List<Employee> getEmployeebyAge(@PathVariable int age) {
		return empser.getEmployeebyAge(age);
	}
    
    @GetMapping(value = "/getage")
    public List<Integer> getAge() {
		return empser.getAge();
	}
    
    @GetMapping(value = "/getAgeinAsc")
    public List<Employee> getAgeInAsc() {
		return empser.getAgeInAsc();
	}
    
    @GetMapping(value = "/getNameandAge")
    public List<Object> getNameandAge() {
		return empser.getNameandAge();
	}
    
    @GetMapping(value = "/getNameSalaryAge/{age}")
    public Object getNameSalaryAge(@PathVariable int age) {
		return empser.getNameSalaryAge(age);
	}
    
    @PutMapping(value = "/tryException") 
    public String tryException(@RequestBody List<Employee> e) throws Below18Exception {
    	return empser.tryException(e);
    }
    
//    @DeleteMapping(value = "/deleteBy/{id}")
//    public String deleteEmp(@PathVariable int id) {
//    	return empser.deleteEmp(id);
//    }
  
}
