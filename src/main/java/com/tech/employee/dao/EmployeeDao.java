package com.tech.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.employee.entity.Employee;
import com.tech.employee.exception.Below18Exception;
import com.tech.employee.respository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository emprepo;
	
	public String addEmployee(Employee e) {
		emprepo.save(e);
		return "Successfully saved";
	}
	
	public String addEmpList(List<Employee> e) {
		emprepo.saveAll(e);
		return "All Employees Added";
	}
	
	public Employee getById(int id) {
		return emprepo.findById(id).orElseThrow(() -> new NullPointerException());
	}
			
	public List<Employee> getAll() {
        return emprepo.findAll();
    }
	
	public String updateEmp(Employee e) {
		emprepo.save(e);
		return "Successfully updated";
    }
	
	public String updateAllEmp(List<Employee> e) {
    	emprepo.saveAll(e);
    	return "Successfully updated All";
    }
	
	public String deleteEmp(int id) {
	    emprepo.deleteById(id);
	    return "Deleted";
	}
	
	public List<Employee> getByBetweenSalary(int sal1,int sal2) {
		return emprepo.getByBetweenSalary(sal1, sal2);
	}
	
	public List<Employee> getEmployeebyAge(int age) {
		return emprepo.getEmployeebyAge(age);
	}
	
	public List<Integer> getAge() {
		return emprepo.getAge();
	}
	
	public List<Employee> getAgeInAsc() {
		return emprepo.getAgeInAsc();
	}
	
	public List<Object> getNameandAge() {
		return emprepo.getNameandAge();
	}
	
	public Object getNameSalaryAge(int age) {
		return emprepo.getNameSalaryAge(age);
	}
	
	public String tryException(List<Employee> e) throws Below18Exception{
		ValAge(e);
    	emprepo.saveAll(e);
    	return "All employees are above 18";
		}
//		catch(Below18Exception b) {
//			return "Employee should be above 18";
//		}


	public void ValAge(List<Employee> e) throws Below18Exception {
		for(Employee x : e ) {
			if(x.getAge() < 18)
				throw new Below18Exception("Employee should be above 18");
		}
	}
}
	
