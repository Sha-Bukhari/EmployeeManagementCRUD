package com.sha.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
import com.sha.model.Employee;

public class EmployeeboImpl implements Employeebo {
	
	private Connection connection = null;
	private PreparedStatement ptm = null;
	private Statement statement = null;
	private ResultSet rs = null;
	
	//QUERY
	
	static final private String INSERT_QUERY = "INSERT INTO Employee (id,name,email,dept,salary) values(?,?,?,?,?)";
	static final private String DELECT_QUERY = "DELETE FROM Employee WHERE ID = ?";
	static final private String UPDATE_QUERY = "UPDATE Employee SET name=?, email=?, dept=?, salary=? where id = ?";
	static final private String SELECT_QUERY ="SELECT * FROM Employee WHERE ID = ?";
	static final private String SELECTALL_QUERY ="SELECT * FROM Employee";
	
	
	
	public EmployeeboImpl(){ 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATABASE","USERNAME","PASSWORD");// LOAD Driver
			if(connection != null) {
				System.out.println("Connection Success");
				
			}else {
				System.out.println("Fail Connection");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public int insert(Employee e) {
		int i=0;
		
		try {
	
			ptm = connection.prepareStatement(INSERT_QUERY);
			ptm.setInt(1, e.getId());
			ptm.setString(2, e.getName());
			ptm.setString(3, e.getEmail());
			ptm.setString(4, e.getDepartment());
			ptm.setInt(5, e.getSalary());
			
			i = ptm.executeUpdate();
	
	
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return i;
	}

	@Override
	public int delete(int id) {
		int i =0;
		
		try {
			ptm = connection.prepareStatement(DELECT_QUERY);
			ptm.setInt(1, id);
			i = ptm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int deleteAll(Employee e) {
		try {
			ptm = connection.prepareStatement(DELECT_QUERY);
			ptm.setInt(1, e.getId());
			return ptm.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		return 0;
		
	
	}

	@Override
	public int update(Employee e) {
		
		try {
			ptm=connection.prepareStatement(UPDATE_QUERY);
			
			
			ptm.setString(1, e.getName());
			ptm.setString(2, e.getEmail());
			ptm.setString(3, e.getDepartment());
			ptm.setInt(4, e.getSalary());
			ptm.setInt(5, e.getId());
			
			return ptm.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Employee get(int id) {
		
		try {
			ptm=connection.prepareStatement(SELECT_QUERY);
			
			ptm.setInt(1,id);
			
			rs= ptm.executeQuery();
			if(rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String dept = rs.getString("dept");
				int sal = rs.getInt("salary");
				return new Employee(id1,name,email,dept,sal);
				//employeeList.add(e);

			}
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Employee> getAll() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		
		try {
			
			statement = connection.createStatement();
			rs = statement.executeQuery(SELECTALL_QUERY);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String dept = rs.getString("dept");
				int sal = rs.getInt("salary");
				Employee e =  new Employee(id,name,email,dept,sal);
				employeeList.add(e);

			}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return employeeList;
	}

}
