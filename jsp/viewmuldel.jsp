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
<div class="error" align="center">${noClaim }</div>
<form name="quoteForm" action="confirmmuldel" >
 <table align="center" border="1px" style="border-collapse: collapse;">
			       
			       <tr>
			       <th></th>
			     
			       <th>User Id</th>
			       <th>Vehicle Id</th>
			       <th>Date Of Accident</th>
			       <th>Nature Of Accident</th>
			       <th>Comments</th>
			      
			       
			       </tr>
			       
			       <c:forEach var="listElement" items="${delbeanar}">
			       		<tr>
			       				
			       				<td><input type="checkbox" value= ${listElement.accidentHistoryId} name="deleteQuote"></td>
								<td>${listElement.fqUser.userId}</td>
								<td>${listElement.fqVehicle.vehicleId}</td>
								<td>${listElement.dateOfAccident}</td>
								<td>${listElement.natureOfAccident}</td>
								<td>${listElement.comments}</td>
								
								
								
						</tr>
					</c:forEach>
			        <tr>
			        <td><input type="submit" value="Confirm Delete" /></td>
			        <td><input type="reset" value="Reset"/>
			        
			        </tr>
		        </table>
</form>

</body>
</html>



