package com.tcs.ilp.handler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddQuoteDao;
import com.tcs.ilp.model.QuoteBean;

public class DeleteQuoteRequestHandler {
	AddQuoteDao aqdao= new AddQuoteDao();
	static ArrayList<QuoteBean> arr=new ArrayList<QuoteBean>();
	GenerateQuoteRequestHandler genQuote=new GenerateQuoteRequestHandler();
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		AddQuoteDao vc=new AddQuoteDao();
		System.out.println("in delete1");
		ArrayList<QuoteBean> ar=vc.getQuote();
		if(ar.isEmpty()){
			request.setAttribute("noClaim", "No proposals found");
		}
		else{
			Iterator it = ar.iterator();
			while(it.hasNext()){
			QuoteBean bean=(QuoteBean)it.next();
			System.out.println(bean.getAccident_history_id()+"\t"+bean.getClaim());
			}
			
		request.setAttribute("deleteQuote", ar);
		}
		return "DeleteQuoteView.jsp";
	}

	public String deleteRequestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		QuoteBean qbean=null;
		String proposal_id[]=request.getParameterValues("deleteQuote");
		System.out.println("proposal id length "+proposal_id.length);
		arr.clear();
		for(int i=0;i<proposal_id.length;i++){
			qbean=new QuoteBean();
			System.out.println(proposal_id[i]);
			qbean.setProposal_id(Long.parseLong(proposal_id[i]));
			arr.add(qbean);
		}
		
		aqdao.getquotedetails(arr,"APPROVED");
		genQuote.generateQuote(arr);
		
		try {
			aqdao.updateQuote(arr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("confirmDeleteQuote", arr);
		request.getSession().setAttribute("confirmDeleteQuote", arr);
		
		return "confirmdeletequote.jsp";
	}

	public String deleteConfirmRequestHandle(HttpServletRequest request,
			HttpServletResponse response) {
			boolean done=false; 
		arr=(ArrayList<QuoteBean>)request.getSession().getAttribute("confirmDeleteQuote");
		try {
			done=aqdao.deleteTheseQuotes(arr);
			request.getSession().removeAttribute("confirmDeleteQuote");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(done)
			return "deleteSuccessful.jsp";
		else
			return "deleteUnsuccessful.jsp";
	}

}