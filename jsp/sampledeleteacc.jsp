<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<Form name="f" action="proposalAndQuoteController/DeleteAccident" method="post" > 
<input type="hidden" name="ACCDELCHECK" value="check">
<input type="text" name="accident_id" placeholder="Enter accident history id" />
<input type="submit" value="delete accident history" />

<div class="error" align="center">${error}</div>

</Form>

</body>
</html>