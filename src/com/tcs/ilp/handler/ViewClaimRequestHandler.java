package com.tcs.ilp.handler;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddQuoteDao;
import com.tcs.ilp.model.ClaimBean;

public class ViewClaimRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		AddQuoteDao vc=new AddQuoteDao();
		ArrayList<ClaimBean> ar=vc.getClaim("PENDING");
		if(ar.isEmpty()){
			request.setAttribute("noClaim", "No proposals found");
		}
		else{
		request.setAttribute("viewClaim", ar);
		}
		return "ViewClaim.jsp";
	}

}