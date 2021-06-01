package com.java.login.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllData
 */
@WebServlet("/ShowAllData")
public class ShowAllData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllData() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhotwaxdata", "root", "root");  
            
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from partytable");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><tr>");  
            while (rs.next()) 
            {  
            	 
                
                int partyid = rs.getInt("partyid");
        	    
        	    String firstname =rs.getString("firstname");
        	    String lastname = rs.getString("lastname");
        	    String address = rs.getString("address");
        	    String city = rs.getString("city");
        	    int zip1=rs.getInt("zip");
        	    String state = rs.getString("state");
        	    String country = rs.getString("country");
        	    String phone = rs.getString("phone");
        	   
                
                out.println("<tr><td>"+partyid+"</td><td>" + firstname + "</td><td>" + lastname + "</td><td>" + address + "</td><td>"+city+"</td><td>" + zip1 + "</td><td>" + state + "</td><td>" + country + "</td><td>" + phone+ "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
    }  


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
