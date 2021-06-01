<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "newhotwaxdata";
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
<body>

	<h1>All Data</h1>
	<table border="1">
		<tr>
		    <td>Table</td>

			

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