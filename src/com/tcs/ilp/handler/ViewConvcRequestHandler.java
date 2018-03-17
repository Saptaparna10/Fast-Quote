package com.tcs.ilp.handler;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddConvcBean;
import com.tcs.ilp.model.AddConvcDao;


public class ViewConvcRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		
		System.out.println("ima in req handler");
		
		AddConvcDao adao=new AddConvcDao();
		ArrayList<AddConvcBean> ar=adao.viewConvc();
		request.setAttribute("viewConvc", ar);
		
		return "ViewConvcAll.jsp";
	}

}