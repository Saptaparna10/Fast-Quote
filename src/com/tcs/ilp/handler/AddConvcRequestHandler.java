package com.tcs.ilp.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddConvcBean;
import com.tcs.ilp.model.AddConvcDao;

public class AddConvcRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		
		String nextview=null;
		AddConvcBean bean=new AddConvcBean();
		
		//setting the values in to the bean
		
				bean.setUid(Long.parseLong(request.getParameter("USERID")));
				
				bean.setNoc(request.getParameter("NOC"));
				bean.setDoc(request.getParameter("DOC"));
				bean.setComments(request.getParameter("COMMENTS"));
				
		AddConvcDao acdao=new AddConvcDao();
		acdao.addconvc(bean);
		
		request.setAttribute("addconvc", bean);
		
		
		
		
		
		
	
		return "AddConvcConfirm.jsp";
	}

}
