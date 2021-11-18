package interfaces;

import java.lang.*;

import entity.*;

public interface IEmployeeRepo
{
	public void insert(Employee e);
	public void delete(String empId);
	public void update(Employee e);
	public Employee searchEmployee(String empId);
	public String[][] getAllEmployee();
}