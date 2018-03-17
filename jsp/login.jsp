<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/main.css" >
<link rel="stylesheet" type="text/css" href="/FQ-Final/css/home1.css" >
<script type="text/javascript" src="js/main.js"></script>
<script src="/FQ-Final/js/jquery.js"></script>
<script src="/FQ-Final/js/jquery.validation.js"></script>

<style type="text/css">#menu td a b.active{color: rgb(144, 255, 144);}</style>
<script>
$.validator.setDefaults({
	submitHandler: function(form) { 
	/* var type=$("select[name='USER']").val();
	var username=$("input[name='USERNAME']").val();
	var password=$("input[name='PASS']").val();
	//alert(user);
	if(type == "ADMIN" && username == "admin" && password == "admin"){
	alert("Welcome ADMIN !"); 
	document.location.href="admin.html";
	}
	else if(type == "CUSTOMER" && username == "customer" && password == "customer"){
	alert("Welcome CUSTOMER !"); 
	document.location.href="customer.html";
	}
	else if(type == "EMPLOYEE" && username == "employee" && password == "employee"){
	alert("Welcome EMPLOYEE !"); 
	document.location.href="emp.html";
	}
	else{
		alert("Invalid username or password");
		} */
		
		form.submit();
		
}
});

$().ready(function() {
	// validate the comment form when it is submitted
//	$("#commentForm").validate();

	// validate signup form on keyup and submit
	$("#loginForm").validate({
//		highlight: function(element, errorClass) {
  //  $(element).fadeOut(function() {
    //  $(element).fadeIn();
  //  });
 // },
		
		rules:{
			userType:"required",
			userName: {required:true,
			minlength:2
			},
			password: {
				required:true,
				minlength:3
				},
				messages: {
			userName: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			}
				}
			}
		});

	$("#reset").click(function(){
	$("label.error").css("display","none");

	});
/*	$("#loginForm").validate({
		rules: {
			firstname: "required",
			lastname: "required",
			username: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			},
			topic: {
				required: "#newsletter:checked",
				minlength: 2
			},
			agree: "required"
		},
		messages: {
			firstname: "Please enter your firstname",
			lastname: "Please enter your lastname",
			username: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			agree: "Please accept our policy"
		}
	});
*/
	// propose username by combining first- and lastname
/*	$("#username").focus(function() {
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		if(firstname && lastname && !this.value) {
			this.value = firstname + "." + lastname;
		}
	});

	//code to hide topic selection, disable for demo
	var newsletter = $("#newsletter");
	// newsletter topics are optional, hide at first
	var inital = newsletter.is(":checked");
	var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
	var topicInputs = topics.find("input").attr("disabled", !inital);
	// show when newsletter is checked
	newsletter.click(function() {
		topics[this.checked ? "removeClass" : "addClass"]("gray");
		topicInputs.attr("disabled", !this.checked);
	});*/
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
<td><a href="login.html" style="text-decoration:none;"><b class="active">LOGIN<b></a></div></td>
<td><a href="registerUser.html" style="text-decoration:none;"><b>REGISTER</b></a></div></td>
<td><a href="#contactUs.html" style="text-decoration:none;"><b>CONTACT US</b></a></div></td>
</tr>
</table>
</div></div>
<div id="content" >
<div class="wrap">


<div class="loginbox"  style="margin-left:210px;margin-bottom: 30px;">
<form method="post" name="loginForm"   id="loginForm" action="Emp/login">
                                    
                                    <fieldset>
                                    <legend align="middle"><b> LOGIN </b></legend><br>
                                    
                                    <div class="error">${error }</div>
                                    <p><label for="USER">Select user type :</label>
                                            
                                            <select size="1" name="userType">
                                              <option value> -PLEASE SELECT A USER- </option>
                                              <option value="CUSTOMER">CUSTOMER</option>
                                              <option value="EMPLOYEE">EMPLOYEE</option>
                                              <option value="ADMIN">ADMIN</option>
                                            </select>
                                            </p>
                                          <p><label for="USERNAME">Enter Username :</label>
                                          <input type="text" name="userName" size="8" placeholder="Username" maxlength="8" style="width:190px;">
                                          <label for="USERNAME" class="error" style="display: none;"></label>
                                        </p> 
                                        
                                        <p><label for="PASSWORD">Enter Password :</label>
                                            <input type="password" name="password" size="10" placeholder="Password"  maxlength="10" style="width:190px;">
                                        </p>
                                        <p id="btnPara">        <input type="submit" value="     Submit     " name="BtnSubmit" class="button">
                                                <input id="reset" type="reset" value="      Reset      " name="BtnReset" class="button"> <a href="forgotPass.html">Forgot Password?</a>
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


</body>
</html>