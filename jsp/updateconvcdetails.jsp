<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">@import url(css/main.css);</style>
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
<sj:head/>
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
<div id="global">
<s:form action="ConfirmConvictionupdate">
<s:textfield key="convictionHistoryId" label="ConvcId:" readonly="true" value="%{#request.fqbean.convictionHistoryId}"/>
<s:textfield key="userId" label="Enter userId:" readonly="true" value="%{#request.fqbean.FqUser.userId}"/>
<sj:datepicker label="Date of Conviction" key="dateOfConviction" showAnim="slideDown" value="%{#request.fqbean.dateOfConviction}"></sj:datepicker>
<s:select  name="natureOfConviction"
 label="Nature of Conviction"  value="%{#request.fqbean.natureOfConviction}"
 list="#{'CRIMINAL IMPRISONMENT':'CRIMINAL IMPRISONMENT','CRIMINAL WITHOUT IMPRISONMENT':'CRIMINAL WITHOUT IMPRISONMENT','CIVIL CONVICTION':'CIVIL CONVICTION '}">
</s:select>
<s:textarea key="comments" label="Comments: " value="%{#request.fqbean.comments}"/>
<s:submit value="Update"/>

</s:form>
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