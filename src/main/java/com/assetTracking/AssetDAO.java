package com.assetTracking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class AssetDAO {
	// DB url
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=AssetTracking";
	// credentials
	private static final String USER = "SA";
	private static final String PASS = "<Polevault18>";

	private String query;
	java.sql.Date arbDate = java.sql.Date.valueOf("1992-10-25");
	
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AssetDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Access all the records in the Employee table and store each in an Employee
	 * object then store in an ArrayList
	 * 
	 * @return The resulting ArrayList of employees
	 */
	public List<Employee> getAllEmployeeRecords() {
		//the query statement
		query = "select * from Employee";
		//The list that will hold all of our rows returned
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		
		ArrayList<Employee> retval = new ArrayList<>();
		//now lets loop through all the rows
		while(!list.isEmpty()) {
			//get each individual row
			Object[] temp = list.get(0).values().toArray();
			Employee tempEmp = new Employee();
			//create a new Employee object from it
			tempEmp.setId((int)temp[0]);
			tempEmp.setFirstName((String)temp[1]);
			tempEmp.setLastName((String)temp[2]);
			tempEmp.setEmailAddr((String)temp[3]);
			//add it then remove it from the list
			retval.add(tempEmp);
			list.remove(0);
		}
		return retval;
	}// end getAllEmployeeRecords method

	/**
	 * Get all records from the Asset table and store them into an Asset object and
	 * hold all objects in an ArrayList
	 * 
	 * @return The resulting ArrayList
	 */
	public List<Asset> getAllAssetRecords() {
		query = "select * from asset";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		
		ArrayList<Asset> retval = new ArrayList<>();
		//now lets loop through all the rows
		while(!list.isEmpty()) {
			//get each individual row
			Object[] temp = list.get(0).values().toArray();
			Asset tempAsset = new Asset();
			//create a new Employee object from it
			tempAsset.setId((int)temp[0]);
			tempAsset.setSerialNumber((String)temp[1]);
			tempAsset.setVendor((String)temp[2]);
			tempAsset.setDisposalDate((java.sql.Date)temp[3]);
			tempAsset.setNotes((String)temp[4]);
			//add it then remove it from the list
			retval.add(tempAsset);
			list.remove(0);
		}
		return retval;
	}// end getAllEmployeeRecords method

	/**
	 * Get all records from Loan table and store into a Loan object and store those
	 * in an ArrayList
	 * 
	 * @return The resulting ArrayList
	 */
	public List<Loan> getAllLoanRecords() {
		query = "select * from Loan";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		
		ArrayList<Loan> retval = new ArrayList<>();
		//now lets loop through all the rows
		while(!list.isEmpty()) {
			//get each individual row
			Object[] temp = list.get(0).values().toArray();
			Loan tempLoan = new Loan();
			
			String tempEmpFirst = jdbcTemplate.queryForObject("select FirstName from Employee where ID = ?", new Object[] {(int)temp[1]}, String.class);
			String tempEmpLast = jdbcTemplate.queryForObject("select LastName from Employee where ID = ?", new Object[] {(int)temp[1]}, String.class);
			tempLoan.setId((int)temp[0]);
			tempLoan.setEmployeeID((int)temp[1]);
			tempLoan.setAssetID((int)temp[2]);
			tempLoan.setStartDate((java.sql.Date)temp[3]);
			tempLoan.setEmployeeName(tempEmpFirst + " " + tempEmpLast);
			//add it then remove it from the list
			retval.add(tempLoan);
			list.remove(0);
		}
		return retval;
	}// end getAllEmployeeRecords method

	/**
	 * Adss an employee to the database
	 * 
	 * @param employee
	 *            the emloyee object to add
	 */
	public void addEmployee(Employee employee) {
		// Connection conn = null;
		PreparedStatement stmt = null;
		query = "insert into Employee values(?,?,?)";
		System.out.println(employee);

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			// register driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getEmailAddr());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// As a final measure lets close our jdbc obj's again
		finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {}
		} // end finally block
	}//end addEmployee()
	

	/**
	 * First check if the incoming employee id already exists in the Loan table
	 * if not, then go on to check if the asset id already exists. if not then
	 * insert the loan into the table!!
	 * 
	 * (Maybe I should think about returning a string that corresponds to a specific 
	 * error page depending on where I get the error,)
	 * @param loan
	 * 		the loan to insert into the DB
	 */
	public String addLoan(Loan loan) {
		String checkEmp   = "select count(*) from Loan where EmployeeID = ?";
		String checkAsset = "select count(*) from Loan where AssetID = ?";
		

		//=== Check to see that the dates we have entered make sense
		if(loan.getStartDate().compareTo(loan.getEndDate()) >= 0 && !loan.getEndDate().equals(arbDate))
			return "dateError";
		//============================================
		//=== Check to see we have records in the respective Employee and Asset tables
		int count = jdbcTemplate.queryForObject("select count(*) from Employee where ID = ?",
				new Object[] {loan.getEmployeeID()}, Integer.class);
		if(count != 1)
			return "noEmployee";
		
		count = jdbcTemplate.queryForObject("select count(*) from Asset where ID = ?", 
				new Object[] {loan.getAssetID()}, Integer.class);
		if(count != 1)
			return "noAsset";
		//============================================
	    //=== Check to see if the record already exists
		count = jdbcTemplate.queryForObject(checkEmp, new Object[] {loan.getEmployeeID()}, Integer.class);
		if(count != 0)
			return "employeeHasLoan";
		count = jdbcTemplate.queryForObject(checkAsset,new Object[] {loan.getAssetID()}, Integer.class);
		if(count != 0)
			return "assetHasLoan";
		//============================================
		System.out.println("HERE");

		query = "insert into Loan values (?,?,?,?)";
		jdbcTemplate.update(query, new Object[]{loan.getEmployeeID(),loan.getAssetID(),loan.getStartDate(), loan.getEndDate()});
		
	
		
		return "loanList";
		
		
	}//end addLoan()
	
	public void removeLoan(Loan loan) {
		query = "delete from Loan where EmployeeID = ?";
		jdbcTemplate.update(query, loan.getEmployeeID());
	}

}// end AssetDAO class
