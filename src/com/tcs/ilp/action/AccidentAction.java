package com.tcs.ilp.action;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.model.AccidentHistoryDao;
import com.tcs.ilp.model.ConvictionHistoryDao;
import com.tcs.ilp.model.FqAccidenthistory;
import com.tcs.ilp.model.FqConvictionhistory;
import com.tcs.ilp.model.FqUser;
import com.tcs.ilp.model.FqVehicle;

public class AccidentAction extends ActionSupport implements ModelDriven<FqAccidenthistory> {

	FqAccidenthistory fqbean=new FqAccidenthistory();
	long userId;
	long vehicleId;
	int result;
	
	Map requestMap = (Map) ActionContext.getContext().get("request");
	Map sessionMap = (Map) ActionContext.getContext().get("session");
	
	public long getVehicleId() {
		return vehicleId;
	}




	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}




	public FqAccidenthistory getFqbean() {
		return fqbean;
	}




	public void setFqbean(FqAccidenthistory fqbean) {
		this.fqbean = fqbean;
	}




	public long getUserId() {
		return userId;
	}




	public void setUserId(long userId) {
		this.userId = userId;
	}




	public String insert()
	{
		
		String restring = ERROR;
		boolean foundUser,foundVehicle;
		AccidentHistoryDao acdao=new AccidentHistoryDao();
		FqAccidenthistory result1;
		FqUser user=new FqUser();
	    user.setUserId(getUserId());
	    FqVehicle vech=new FqVehicle();
	    
	    
	    foundUser=acdao.getUserDetails(user);
	    if(foundUser){
	    	System.out.println("user found");
	    	fqbean.setFqUser(user);
	    	
	    	if(getVehicleId() != 0){
	    		System.out.println("vechile !=0");
		    	vech.setVehicleId(getVehicleId());
		    	foundVehicle=acdao.getVehicleDetails(vech);
		    	if(foundVehicle){
		    		System.out.println("vechile found");
		    		fqbean.setFqVehicle(vech);
		    		result1 = acdao.insert(fqbean);
			    	 
			    	 if(result1.getAccidentHistoryId()!=0)
			 	    { 
			    		 System.out.println("Acc his !=0");
			 	    	 requestMap.put("result1", result1);
			 	    	 //return SUCCESS;
			 	    	restring=SUCCESS;
			 	    }
			    	 else
			    	 {
			    		 restring=ERROR;
			    	 }
			 	    
		    	}
		    	else{
		    		
		    		 System.out.println("-- vech id errror");
		    		ServletActionContext.getRequest().setAttribute("vehicleiderror", "Invalid VehicleId");
			    	//return "input";
		    		restring="input";
		    	}
		    	
		    }
	    	
	    	else{
	    		
	    		 System.out.println("--++ vech id errror");
	    		ServletActionContext.getRequest().setAttribute("vehicleiderror", "Invalid VehicleId");
		    	//return "input";
	    		restring="input";
	    	}
	    	 
	    	
	    }
	    else
	    {
	    	System.out.println("--++ user id errror");
	    	ServletActionContext.getRequest().setAttribute("useriderror", "Invalid UserId");
	    	restring="input";
	    	//return "input";
	  
	    }
	  
	    
	 return restring;
		
	}
	
	public String myview()
	{
		
		String restring;
		 AccidentHistoryDao convcdao= new AccidentHistoryDao();
		 ArrayList<FqAccidenthistory> list=convcdao.view(fqbean);
		 fqbean.setList(list);
		 
		if(list.size()!=0)
		{
			restring= SUCCESS;
		}
		
		else
		{
			restring= "input";	
			ServletActionContext.getRequest().setAttribute("acciderror", "Invalid AccId");
		}
		
		return restring;
	}
	
	public String delete()
	{
		String restring=ERROR;
		AccidentHistoryDao convcdao=new AccidentHistoryDao();
		FqAccidenthistory accbean=convcdao.getAccidentDetails(fqbean.getAccidentHistoryId());
		
		if(accbean.getAccidentHistoryId()==0)
		{
			restring= "input";	
			ServletActionContext.getRequest().setAttribute("acciderror", "Invalid AccId");
		}
		
		else
		{
		     requestMap.put("accbean", accbean);
		     sessionMap.put("accbean", accbean);
			restring ="confirmdel";
	   }
		
		return restring;
	}
	
	
	
	public String Muldelete()
	{
		String resstring;
		
		AccidentHistoryDao acdao=new AccidentHistoryDao();
		ArrayList<FqAccidenthistory> delbeanar = acdao.getAcctab();
       
		if(delbeanar.get(0).getAccidentHistoryId()!=0)
		{
			 sessionMap.put("delbeanar", delbeanar);
			 resstring=SUCCESS;
		}
		
		else
		{
			resstring=ERROR;
		}
		
		
		return resstring;
	}
	
	public String confirmdelete()
	{

		String restring=ERROR;
		AccidentHistoryDao accdao=new AccidentHistoryDao();
		FqAccidenthistory bean=(FqAccidenthistory)sessionMap.get("accbean");
		int res=accdao.deleteconvc(bean);
		
		if(res==2)
			restring="IDnotfound";
		else if(res==1)
		{
			restring= SUCCESS;
		}
		else
		{
			restring=ERROR;
		}
		
		
     
		
		return restring;
		
	
	}
	public String ConfirmMuldelete()
	{
		String Resstring=ERROR;
		
		AccidentHistoryDao acdao=new AccidentHistoryDao();
		
		
		return Resstring;
		
	}
	
	public String chkconvc()
	{
		
		String restring=ERROR;
		int result=0;
	    AccidentHistoryDao accdao= new AccidentHistoryDao();
	    FqUser user=new FqUser();
	    user.setUserId(getUserId());
	    FqAccidenthistory foundbean=accdao.getAccidentDetails(fqbean.getAccidentHistoryId());
	    if(foundbean.getAccidentHistoryId()!=0){
	     
	    	System.out.println("gonna chk date :"+fqbean.getDateOfAccident());
	        requestMap.put("fqbean", foundbean);
	   
	      restring= SUCCESS;
	    }
	    else
	    {
	    	restring= "input";	
			ServletActionContext.getRequest().setAttribute("acciderror", "Invalid AccId");
	    }
		
	    return restring;
		
	}
	
	public String confrmupdate()
	{
		
		 String restring=ERROR;
		boolean foundUser,foundVehicle;
		AccidentHistoryDao acdao=new AccidentHistoryDao();
		
		FqUser user=new FqUser();
	    user.setUserId(getUserId());
	    FqVehicle vech=new FqVehicle();
	    
	    
	    foundUser=acdao.getUserDetails(user);
	    if(foundUser){
	    	fqbean.setFqUser(user);
	    	
	    	if(getVehicleId() != 0){
		    	vech.setVehicleId(getVehicleId());
		    	foundVehicle=acdao.getVehicleDetails(vech);
		    	if(foundVehicle){
		    		fqbean.setFqVehicle(vech);
		    	}
		    	else{
		    		restring= "input";	
					ServletActionContext.getRequest().setAttribute("acciderror", "Invalid AccId");
		    	}
		    }
	    	result=acdao.update(fqbean);
	    }
	    else
	    {
	    	ServletActionContext.getRequest().setAttribute("useriderror", "Invalid UserId");
	    	restring="input";
	    }
	    	
	    if(result==1)
	    	restring= SUCCESS;
	    else
	    	restring= ERROR;
	 
		return restring;
	}
	
	
	
	
	@Override
	public FqAccidenthistory getModel() {
		// TODO Auto-generated method stub
		return fqbean;
	}
	
	
	
	

}
