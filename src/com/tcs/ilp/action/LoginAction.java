package com.tcs.ilp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.model.FqLogin;
import com.tcs.ilp.model.LoginDao;

public class LoginAction extends ActionSupport implements ModelDriven{

	FqLogin bean=new FqLogin();
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return bean;
	}
	
	public FqLogin getBean() {
		return bean;
	}

	public void setBean(FqLogin bean) {
		this.bean = bean;
	}

	public String checkLogin()
	{
		int result=new LoginDao().checkUser(bean);
		System.out.println("resultCode: "+result);
		if(result==1)
			return SUCCESS;
		else //r=-1,0,-2
		{
			/*
			 * <action name="add_user" class="org.apache.struts.gestion_edt.controller.adm_proyectos.BLTipoEntregable" method="addUser">
    <result type="redirectAction">
        <param name="actionName">search_users</param>
        <!--<param name="namespace">/secure</param> This is optional if your action where you are redirecting is in the same namespace you can leave this, if your action is in some other name space then provide the namespace--> 
    </result>
</action>
			 * 
			 * */
			
			
			ServletActionContext.getRequest().setAttribute("error", "Invalid username/password");
			RequestDispatcher rd=ServletActionContext.getRequest().getRequestDispatcher("/login.jsp");
			try {
				rd.forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "login";
			}
			return "login";
		}
	}

}
