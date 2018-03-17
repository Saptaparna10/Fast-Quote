package com.tcs.ilp.handler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import com.tcs.ilp.model.AddAcddBean;
import com.tcs.ilp.model.AddAcddDao;
import com.tcs.ilp.model.AddConvcBean;
import com.tcs.ilp.model.AddConvcDao;

public class UpdateConvcRequestHandler {
	
	
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
		String check=request.getParameter("CONV_UPDATE");
		String nextView=null;
		AddConvcBean bean=new AddConvcBean();
		AddConvcDao adoa=new AddConvcDao();
		AddConvcBean count;
		System.out.println("hidden "+check);
		if(check.equals("check")){
					System.out.println("inside check");
			long convcid=Long.parseLong(request.getParameter("CONVICTION_ID"));
				
				
				bean.setConvictionid(convcid);
				
				
				count=adoa.updateConviction(bean, false);
				if(count.getConvictionid()==0)
				{
					request.setAttribute("error", "invalid Conviction ID");
					nextView="convUpdate.jsp";
				}
				
				else
				{
					System.out.println("inside check else");
					request.setAttribute("updateconvcbean", count);
					nextView="convictionHistoryUpdate.jsp";
				}
		}
		else if(check.equals("update")){
			System.out.println("inside update");
			System.out.println(request.getParameter("CONVICID"));
			long convic_id=Long.parseLong(request.getParameter("CONVICID"));
			long uid = Long.parseLong(request.getParameter("USERID"));
			String natureOfConviction = request.getParameter("NOC");
			String  dateOfConviction = request.getParameter("DOC");
			String comments = request.getParameter("COMMENTS");
			bean.setConvictionid(convic_id);
			bean.setComments(comments);
			bean.setDoc(dateOfConviction);
			bean.setNoc(natureOfConviction);
			bean.setUid(uid);
			
			count=adoa.updateConviction(bean, true);
			
			if(count.getConvictionid()==0)
			{
				System.out.println("inside update if");
				request.setAttribute("error", "Invalid Conviction ID");
				nextView="confirmupdateconvc.jsp";
			}
			
			else
			{
				System.out.println("inside update else");
				request.setAttribute("successupdateconvc", "Successfully Updated Conviction History Id: "+bean.getConvictionid());
				nextView="convUpdateSuccess.jsp";
			}
		}
		
		
		
		
		
		
		return nextView;
	}

}
