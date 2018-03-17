package com.tcs.ilp.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.model.ConvictionHistoryDao;
import com.tcs.ilp.model.FqConvictionhistory;
import com.tcs.ilp.model.FqUser;

public class ConvictionAction extends ActionSupport implements ModelDriven<FqConvictionhistory>


 { 
	FqConvictionhistory conBean=new FqConvictionhistory();
	long userId;
	
	Map requestMap = (Map) ActionContext.getContext().get("request");
	Map sessionMap = (Map) ActionContext.getContext().get("session");


	
	public FqConvictionhistory getConBean() {
		return conBean;
	}


	public void setConBean(FqConvictionhistory conBean) {
		this.conBean = conBean;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String myMethod(){
		
	System.out.println("ia minside action : " + userId);
		
	FqConvictionhistory result =new FqConvictionhistory();
	    ConvictionHistoryDao convcdao= new ConvictionHistoryDao();
	    FqUser user=new FqUser();
	    user.setUserId(getUserId());
	    int found=convcdao.getUserDetails(user);
	    if(found==1){
	    	conBean.setFqUser(user);
	    result=convcdao.insert(conBean);
	    }
	    
	    else if(found==0)
	    {
	    	 ServletActionContext.getRequest().setAttribute("useriderror", "Invalid UserId");
	    	return "input";
	    }
	    else if(found==-2)
	    {
	    	return "DBerror";
	    }
	    
	   
	    if(result.getConvictionHistoryId()!=0)
		   {
	    	requestMap.put("result", result);
			   return SUCCESS;
		   }
		   else
		   {
			   
			   return ERROR;
		   }
	    
	   
	    
	    
	}
	
	
	public String myview()
	{
		String restring = ERROR;
		
		 ConvictionHistoryDao convcdao= new ConvictionHistoryDao();
		int result=convcdao.view(conBean);
		
		 
		if(result==1)
		{
			restring= SUCCESS;
		}
		
		else if(result==0)
		{
			 ServletActionContext.getRequest().setAttribute("convciderror", "Invalid ConvcId");
		    	return "input";
		}
		
		 else if(result==-2)
		    {
			 restring= "DBerror";
		    }
		return restring;
		
		
	}
	public String delete()
	{
		
		String restring=ERROR;
		ConvictionHistoryDao convcdao=new ConvictionHistoryDao();
		FqConvictionhistory cnbean=convcdao.getConvictionDetails(conBean.getConvictionHistoryId());
		
		if(cnbean.getConvictionHistoryId()==0)
		{
			System.out.println("iam n delete convc dao");
			ServletActionContext.getRequest().setAttribute("convciderror", "Invalid ConvcId");
	    	//return "input";
    		restring="input";
		}
		
		else
		{
		
	/*	int result=convcdao.deleteconvc(conBean);
		
		if(result==1){
			restring= SUCCESS;	
		}
		else if(result==0)
		{
			restring= ERROR;	
		}
		else if(result==2)
		{
			restring= "IDnotfound";	
			
		
		} */
			requestMap.put("cnbean", cnbean);
			sessionMap.put("cnbean", cnbean);
			restring ="confirmdel";
		
		}
		return restring;
		
	}
	
	
	public String confirmdelete()
	{
		String restring=ERROR;
		ConvictionHistoryDao convcdao=new ConvictionHistoryDao();
		//System.out.println(((FqConvictionhistory)((Map)ActionContext.getContext().get("session")).get("cnbean")).getConvictionHistoryId());
		FqConvictionhistory conBean1=(FqConvictionhistory) sessionMap.get("cnbean");
		//System.out.println(":::;;;;; "+conBean1.getConvictionHistoryId()+"\t"+conBean1.getNatureOfConviction());
     int result=convcdao.deleteconvc(conBean1);
		
		if(result==1){
			restring= SUCCESS;	
		}
		else if(result==0)
		{
			restring= ERROR;	
		}
		else if(result==2)
		{
			restring= "IDnotfound";	
			
		
		}
		
		return restring;
		
	}
	
	public String chkconvc()
	{
		
		String restring=ERROR;
		int result=0;
	    ConvictionHistoryDao convcdao= new ConvictionHistoryDao();
	    FqUser user=new FqUser();
	    user.setUserId(getUserId());
	    FqConvictionhistory foundbean=convcdao.getConvictionDetails(conBean.getConvictionHistoryId());
	    if(foundbean.getConvictionHistoryId()!=0){
	     	
	     requestMap.put("fqbean", foundbean);
	   
	     restring = SUCCESS;
	    }
	    else
	    {
	    	ServletActionContext.getRequest().setAttribute("convciderror", "Invalid ConvcId");
	    	//return "input";
    		restring="input";
	    }
		
		return restring;
	}
	
	public String confrmupdate()
	{
		 ConvictionHistoryDao convcdao= new ConvictionHistoryDao();
		 FqUser user=new FqUser();
		    user.setUserId(getUserId());
		    conBean.setFqUser(user);
		  int res= convcdao.update(conBean);
		if(res==1)
		{
			 return SUCCESS;
		}
		
		else
		{
			return ERROR;
		}
		
	}
	
	

	@Override
	public FqConvictionhistory getModel() {
		// TODO Auto-generated method stub
		return conBean;
	}

}