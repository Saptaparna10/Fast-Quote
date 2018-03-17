 																																																																																																																																																																																																																																																												package com.tcs.ilp.handler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddAcddBean;
import com.tcs.ilp.model.AddAcddDao;


public class AddAccRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		
		String nextview=null;
		AddAcddBean bean=new AddAcddBean();
		
		//setting the values in to the bean
		
				bean.setUser_id(Long.parseLong(request.getParameter("USERID")));
				bean.setVeh_id(Long.parseLong(request.getParameter("VEHICLEID")));
				bean.setNac(request.getParameter("NOA"));
				bean.setDoa(request.getParameter("DOA"));
				bean.setComments("COMMENTS");
				
		AddAcddDao acdao=new AddAcddDao();
		acdao.addAcdd(bean);

		
		request.setAttribute("addacc", bean);
		return "AddAccConfirm.jsp";
	}


}
