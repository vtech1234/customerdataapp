<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "newhotwax";
String userid = "root";
String password = "root";
try {
	Class.forName(driver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>
	<h1>Retrieve data from database in jsp</h1>
	<table border="1">
		<tr>
			<td>Table</td>
			
			<td>Action</td>
		</tr>
		<%
		try {
			connection = DriverManager.getConnection(connectionUrl + database, userid, password);
			statement = connection.createStatement();
			String sql = "select * from users";
			resultSet = statement.executeQuery(sql);
			int i = 0;
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
			<td><a href="delete.jsp?id=<%=resultSet.getString("partyid")%>"><button
						type="button" class="delete">Delete</button></a></td>
		</tr>
		<%
		i++;
		}
		connection.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
</body>
</html>