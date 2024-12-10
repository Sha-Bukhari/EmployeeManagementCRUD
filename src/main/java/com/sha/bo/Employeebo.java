package com.sha.bo;

import java.util.List;

import com.sha.model.Employee;

public interface Employeebo {
	
	abstract int insert(Employee e);
	abstract int delete(int id);
	abstract int deleteAll(Employee e);
	abstract int update(Employee e);
	abstract Employee get(int id);
	abstract List<Employee> getAll();
	
	
	
	

}
