<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head/>
</head>
<body>
<div id="global">
<s:form action="Accidentinsert">
<s:textfield key="userId" label="User ID"></s:textfield>
<s:textfield key="vehicleId" label="Vehicle ID"> </s:textfield>
<sj:datepicker key="dateOfAccident" label="Date Of Accident" showAnim="slideDown"></sj:datepicker>

<s:select list="natureOfAccident" label="Nature Of Accident" headerkey="-1" headervalue="--Select--" 
list="#{'0':'--Select--','1':'GRIEVOUS','2':'MAJOR','3':'MINOR','4':'COSMETIC' }"></s:select>
<s:textarea key="comments" label="Comments:"></s:textarea>
<s:submit vaule="Add"></s:submit>

 </s:form>
</body>
</div> 
</html>

