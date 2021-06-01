package com.java.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.java.login.bean.LoginBean;

public class LoginDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/newhotwaxdata";
	private String dbUname = "root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.jdbc.Driver";
	
	/*private static final String SELECT_USER_BY_ID = "select partyid,firstname, lastname, address, city, zip, state, country, phone from partytable where partyid =?";
	private static final String SELECT_ALL_USERS = "select * from partytable;";
	private static final String DELETE_USERS_SQL = "delete from partytable where partyid = ?;";
	private static final String UPDATE_USERS_SQL = "update partytable set firstname = ?,lastname= ? where partyid = ?;";
    public LoginDao() {
    }*/
    
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean validate(LoginBean loginBean)
	{
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "select * from userloginnew1 where userid = ? and password =?";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, loginBean.getUserLoginId());
		ps.setString(2, loginBean.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
/*	public LoginBean selectUser(int id) {
		LoginBean users = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				 int partyid =rs.getInt("partyid");
				 
				    String firstname = rs.getString("firstname");
				    String lastname = rs.getString("lastname");
				    String address = rs.getString("address");
				    String city = rs.getString("city");
				    int zip = rs.getInt("zip");
				    String state = rs.getString("state");
				    String country = rs.getString("country");
				    long phone = rs.getLong("phone");
				    
				    
				
				users= new LoginBean(partyid,firstname, lastname, address, city, zip, state, country, phone);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	
	public List<LoginBean> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<LoginBean> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				
				
				    int partyid =rs.getInt("partyid");
				    String firstname = rs.getString("firstname");
				    String lastname = rs.getString("lastname");
				    String address = rs.getString("address");
				    String city = rs.getString("city");
				    int zip = rs.getInt("zip");
				    String state = rs.getString("state");
				    String country = rs.getString("country");
				    long phone = rs.getLong("phone");
				    
				    
				
				users.add(new LoginBean(partyid,firstname, lastname, address, city, zip, state, country, phone));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	public boolean updateUser(LoginBean user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	public boolean deleteUser(int partyid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, partyid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}


	/*
	public String insert(LoginBean member)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		String sql = "insert into newparty (firstname,lastname,address,city,zip,state,country,phone) values ('"+firstname +"','"+lastname +"','"+address+"','"+city+"',"+zip+",'"+ state+"','"+ country+"',"+phone +"') ";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getFirstname());
		ps.setString(2, member.getLastname());
		ps.setString(3, member.getAddress());
		ps.setString(4, member.getCity());
		ps.setInt(5, member.getZip());
		ps.setString(6, member.getState());
		ps.setString(7, member.getCountry());
		ps.setLong(8, member.getPhone());
		ps.setString(1, member.getUserLoginId());
		ps.setString(2, member.getPassword());
		ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		
		
       /* String sql1 = "insert into logintable values(?,?)";
		
		//PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql1);
		ps.setString(1, member.getUserLoginId());
		ps.setString(2, member.getPassword());
		
		
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered 2";
		}
		return result;*/
	/*private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
*/
		
	}

	

