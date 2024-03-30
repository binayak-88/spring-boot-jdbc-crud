/**
 * 
 */
package edu.learntek.crud.dao;

import java.util.List;
import java.util.Optional;

import edu.learntek.crud.model.Employee;

/**
 * @author ADMIN
 *
 */
public interface EmployeeDAO {
	public boolean saveEmployee(int eid, String name, int sal);
	public boolean deleteEmployee(int eid);	
	public List<Employee> getAllEmployees();
	public Optional<Employee> getEmployee(int eid);
}
