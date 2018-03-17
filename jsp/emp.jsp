<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Services</title>
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/usr.css" >
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/home1.css" >
<script src="/FQ-Final/js/jquery.js"></script>
<script src="/FQ-Final/js/jquery.validation.js"></script>

<script>
$.validator.setDefaults({
	submitHandler: function() { 

	alert("Password changed successfully !");
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
 		USERID:"required",
	 DOB:{required:true,
		date:true,
		max:"20-09-1995"},
		NEWPASS:{required:true,
			minlength:5},
			CONFIRMPASS:{required:true,
				minlength:5,
				equalTo:"#newpass"}
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
<td><a href="index.jsp" style="text-decoration:none;" ><b>HOME</b></a></div></td>
<td><a href="#aboutUs.html"  style="text-decoration:none;"><b>ABOUT US</b></a></div></td>
<td><a href="emp.html" style="text-decoration:none;"><b class="active">SERVICES</b></a></div></td>
<td><a href="index.html" style="text-decoration:none;"><b>LOGOUT</b></a></div></td>
</tr>
</table>
</div></div>
<div id="content" >
<div class="wrap">




<div class="insuranceRegBox" style="margin-left: 160px;margin-bottom: 106px;">
<FORM  id="insuranceReg" name='insuranceReg' METHOD=GET>
<fieldset>
   <legend align="middle"><b> Welcome Employee ! </b></legend><br>


<p><label for="USERID" style="width:auto;"><a href="AddAccident">Add Accident History</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="DeleteAccident">Delete Accident History</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="ViewAccident">View Accident History</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="UpdateAccident">Update Accident History</a></label></p>

<hr><hr>


<p><label for="USERID" style="width:auto;"><a href="AddConviction">Add Conviction History</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="DeleteConviction">Delete Conviction History</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="ViewConviction">View Conviction History</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="UpdateConviction">Update Conviction History</a></label></p>


<hr><hr>

<p><label for="USERID" style="width:auto;"><a href="/FQ-Final/proposalAndQuoteController/ViewClaim">Generate Quote</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="/FQ-Final/proposalAndQuoteController/ViewQuote">Update Quote</a></label></p>

<p><label for="USERID" style="width:auto;"><a href="/FQ-Final/proposalAndQuoteController/DeleteQuoteView">Delete Quote</a></label></p>





<p id="btnPara">  
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