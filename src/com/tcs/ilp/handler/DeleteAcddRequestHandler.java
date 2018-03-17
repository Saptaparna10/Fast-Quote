package com.tcs.ilp.handler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddAcddBean;
import com.tcs.ilp.model.AddAcddDao;
import com.tcs.ilp.model.AddConvcBean;
import com.tcs.ilp.model.AddConvcDao;

public class DeleteAcddRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub


		String nextView=null;
		String check=request.getParameter("ACCDELCHECK");
		AddAcddBean bean=new AddAcddBean();
		AddAcddDao adoa=new AddAcddDao();
		AddAcddBean count;
		if(check.equals("check")){
					
				String id=request.getParameter("accident_id");
				
				bean.setAcc_id(Long.parseLong(id));
				
				
				count=adoa.delAccd(bean,false);
				if(count.getAcc_id()==0)
				{
					request.setAttribute("error", "Invalid Accident History ID");
					nextView="sampledeleteacc.jsp";
				}
				
				else
				{
					request.setAttribute("delaccbean", count);
					nextView="confirmdelacc.jsp";
				}
		}
		else if(check.equals("delete")){
			long acc_id=Long.parseLong(request.getParameter("ACCID"));
			bean.setAcc_id(acc_id);
			count=adoa.delAccd(bean,true);
			
			if(count.getAcc_id()==0)
			{
				request.setAttribute("error", "Invalid Accident History ID");
				nextView="confirmdelacc.jsp";
			}
			
			else
			{
				request.setAttribute("successdelacc", "Successfully Deleted Accident History Id: "+bean.getAcc_id());
				nextView="accDeleteSuccess.jsp";
			}
		}
		
		
		
		
		
		
		return nextView;

	
	}

}
