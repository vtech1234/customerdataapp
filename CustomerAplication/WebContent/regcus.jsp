<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form action="InsertData" method="post">
    <pre>
<!--  PartyId :   <input type="number" name="partyid"> -->
First Name :   <input type="text" name="firstname" required="required">
Last Name :  <input type="text" name="lastname" required="required">
Address :  <input type="text" name="address">
City :  <input type="text" name="city">
ZIP :  <input type="number" name="zip">
State :  <input type="text" name="state">
Country :  <input type="text" name="country">
Phone :  <input type="text" name="phone">
UserLoginId :   <input type="text" name="userlogin" required="required">
password :  <input type="password" name="password" required="required">

    <input type="submit" value="Submit">
  </pre>
  </form>
</body>
</html>