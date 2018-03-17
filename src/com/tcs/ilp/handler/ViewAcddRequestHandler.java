package com.tcs.ilp.handler;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddAcddBean;
import com.tcs.ilp.model.AddAcddDao;


public class ViewAcddRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		
		AddAcddDao adao=new AddAcddDao();
		ArrayList<AddAcddBean> ar=adao.viewAccd();
		request.setAttribute("viewAcdd", ar);
		
		return "ViewAccidentAll.jsp";
	}

}