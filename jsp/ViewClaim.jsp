<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.model.*,java.util.*"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Claim</title>
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/usr.css" >
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/home1.css" >
<style>
input{
width: 170px;
}
#insuranceReg {
width: 530px;}

table tr td{
text-align: center;
}
table td{
width:25% ;
}
</style>
</head>
<body>
<div id="wrapper">
<header id="header">
<div class="wrap">
<img src="/FQ-Final/images/Fast-quote_icon.gif" height="100px" width="100px" id="logo"><img src="/FQ-Final/images/fs.png" height="71px" width="557px" id="fs">
</div></header>
<div id="menu">
<div class="wrap">
<table>
<tr>
<td><a href="index.jsp" style="text-decoration:none;" ><b>HOME</b></a></td>
<td><a href="#aboutUs.html"  style="text-decoration:none;"><b>ABOUT US</b></a></td>
<td><a href="emp.html" style="text-decoration:none;"><b class="active">SERVICES</b></a></td>
<td><a href="index.html" style="text-decoration:none;"><b>LOGOUT</b></a></td>
</tr>
</table>
</div></div>
<div id="content" >
<div class="wrap">



<div class="insuranceRegBox" style="margin: 0px auto;width:748px;">
<%
response.setContentType("text/html");
%>

<form name="quoteForm" action="GenerateQuote" method="post">
<div class="error" align="center">${noClaim }</div>
		        <table align="center" cellspacing="20">
		        <tr>
		            <th></th>
			       <th>Proposal Id</th>
			       <th>Insurance Id</th>
			       <th>Claim Amount</th>
			       </tr>
			       <c:forEach var="listElement" items="${viewClaim}">
			       
			       		<tr>
			       				
			       				<td align="right" style="text-align: right;"><input style="width:auto;" type="checkbox" value="${listElement.proposalId}" name="genQuote"></td>
								<td>${listElement.proposalId}</td>
								<td>${listElement.insuranceId}</td>
								<td>${listElement.claimAmt}</td>
								
						</tr>
					</c:forEach>
			        <tr>
			        
			        <td>&nbsp;&nbsp;</td>
			        <td align="center"><p id="btnPara"> <input class="button" type="submit" value="Generate Quote" /></p></td>
			        <td><input type="reset"  class="button" value="Reset"/></td>
			        
			        </tr>
		        </table>
		        
		        </form>
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

</div>
</body>
</html>