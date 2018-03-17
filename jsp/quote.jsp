<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <table align="center" border="1px" style="border-collapse: collapse;">
			       
			       <tr>
			       <th>Proposal Id</th>
			       <th>Accident History ID</th>
			       <th>Conviction History ID</th>
			       <th>Claim Amount</th>
			       <th>Deduction</th>
			       <th>Quote Amount</th>
			       <th>Status</th>
			       
			       </tr>
			       
			       <c:forEach var="listElement" items="${generatedQuote}">
			       		<tr>
			       				
			       				
								<td>${listElement.proposal_id}</td>
								<td>${listElement.accident_history_id}</td>
								<td>${listElement.conviction_history_id}</td>
								
								<td>${listElement.claim}</td>
								<td>${listElement.deduction}</td>
								<td>${listElement.quote}</td>
					
								<td>${listElement.status}</td>
								
								
						</tr>
					</c:forEach>
			        <tr>
			        
			        </tr>
		        </table>


</body>
</html>