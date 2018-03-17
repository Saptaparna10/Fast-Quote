<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<jsp:useBean id="addacc" class="com.tcs.ilp.model.AddAcddBean" scope="request" />
<table>
<tr><th>Accident Id</th><td><jsp:getProperty name="addacc" property="acc_id"/></td></tr>
<tr><th>User Id</th><td><jsp:getProperty name="addacc" property="user_id"/></td></tr>
<tr><th>Vehicle Id</th><td><jsp:getProperty name="addacc" property="veh_id"/></td></tr>
<tr><th>Nature Of Accident</th><td><jsp:getProperty name="addacc" property="nac"/></td></tr>
<tr><th>Date Of Accident</th><td><jsp:getProperty name="addacc" property="doa"/></td></tr>
<tr><th>Comments</th><td><jsp:getProperty name="addacc" property="comments"/></td></tr>



</table>





</body>
</html>