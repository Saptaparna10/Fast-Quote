package com.tcs.ilp.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddQuoteDao;
import com.tcs.ilp.model.ClaimBean;
import com.tcs.ilp.model.QuoteBean;

public class ViewQuoteRequestHandler {

	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		AddQuoteDao vc=new AddQuoteDao();
		ArrayList<QuoteBean> ar=vc.getQuote();
		if(ar.isEmpty()){
			request.setAttribute("noClaim", "No proposals found");
		}
		else{
		request.setAttribute("viewQuote", ar);
		}
		return "ViewQuote.jsp";
	}

}
