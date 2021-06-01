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
<%
try {
	connection = DriverManager.getConnection(connectionUrl + database, userid, password);
	statement = connection.createStatement();
	String sql = "select * from partytable where partyid=" + id;
	resultSet = statement.executeQuery(sql);
	while (resultSet.next()) {
%>
<!DOCTYPE html>
<html>
<body>
	<h1>Update data from database in jsp</h1>
	<form method="post" action="update-process.jsp">
		<input type="hidden" name="id" value="<%=resultSet.getString("id")%>">
		<input type="text" name="id" value="<%=resultSet.getString("id")%>">
		<br>
		First name:<br> <input type="text" name="name"
			value="<%=resultSet.getString("firstname")%>"> <br>
		Last name:<br> <input type="text" name="lastname"
			value="<%=resultSet.getString("lastname")%>"> <br>
		Address:<br> <input type="text" name="name"
			value="<%=resultSet.getString("name")%>"> <br>
		City name:<br> <input type="text" name="city"
			value="<%=resultSet.getString("city")%>"> <br>
		ZIP:<br> <input type="number" name="zip"
			value="<%=resultSet.getInt("zip")%>"> <br>	
		State:<br> <input type="text" name="state"
			value="<%=resultSet.getString("state")%>"> <br>
		country:<br> <input type="text" name="country"
			value="<%=resultSet.getString("country")%>"> <br>
		Phone:<br> <input type="text" name="phone"
			value="<%=resultSet.getString("phone")%>"> <br>	
		<br> <input type="submit" value="submit">
	</form>
	<%
	}
	connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
</body>
</html>