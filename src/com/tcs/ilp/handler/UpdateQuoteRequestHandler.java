package com.tcs.ilp.handler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddQuoteDao;
import com.tcs.ilp.model.QuoteBean;

public class UpdateQuoteRequestHandler {

	AddQuoteDao aqdao= new AddQuoteDao();
	static ArrayList<QuoteBean> ar=new ArrayList<QuoteBean>();
	GenerateQuoteRequestHandler genQuote=new GenerateQuoteRequestHandler();
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		QuoteBean qbean=null;
		String proposal_id[]=request.getParameterValues("updateQuote");
		System.out.println("proposal id length "+proposal_id.length);
		ar.clear();
		for(int i=0;i<proposal_id.length;i++){
			qbean=new QuoteBean();
			System.out.println(proposal_id[i]);
			qbean.setProposal_id(Long.parseLong(proposal_id[i]));
			ar.add(qbean);
		}
		
		aqdao.getquotedetails(ar,"APPROVED");
		genQuote.generateQuote(ar);
		
		try {
			aqdao.updateQuote(ar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("updatedQuote", ar);
		
		return "updatedquote.jsp";
	}

}
