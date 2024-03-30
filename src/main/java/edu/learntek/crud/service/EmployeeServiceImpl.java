/**
 * 
 */
package edu.learntek.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.learntek.crud.dao.EmployeeDAO;
import edu.learntek.crud.model.Employee;

/**
 * @author ADMIN
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public boolean saveEmployee(int eid, String name, int sal) {
		// TODO Auto-generated method stub
		
		return employeeDAO.saveEmployee(eid, name, sal);
	}

	@Override
	public boolean deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Optional<Employee> getEmployee(int eid) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(eid);
	}

}
