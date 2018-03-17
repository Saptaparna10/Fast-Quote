package com.tcs.ilp.handler;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddQuoteDao;
import com.tcs.ilp.model.QuoteBean;


public class GenerateQuoteRequestHandler {
	AddQuoteDao aqdao= new AddQuoteDao();
	DecimalFormat newFormat = new DecimalFormat("#.##");
	static ArrayList<QuoteBean> ar=new ArrayList<QuoteBean>();
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
	
		QuoteBean qbean=null;
		String proposal_id[]=request.getParameterValues("genQuote");
		System.out.println("proposal id length "+proposal_id.length);
		ar.clear();
		for(int i=0;i<proposal_id.length;i++){
			qbean=new QuoteBean();
			System.out.println(proposal_id[i]);
			qbean.setProposal_id(Long.parseLong(proposal_id[i]));
			ar.add(qbean);
		}
		
		aqdao.getquotedetails(ar,"PENDING");
		generateQuote(ar);
		try {
			aqdao.insertQuote(ar);
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
	public void generateQuote(ArrayList<QuoteBean> ar){
		Iterator it=ar.iterator();
		QuoteBean qb;
		while(it.hasNext()){
			qb=(QuoteBean) it.next();
			//System.out.println(qb.getAccident_history_id()+"\t"+qb.getClaim());
			String noa=aqdao.getNOA(qb);
			String noc=aqdao.getNOC(qb);
			
			if(noa.equalsIgnoreCase("GRIEVOUS"))
			{
			 if(noc.equalsIgnoreCase("CRIMINAL WITH IMPRISONMENT"))
				{
				qb.setDeduction((qb.getClaim())*(.11));
				  
				}
			 else if(noc.equalsIgnoreCase("CRIMINAL WITHOUT IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.09));
				 
				}
			 else if(noc.equalsIgnoreCase("CIVIL"))
				{
				 qb.setDeduction((qb.getClaim())*(.06));
				 
				}
			 else{
				 qb.setDeduction((qb.getClaim())*(.05));
			 }
			}
			else if(noa.equalsIgnoreCase("MAJOR"))
			{
			 if(noc.equalsIgnoreCase("CRIMINAL WITH IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.09));
				 
				}
			 else if(noc.equalsIgnoreCase("CRIMINAL WITHOUT IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.07));
				 
				}
			 else if(noc.equalsIgnoreCase("CIVIL"))
				{
				 qb.setDeduction((qb.getClaim())*(.04));
				 
				}
			 else{
				 qb.setDeduction((qb.getClaim())*(.03));
			 }
			}
			else if(noa.equalsIgnoreCase("MINOR"))
			{
			 if(noc.equalsIgnoreCase("CRIMINAL WITH IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.07));
				 
				}
			 else if(noc.equalsIgnoreCase("CRIMINAL WITHOUT IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.05));
				 
				}
			 else if(noc.equalsIgnoreCase("CIVIL"))
				{
				 qb.setDeduction((qb.getClaim())*(.02));
				 
				}
			 else{
				 qb.setDeduction((qb.getClaim())*(.01));
			 }
			}
			else if(noa.equalsIgnoreCase("COSMETIC"))
			{
			 if(noc.equalsIgnoreCase("CRIMINAL WITH IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.065));
				 
				}
			 else if(noc.equalsIgnoreCase("CRIMINAL WITHOUT IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.045));
				 
				}
			 else if(noc.equalsIgnoreCase("CIVIL"))
				{
				 qb.setDeduction((qb.getClaim())*(.015));
				 
				}
			 else{
				 qb.setDeduction((qb.getClaim())*(.005));
			 }
			}
			else{
				
				if(noc.equalsIgnoreCase("CRIMINAL WITH IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.06));
				 
				}
			 else if(noc.equalsIgnoreCase("CRIMINAL WITHOUT IMPRISONMENT"))
				{
				 qb.setDeduction((qb.getClaim())*(.04));
				 
				}
			 else if(noc.equalsIgnoreCase("CIVIL"))
				{
				 qb.setDeduction((qb.getClaim())*(.01));
				 
				}
			 else{
				 qb.setDeduction(0);
			 }
				
			}
			qb.setDeduction(Double.valueOf(newFormat.format(qb.getDeduction())));
			qb.setQuote(Double.valueOf(newFormat.format(qb.getClaim()-qb.getDeduction())));
			System.out.println("generateQuote:::: "+qb.getProposal_id()+"\t"+qb.getClaim()+"\t"+qb.getDeduction()+"\t"+qb.getQuote());

			
		}
		
	}

}
