package com.assetTracking;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("ID"));
		employee.setFirstName(rs.getString("FirstName"));
		employee.setLastName(rs.getString("LastName"));
		employee.setEmailAddr("EmailAddress");
		return employee;
	}

}
