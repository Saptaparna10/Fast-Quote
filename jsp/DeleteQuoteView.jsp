<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/usr.css" >
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/home1.css" >
<style>
input{
width: 170px;
}
#insuranceReg {
width: 530px;}
</style>
</head>
<body>
<div id="wrapper">
<header id="header">
<div class="wrap">
<img src="/FQ-Final/images/Fast-quote_icon.gif" height="100px" width="100px" id="logo"><img src="/FQ-Final/images/fs.png" height="71px" width="557px" id="fs"></div></header>
<div id="menu">
<div class="wrap">
<table>
<tr>
<td><a href="index.jsp" style="text-decoration:none;" ><b>HOME</b></a></div></td>
<td><a href="#aboutUs.html"  style="text-decoration:none;"><b>ABOUT US</b></a></div></td>
<td><a href="emp.html" style="text-decoration:none;"><b class="active">SERVICES</b></a></div></td>
<td><a href="index.html" style="text-decoration:none;"><b>LOGOUT</b></a></div></td>
</tr>
</table>
</div></div>
<div id="content" >
<div class="wrap">



<div class="insuranceRegBox" style="margin: 0px auto;">
<div class="error" align="center">${noClaim }</div>
<form name="quoteForm" action="DeleteQuoteBeforeConfirm" method="post">
 <table align="center" border="1px" style="border-collapse: collapse;">
			       
			       <tr>
			       <th></th>
			       <th>Quote Id</th>
			       <th>User Id</th>
			       <th>Proposal Id</th>
			       <th>Accident History ID</th>
			       <th>Conviction History ID</th>
			       <th>Claim Amount</th>
			       <th>Deduction</th>
			       <th>Quote Amount</th>
			       <th>Status</th>
			       
			       </tr>
			       
			       <c:forEach var="listElement" items="${deleteQuote}">
			       		<tr>
			       				
			       				<td><input type="checkbox" value="${listElement.proposal_id}" name="deleteQuote"></td>
								<td>${listElement.quote_id}</td>
								<td>${listElement.user_id}</td>
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
			        <td><input type="submit" value="Confirm Delete Quote" /></td>
			        <td><input type="reset" value="Reset"/>
			        
			        </tr>
		        </table>
</form>
</div>
                                      </div>
                                      
                                      <footer id="footer">

<div class="wrap">
 <ul>
        <li><a href="#">Homepage | </a></li>
        <li><a href="#">Contact Us | </a></li>
        <li><a href="#">Privacy Policy | </a></li>
        <li><a href="#">Terms of Use</a></li>
      </ul>
      <p>CopyRight <i>Fast Quote</i> &copy; 2013</p>
          </div>
</footer>

</body>
</html>



