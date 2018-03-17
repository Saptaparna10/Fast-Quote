package com.tcs.ilp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.handler.AddAccRequestHandler;
import com.tcs.ilp.handler.AddConvcRequestHandler;
import com.tcs.ilp.handler.DeleteAcddRequestHandler;
import com.tcs.ilp.handler.DeleteConvcRequestHandler;
import com.tcs.ilp.handler.DeleteQuoteRequestHandler;
import com.tcs.ilp.handler.GenerateQuoteRequestHandler;
import com.tcs.ilp.handler.UpdateAccRequestHandler;
import com.tcs.ilp.handler.UpdateConvcRequestHandler;
import com.tcs.ilp.handler.UpdateQuoteRequestHandler;
import com.tcs.ilp.handler.ViewAcddRequestHandler;
import com.tcs.ilp.handler.ViewClaimRequestHandler;
import com.tcs.ilp.handler.ViewConvcRequestHandler;
import com.tcs.ilp.handler.ViewQuoteRequestHandler;




/**
 * Servlet implementation class ProposalAndQuoteController
 */
public class ProposalAndQuoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProposalAndQuoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=null;
		String nextView=null;
		path=request.getPathInfo();
		
		if(path.indexOf("DeleteQuoteView")!=-1){
			DeleteQuoteRequestHandler view=new DeleteQuoteRequestHandler();
			nextView=view.requestHandle(request,response);
		}
		else if(path.indexOf("DeleteQuoteBeforeConfirm")!=-1){
			DeleteQuoteRequestHandler del=new DeleteQuoteRequestHandler();
			nextView=del.deleteRequestHandle(request,response);
		}
		else if(path.indexOf("DeleteQuoteConfirm")!=-1){
			DeleteQuoteRequestHandler del=new DeleteQuoteRequestHandler();
			nextView=del.deleteConfirmRequestHandle(request,response);
		}
		else if(path.indexOf("ViewQuote")!=-1){
			ViewQuoteRequestHandler view=new ViewQuoteRequestHandler();
			nextView=view.requestHandle(request,response);
		}
		else if(path.indexOf("UpdateQuote")!=-1){
			System.out.println("in updatequote");
			UpdateQuoteRequestHandler update=new UpdateQuoteRequestHandler();
			nextView=update.requestHandle(request,response);
		}
		
		else if(path.indexOf("UpdateConviction")!=-1){
			UpdateConvcRequestHandler updateConv=new UpdateConvcRequestHandler();
			nextView=updateConv.requestHandle(request,response);
		}
		else if(path.indexOf("UpdateAccident")!=-1){
			UpdateAccRequestHandler updateAcc=new UpdateAccRequestHandler();
			nextView=updateAcc.requestHandle(request,response);
		}
		
		
		
		else if(path.indexOf("ViewClaim")!=-1){
			System.out.println("inside view claim");
			ViewClaimRequestHandler view=new ViewClaimRequestHandler();
			nextView=view.requestHandle(request,response);
			
		}
		else if(path.indexOf("GenerateQuote")!=-1){
			System.out.println("in genquote");
			GenerateQuoteRequestHandler genQuote=new GenerateQuoteRequestHandler();
			nextView=genQuote.requestHandle(request,response);
			
		}
		
            else if(path.indexOf("ConvictionHistory")!=-1){
			
			AddConvcRequestHandler view=new AddConvcRequestHandler();
			nextView=view.requestHandle(request,response);
			
		}
            else if(path.indexOf("AccidentHistory")!=-1){
			
			AddAccRequestHandler view=new AddAccRequestHandler();
			nextView=view.requestHandle(request,response);
			
		}
            else if(path.indexOf("viewconviction")!=-1){
    			
            	ViewConvcRequestHandler view=new ViewConvcRequestHandler();
    			nextView=view.requestHandle(request,response);
    			
    			
    		}
 else if(path.indexOf("viewAccident")!=-1){
    			
            	
            	ViewAcddRequestHandler view=new ViewAcddRequestHandler();
    			nextView=view.requestHandle(request,response);
    			
    			
    		}
		
 else if(path.indexOf("DeleteAccident")!=-1  || (path.indexOf("confirmdelacc")!=-1)){
		
 	
 	DeleteAcddRequestHandler view=new DeleteAcddRequestHandler();
		nextView=view.requestHandle(request,response);
		
		
	}
		else if(path.indexOf("DeleteConvc")!=-1 || (path.indexOf("confirmdelconvc")!=-1)){
			
        	
        	DeleteConvcRequestHandler view=new DeleteConvcRequestHandler();
			nextView=view.requestHandle(request,response);
			
			
		}
		System.out.println(nextView);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/"+nextView);
		rd.forward(request, response);
		}

	}
