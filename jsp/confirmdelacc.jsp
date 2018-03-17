<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="delaccbean" class="com.tcs.ilp.model.AddAcddBean" scope="request" />
<table>
<tr><th>Accident History Id</th><td><jsp:getProperty name="delaccbean" property="acc_id"/></td></tr>
<tr><th>User Id</th><td><jsp:getProperty name="delaccbean" property="user_id"/></td></tr>
<tr><th>Vehicle Id</th><td><jsp:getProperty name="delaccbean" property="veh_id"/></td></tr>
<tr><th>Date Of Accident</th><td><jsp:getProperty name="delaccbean" property="doa"/></td></tr>
<tr><th>Nature Of Accident</th><td><jsp:getProperty name="delaccbean" property="nac"/></td></tr>
<tr><th>Comments</th><td><jsp:getProperty name="delaccbean" property="comments"/></td></tr>
</table>
<form  name="f" action="confirmdelacc" method="post">
<input type="hidden" name="ACCDELCHECK" value="delete"> 
<input type="hidden" name="ACCID" value="<jsp:getProperty name="delaccbean" property="acc_id"/>">
<input type="submit" value="Confirm delete" >

</form>
</body>
</html>