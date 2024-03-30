/**
 * 
 */
package edu.learntek.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.learntek.crud.model.Employee;

/**
 * @author ADMIN
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveEmployee(int eid, String name, int sal) {
		// TODO Auto-generated method stub
		boolean isEmployeeSaved = false;
		int res = jdbcTemplate.update("insert into employee values(?,?,?) ", eid,name,sal);
		if (res > 0) {
			isEmployeeSaved = true;
		}
		return isEmployeeSaved;
	}

	@Override
	public boolean deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		boolean isEmployeeDeleted = false;
		int res = jdbcTemplate.update("Delete from employee where eid=? ", eid);
		if (res > 0) {
			isEmployeeDeleted = true;
		}
		return isEmployeeDeleted;
	}

	@Override
	public Optional<Employee> getEmployee(int eid) {
		// TODO Auto-generated method stub
	//	jdbcTemplate.query("select ", rowMapper)
		Employee employee = jdbcTemplate.queryForObject("select * from employee where eid=?", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee employee = new Employee();
				employee.setEid(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSal(rs.getInt(3));
				return employee;
			}			
		}, new Object[] {eid});

		Optional<Employee> optional = Optional.of(employee);
		return optional;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee employee = new Employee();
				employee.setEid(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSal(rs.getInt(3));
				return employee;
			}			
		});
		
	}
	
}
