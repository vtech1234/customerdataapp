<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("partyid");
//String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "newhotwaxdata";
String userid = "root";
String password = "root";
try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<body>
	<h1>Retrieve data from database in jsp</h1>
	<table border="1">
		<tr>
			<td>Table</td>
			
			
			<td>update</td>
		</tr>
		<%
		try {
			connection = DriverManager.getConnection(connectionUrl + database, userid, password);
			statement = connection.createStatement();
			String sql = "select * from partytable";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString("firstname")%></td>
			<td><%=resultSet.getString("lastname")%></td>
			<td><%=resultSet.getString("address")%></td>
			<td><%=resultSet.getString("city")%></td>
			<td><%=resultSet.getInt("zip")%></td>
			<td><%=resultSet.getString("state")%></td>
			<td><%=resultSet.getString("country")%></td>
			<td><%=resultSet.getString("phone")%></td>
			
			<td><a href="update.jsp?id=<%=resultSet.getString("partyid")%>">update</a></td>
		</tr>
		<%
		}
		connection.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
</body>
</html>