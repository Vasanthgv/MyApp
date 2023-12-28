package com.tech.employee.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> nameNotHandle(NullPointerException n) {
		return new ResponseEntity<> (n.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Below18Exception.class)
	public ResponseEntity<Object> below18(Below18Exception b) {
		return new ResponseEntity<> (b.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> nosuch(NoSuchElementException q) {
		return new ResponseEntity<> (q.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> noname(NameNotFoundException ey) {
		return new ResponseEntity<> (ey.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AgeNotFoundException.class)
	public ResponseEntity<Object> noage(AgeNotFoundException ey) {
		return new ResponseEntity<> (ey.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GenderNotFoundException.class)
	public ResponseEntity<Object> nogender(GenderNotFoundException ey) {
		return new ResponseEntity<> (ey.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> nosalary(SalaryNotFoundException ey) {
		return new ResponseEntity<> (ey.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}
