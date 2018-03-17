<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="proposalAndQuoteController/UpdateConviction" method="post">
<input type="text" name="CONVICTION_ID" placeholder="Enter Conviction Id">
<input type="hidden" name="CONV_UPDATE" value="check">
<input type="submit" value="Submit">
</form>

<div class="error" align="center">${error}</div>


</body>
</html>