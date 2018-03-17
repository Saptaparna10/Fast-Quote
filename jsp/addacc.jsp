<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Accident History</title>
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/usr.css" >
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/home1.css" >
<style>
input{
width: 170px;
}
#insuranceReg {
width: 530px;}
</style>
<script src="../js/jquery.js"></script>
<script src="../js/jquery.validation.js"></script>

<script>
$.validator.setDefaults({
	submitHandler: function(form) { 

	alert("Conviction History Submitted !");
	form.submit();
	}
});

$().ready(function() {
	
	
	//restricted number input
/*	  $("#covamt,#duration,#vehicleid").keydown(function(event) {
        // Allow: backspace, delete, tab, escape, and enter
        if ( event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 27 || event.keyCode == 13 || 
             // Allow: Ctrl+A
            (event.keyCode == 65 && event.ctrlKey === true) || 
             // Allow: home, end, left, right
            (event.keyCode >= 35 && event.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        else {
            // Ensure that it is a number and stop the keypress
            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) {
                event.preventDefault(); 
            }   
        }
    });
	*/
	
	// validate signup form on keyup and submit
	$("#insuranceReg").validate({
 		debug:true,
 		rules:{
		userId:{required:true,
		number:true},
		vehicleId:{required:true,
			number:true},
 			natureOfConviction:"required",
 			dateOfConviction:"required"
	}
		});

	$("#reset").click(function(){
	$("label.error").css("display","none");

});

	
	});

</script>

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



<div class="insuranceRegBox" style="margin: 0px auto;">
<form id="insuranceReg" name="insuranceReg" action="Accidentinsert" method="post">
<fieldset>
   <legend align="middle"><b> Accident History </b></legend><br>
<p><label for="USERID">User Id<font color=red size=2px> *</font> :</label>
<input type="text" name="userId" required="true"></p>
<span class="error">${useriderror}</span></p>
<p><label for="VEHICLEID">Vehicle Id<font color=red size=2px> *</font> :</label>
<input type="text" name="vehicleId" required="true"></p>
<span class="error">${vehicleiderror}</span></p>
<p><label for="dateOfAccident">Date Of Accident<font color=red size=2px > *</font> :</label>
<sj:datepicker key="dateOfAccident" showAnim="slideDown" placeholder="Enter date in mm/dd/yyyy format" required="true" ></sj:datepicker>
</p>


<p><label for="natureOfAccident">Nature Of Accident<font color=red size=2px> *</font> :</label>
<s:select name="natureOfAccident" headerkey="-1" headervalue="--Select--" required="true"
list="#{'GRIEVOUS':'GRIEVOUS','MAJOR':'MAJOR','MINOR':'MINOR','COSMETIC':'COSMETIC' }" ></s:select>
</p>

<p><label for="COMMENTS" style="vertical-align: top;">Comments :</label>
<textarea rows=4 cols=20 placeholder="Enter comments, if any, for the user" NAME="comments" id="comments"></textarea>
</p>

<p id="btnPara">  
<input type="submit" value="      Submit      "  class="button" id="submitBtn"  />
<input id="reset" type="reset" value="      Reset      " name="BtnReset" class="button">
</p>
</fieldset>
 </form>
</div>
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
</div>
</body>
</html>
