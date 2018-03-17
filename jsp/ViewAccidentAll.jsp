<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.model.*,java.util.*"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Claim</title>
</head>
<body>

<%
response.setContentType("text/html");
%>

<form name="quoteForm" action="../emp.html" >
		        <table>
			       <c:forEach var="listElement" items="${viewAcdd}">
			       <tr>
			       <th>Accident ID</th>
			       <th>User Id</th>
			       <th>Nature Of Accident</th>
			       <th>Date Of Accident</th>
			        <th>Comments</th>
			       </tr>
			       		<tr>
			       		
			       		
	
			       				<td>${listElement.acc_id}</td>
			       				<td>${listElement.user_id}</td>
			                    <td>${listElement.nac}</td>
								<td>${listElement.doa}</td>
								<td>${listElement.comments}</td>
								
								
						</tr>
					</c:forEach>
			        <tr>
			        <td><input type="submit" value="OK" /></td>
			    
			        
			        </tr>
		        </table>
		        
		        </form>

</body>
</html>