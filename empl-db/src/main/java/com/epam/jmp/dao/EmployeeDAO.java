package com.epam.jmp.dao;

import java.util.List;

import com.epam.jmp.model.Employee;

public interface EmployeeDAO {
	public List<Employee> list();
	public List<Employee> findEmployee(String firstName, String lastName);
	public void addEmployee(Employee employee);
	public void removeEmployee(long id);
}
