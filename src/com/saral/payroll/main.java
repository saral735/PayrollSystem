package com.saral.payroll;

import java.util.ArrayList;

abstract class Employee{
	private String name;
	private int id;

 public Employee(String name, int id){
	this.name=name;
	this.id=id;
 }
 
 public String getName() {
	 return name;
 }
 public int getId() {
	 return id;
 }
 
 public abstract double calculateSalary();
 
 @Override
 public String toString() {
	 return "Employee[ name="+name+",id="+id+",salary="+calculateSalary()+"]";
 }
}

class FullTimeEmployee extends Employee{
	
	private double monthlySalary;
	
	public FullTimeEmployee(String name,int id,double monthlySalary) {
		super(name,id);
		  this.monthlySalary=monthlySalary;
	}
	@Override
	public double calculateSalary(){
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee{
	private int hoursWorked;
	
	private double hoursRate;
	
	public PartTimeEmployee(String name,int id, int hoursWorked, double hoursRate) {
		super(name ,id);
		this.hoursWorked=hoursWorked;
		this.hoursRate=hoursRate;
	}
	
	@Override
	public double calculateSalary() {
		return hoursWorked*hoursRate;
	}
}

class PayrollSystem{
	
	private ArrayList<Employee> employeeList;
	
	public PayrollSystem() {
		employeeList=new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee employeeToRemove=null;
		for(Employee employee :  employeeList) {
		if(employee.getId()==id) {
			employeeToRemove = employee;
			break;
		}
}
	if(employeeToRemove != null) {
		employeeList.remove(employeeToRemove);
	}
}
	
	public void displayEmployees() {
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
	}
}	
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		PayrollSystem payrollSystem=new PayrollSystem();
		FullTimeEmployee emp1=new FullTimeEmployee("VIKAS",1,7000.0);
		PartTimeEmployee emp2=new PartTimeEmployee("ALEXANDER",2,40,100.0);
		
		payrollSystem.addEmployee(emp1);		
		payrollSystem.addEmployee(emp2);
		System.out.println("Initial Employee Details: ");
		payrollSystem.displayEmployees();
		System.out.println("Removing Employee");
		payrollSystem.removeEmployee(2);
		System.out.println("Remaining Employee details: ");
		payrollSystem.displayEmployees();
	}
	
}
