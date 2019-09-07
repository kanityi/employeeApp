package com.gui.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.ejb.services.EmployeeService;
import com.jpa.entities.Employee;


@ManagedBean
@SuppressWarnings("deprecation")
public class EmployeeController {

	private Employee employee = new Employee();
	private List<Employee> employees = new ArrayList<Employee>();

	@EJB
	private EmployeeService service;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void saveEmployee(Employee emp) throws IOException {
		service.addEmployee(emp);
		FacesContext.getCurrentInstance().getExternalContext().dispatch("employees.xhtml");
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	

}