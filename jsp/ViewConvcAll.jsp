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
			       <c:forEach var="listElement" items="${viewConvc}">
			       <tr>
			       <th>Conviction ID</th>
			       <th>User Id</th>
			       <th>Nature Of Conviction</th>
			       <th>Date Of Conviction</th>
			        <th>Comments</th>
			       </tr>
			       		<tr>
			       		
			       		
	
			       				<td>${listElement.convictionid}</td>
			       				<td>${listElement.uid}</td>
			                    <td>${listElement.noc}</td>
								<td>${listElement.doc}</td>
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