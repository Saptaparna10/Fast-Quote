package com.tcs.ilp.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.model.AddAcddBean;
import com.tcs.ilp.model.AddAcddDao;
import com.tcs.ilp.model.AddConvcBean;
import com.tcs.ilp.model.AddConvcDao;

public class UpdateAccRequestHandler {
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		
		String check=request.getParameter("Acc_UPDATE");
		String nextView=null;
		AddAcddBean bean=new AddAcddBean();
		AddAcddDao adoa=new AddAcddDao();
		AddAcddBean count;
		System.out.println("hidden "+check);
		if(check.equals("check")){
					System.out.println("inside check");
			long Accid=Long.parseLong(request.getParameter("Accident_ID"));
				
				
				bean.setAcc_id(Accid);
				
				
				count=adoa.updateAccident(bean, false);
				if(count.getAcc_id()==0)
				{
					request.setAttribute("error", "invalid Accident ID");
					nextView="AccdUpdate.jsp";
				}
				
				else
				{
					System.out.println("inside check else");
					request.setAttribute("updateAccbean", count);
					nextView="AccidentHistoryUpdate.jsp";
				}
		}
		else if(check.equals("update")){
			System.out.println("inside update");
			System.out.println(request.getParameter("ACCDID"));
			long acc_id=Long.parseLong(request.getParameter("ACCDID"));
			long uid = Long.parseLong(request.getParameter("USERID"));
			long vechid = Long.parseLong(request.getParameter("VEHICLEID"));
			String natureOfAccident = request.getParameter("NOA");
			String  dateOfAccident = request.getParameter("DOA");
			String comments = request.getParameter("COMMENTS");
			bean.setAcc_id(acc_id);
			bean.setUser_id(uid);
			bean.setVeh_id(vechid);
			bean.setNac(natureOfAccident);
			bean.setDoa(dateOfAccident);
			bean.setComments(comments);
			
			count=adoa.updateAccident(bean, true);
			
			if(count.getAcc_id()==0)
			{
				System.out.println("inside update if");
				request.setAttribute("error", "Invalid Accident ID");
				nextView="confirmupdateAcdd.jsp";
			}
			
			else
			{
				System.out.println("inside update else");
				request.setAttribute("successupdateAcdd", "Successfully Updated Accident History Id: "+bean.getAcc_id());
				nextView="AcddUpdateSuccess.jsp";
			}
		}
		
		
		
		
		
		
		return nextView;
	}

}
