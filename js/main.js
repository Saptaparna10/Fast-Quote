function Login_Validator(theForm){
	
	 if (theForm.USER.selectedIndex <= 0)
	  {
	    alert("Please select one of the Users from the list");
	    theForm.USER.focus();
	    return (false);
	  }
	  if (theForm.USERNAME.value == "")
	  {
	    alert("Please enter the username");
	    theForm.USERNAME.focus();
	    return (false);
	  }
	  
	  if (theForm.PASS.value == "")
	  {
	    alert("Please enter the password");
	    theForm.PASS.focus();
	    return (false);
	  }
	  
	  
	  //admin login
	  
	  if(theForm.USERNAME.value == "admin" &&  theForm.PASS.value=="admin")
	  {
		  alert("Welcome ADMIN !");
		  
	  }
	  if(theForm.USERNAME.value == "customer" &&  theForm.PASS.value=="customer"){}
		  
	  
	 

	 

	
}