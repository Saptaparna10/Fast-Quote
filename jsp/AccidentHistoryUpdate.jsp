<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accident History</title>
<link rel="stylesheet" type="text/css" href="../css/usr.css" >
<link rel="stylesheet" type="text/css" href="../css/home1.css" >
<style>
input{
width: 170px;
}
</style>
<script src="../js/jquery.js"></script>
<script src="../js/jquery.validation.js"></script>

<script>
$.validator.setDefaults({
	submitHandler: function(form) { 

	//alert("Accident History Submitted !");
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
 		USERID:"required",
 		VEHICLEID:{number: true},
	 DOA:{required:true,
		date:true},
				NOA:"required",
			
		
		messages: {
			MAKE: {
				required: "Please select make"
			},
			MODEL: {
				required: "Please select a model"
			},
			YOM:{
				required: "Please select year of manufacture"
				}
				}
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
<img src="images/Fast-quote_icon.gif" height="100px" width="100px" id="logo"><img src="images/fs.png" height="71px" width="557px" id="fs"></div></header>
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



<FORM  id="insuranceReg" name='insuranceReg' METHOD=post action="proposalAndQuoteController/AccidentHistory">
<fieldset>
   <legend align="middle"><b> Accident History </b></legend><br>
   <jsp:useBean id="updateAccbean" class="com.tcs.ilp.model.AddAcddBean" scope="request" />
   <input type='text' name = "ACCID" id = "Acc" placeholder="Enter the Accident id" disabled="disabled" value = <jsp:getProperty name="updateAccbean" property="acc_id"/> /></p>
   <input type="hidden" name="ACCDID" value="<jsp:getProperty name="updateAccbean" property="acc_id"/>" />
 
 <p><label for="USERID">User Id<font color=red size=2px> *</font> :</label>

<input type='text' placeholder="Enter the user id" name="USERID" value=<jsp:getProperty name="updateAccbean" property="user_id"/> ></p>

<p><label for="VEHICLEID">Vehicle Id :</label>&nbsp;<input type="text" placeholder="Enter the vehicle id (optional)" name="VEHICLEID" value=<jsp:getProperty name="updateAccbean" property="veh_id"/>>
</p>
<p><label for="DOA">Date of Accident<font color=red size=2px> *</font> :</label>
<INPUT TYPE="date" NAME="DOA" id="doa" value= <jsp:getProperty name="updateAccbean" property="doa"/>>

</p>

<p><label for="NOA">Nature of Accident<font color=red size=2px> *</font> :</label>
<SELECT id="noa" name="NOA" >
<option value=""><jsp:getProperty name="updateAccbean" property="nac"/></OPTION>
<OPTION VALUE="GRIEVOUS">GRIEVOUS</OPTION>
<OPTION VALUE="MAJOR">MAJOR</OPTION>
<OPTION VALUE="MINOR">MINOR</OPTION>
<OPTION VALUE="COSMETIC">COSMETIC</OPTION>
</SELECT>
</p>


<p><label for="COMMENTS" style="vertical-align: top;">Comments :</label>
<textarea rows=4 cols=20 placeholder="Enter comments, if any, for the user" NAME="COMMENTS" id="comments" ><jsp:getProperty name="updateAccbean" property="comments"/></textarea>
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