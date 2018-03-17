<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Conviction History</title>
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/usr.css" >
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/home1.css" >
<style>
input{
width: 170px;
}
#insuranceReg {
width: 530px;}
</style>
<script src="/FQ-Final/js/jquery.js"></script>
<script src="/FQ-Final/js/jquery.validation.js"></script>

<script>
$.validator.setDefaults({
	submitHandler: function(form) { 
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
 		debug:true ,
 		rules:{
 			userId:{required:true,
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
<img src="/FQ-Final/images/Fast-quote_icon.gif" height="100px" width="100px" id="logo"><img src="/FQ-Final/images/fs.png" height="71px" width="557px" id="fs"></div></header>
<div id="menu">
<div class="wrap">
<table>
<tr>
<td><a href="index.html" style="text-decoration:none;" ><b>HOME</b></a></div></td>
<td><a href="#aboutUs.html"  style="text-decoration:none;"><b>ABOUT US</b></a></div></td>
<td><a href="emp.html" style="text-decoration:none;"><b class="active">SERVICES</b></a></div></td>
<td><a href="index.html" style="text-decoration:none;"><b>LOGOUT</b></a></div></td>
</tr>
</table>
</div></div>
<div id="content" >
<div class="wrap">



<div class="insuranceRegBox" style="margin: 0px auto;">
<FORM  id="insuranceReg" name="insuranceReg" action="Convictioninsert" method="post">
<fieldset>
   <legend align="middle"><b> Conviction History </b></legend><br>
                                    <p><label for="USERID">User Id<font color=red size=2px> *</font> :</label>
<input type='text' placeholder="Enter the user id" name="userId" >
 <span class="error">${useriderror}</span></p>

<p><label for="NOC">Nature of Conviction<font color=red size=2px> *</font> :</label>
<SELECT name="natureOfConviction" id="noc" >
<option value="">-Select-</OPTION>
<option value="CRIMINAL IMPRISONMENT">CRIMINAL WITH IMPRISONMENT</OPTION>
<option value="CRIMINAL WITHOUT IMPRISONMENT">CRIMINAL WITHOUT IMPRISONMENT</OPTION>
<OPTION VALUE="CIVIL">CIVIL CONVICTION </OPTION>
</SELECT>
</p>
<p><label for="DOC">Date of Conviction<font color=red size=2px> *</font> :</label>
<INPUT TYPE="text" placeholder="Enter date in mm/dd/yyyy format" NAME="dateOfConviction" id="doc">

</p>



<p><label for="COMMENTS" style="vertical-align: top;">Comments :</label>
<textarea rows=4 cols=20 placeholder="Enter comments, if any, for the user" NAME="comments" id="comments"></textarea>
</p>

<p id="btnPara">  
<INPUT TYPE=SUBMIT value="     Submit     " name="BtnSubmit" class="button" id="submitBtn" />
<input id="reset" type="reset" value="      Reset      " name="BtnReset" class="button">
</p>
</fieldset>
</FORM>
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

</body>
</html>