<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<jsp:useBean id="addconvc" class="com.tcs.ilp.model.AddConvcBean" scope="request" />
<table>
<tr><th>Conviction Id</th><td><jsp:getProperty name="addconvc" property="convictionid"/></td></tr>
<tr><th>User Id</th><td><jsp:getProperty name="addconvc" property="uid"/></td></tr>
<tr><th>Nature Of Conviction</th><td><jsp:getProperty name="addconvc" property="noc"/></td></tr>
<tr><th>Date Of Conviction</th><td><jsp:getProperty name="addconvc" property="doc"/></td></tr>
<tr><th>Comments</th><td><jsp:getProperty name="addconvc" property="comments"/></td></tr>



</table>





</body>
</html>