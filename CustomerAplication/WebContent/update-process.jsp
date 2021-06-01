<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/newhotwaxdata";%>
<%!String user = "root";%>
<%!String psw = "root";%>
<%
String partyid =request.getParameter("partyid");

String firstname = request.getParameter("firstname");
String lastname = request.getParameter("lastname");
String address = request.getParameter("address");
String city = request.getParameter("city");
String zip = request.getParameter("zip");
int zip1=Integer.parseInt(zip);
String state = request.getParameter("state");
String country = request.getParameter("country");
String phone = request.getParameter("phone");


if(partyid != null)
{
Connection con = null;
PreparedStatement ps = null;
int id = Integer.parseInt(partyid);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update users set partyid=?,firstname=?,lastname=?,address=?,city=?,zip=?,state=?,country=?,phone=? where partyid="+partyid;
ps = con.prepareStatement(sql);
ps.setInt(1,id);
ps.setString(2, firstname);
ps.setString(3, lastname);
ps.setString(4, address);
ps.setString(5, city);
ps.setInt(6, zip1);
ps.setString(7, state);
ps.setString(8, country);
ps.setString(9,phone );


int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>