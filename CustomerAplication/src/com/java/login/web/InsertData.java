package com.java.login.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		  // TODO Auto-generated method stub
	    doGet(request, response);
	    PrintWriter out = response.getWriter();
	   // String partyid = request.getParameter("partyid");
	    //int partyid1=Integer.parseInt(partyid);
	    int partyid;
	    String userlogin = request.getParameter("userlogin");
	    String firstname = request.getParameter("firstname");
	    String lastname = request.getParameter("lastname");
	    String address = request.getParameter("address");
	    String city = request.getParameter("city");
	    String zip = request.getParameter("zip");
	    int zip1=Integer.parseInt(zip);
	    String state = request.getParameter("state");
	    String country = request.getParameter("country");
	    String phone = request.getParameter("phone");
	    String password = request.getParameter("password");
	    
	    
	    
	    //database Connectivity code.........
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhotwaxdata","root","root");
	          Statement stmt = con.createStatement();
	          stmt.executeUpdate("insert into partytable (firstname,lastname,address,city,zip,state,country,phone)values('"+firstname+"','"+lastname+"','"+address+"','"+city+"',"+zip1+",'"+state+"','"+country+"','"+phone+"' ) ");
	          partyid=stmt.executeUpdate("select MAX(partyid) from partytable");
	          stmt.executeUpdate("insert into userloginnew1 (userid,password,partyid)values('"+userlogin+"','"+password+"',"+partyid+") ");
	          
	          out.println("Data is inserted successfully in both tables");
	          
	          
	    } catch (ClassNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	   
	  }
	}


