package com.tcs.ilp.handler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddConvcBean;
import com.tcs.ilp.model.AddConvcDao;

public class DeleteConvcRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String nextView=null;
		String check=request.getParameter("CONVICDELCHECK");
		AddConvcBean bean=new AddConvcBean();
		AddConvcDao adoa=new AddConvcDao();
		AddConvcBean count;
		if(check.equals("check")){
					
				String id=request.getParameter("conviction_id");
				
				
				bean.setConvictionid(Long.parseLong(id));
				
				
				count=adoa.delconvc(bean,false);
				if(count.getConvictionid()==0)
				{
					request.setAttribute("error", "invalid Conviction ID");
					nextView="sampledeleteconvc.jsp";
				}
				
				else
				{
					request.setAttribute("delconvcbean", count);
					nextView="confirmdelconvc.jsp";
				}
		}
		else if(check.equals("delete")){
			long convic_id=Long.parseLong(request.getParameter("CONVICID"));
			bean.setConvictionid(convic_id);
			count=adoa.delconvc(bean,true);
			
			if(count.getConvictionid()==0)
			{
				request.setAttribute("error", "invalid Conviction ID");
				nextView="confirmdelconvc.jsp";
			}
			
			else
			{
				request.setAttribute("successdelconvc", "Successfully Deleted Conviction History Id: "+bean.getConvictionid());
				nextView="convDeleteSuccess.jsp";
			}
		}
		
		
		
		
		
		
		return nextView;
	}

}
