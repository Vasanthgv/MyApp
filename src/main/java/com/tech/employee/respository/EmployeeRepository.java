package com.tech.employee.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value ="select * from employee where salary>=? and salary<=?",nativeQuery = true)
	public List<Employee> getByBetweenSalary(int sal1,int sal2);
	
	@Query(value ="select * from employee where age>=?",nativeQuery = true)
	public List<Employee> getEmployeebyAge(int age);

	@Query(value ="select age from employee",nativeQuery = true)
	public List<Integer> getAge();
	
	@Query(value ="select * from employee order by age ",nativeQuery = true)
	public List<Employee> getAgeInAsc();
	
	@Query(value ="select name,age from employee",nativeQuery = true)
	public List<Object> getNameandAge();
	
	@Query(value ="select name,salary,age from employee where age=?",nativeQuery = true)
	public Object getNameSalaryAge(int age);
}
