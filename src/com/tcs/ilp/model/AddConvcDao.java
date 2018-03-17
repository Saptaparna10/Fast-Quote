package com.tcs.ilp.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tcs.ilp.util.Connection1;




public class AddConvcDao {
	
	AddConvcBean bean=new AddConvcBean();
	Boolean a;
	int count;

	public AddConvcBean  addconvc(AddConvcBean bean) {
		
		long Convc_id=0;
		
        Connection conn=null;
		
		try {
		      
			 conn= Connection1.getMyConnection();
			 
			 String sql1="select convictionid.nextval from dual";
			 Statement s1=conn.createStatement();
			 ResultSet result=s1.executeQuery(sql1);
			 if(result.next())
			 {
				 Convc_id=Long.parseLong(result.getString(1));
			 }
			bean.setConvictionid(Convc_id);
			String sql2="insert into fq_convictionhistory values(?,?,TO_DATE(?,'yyyy-MM-dd'),?,?)";
			PreparedStatement st=conn.prepareStatement(sql2);
			System.out.println(sql2);
			String sql="select convictionid from fq_convictionhistory where id='"+bean.getUid()+ "'";
			st.setLong(1, Convc_id);
			st.setLong(5, bean.getUid());
			System.out.println(bean.getDoc());
			st.setString(3, bean.getDoc());
			st.setString(4, bean.getNoc());
			st.setString(2, bean.getComments());
			a=st.execute();

			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bean;
		
		
		
	}
	
	
	public ArrayList<AddConvcBean> viewConvc ()
	
	{
		Connection conn=null;
		ArrayList<AddConvcBean> ar=new ArrayList<AddConvcBean>();
		
		try
		{
			 conn= Connection1.getMyConnection();
			 Statement s=conn.createStatement();
				ResultSet rs=s.executeQuery("select * from fq_Convictionhistory");
				while(rs.next())
				{
					bean=new AddConvcBean();
					
					bean.setConvictionid(rs.getLong("CONVICTION_HISTORY_ID"));
					bean.setUid(rs.getLong("USER_ID"));
					bean.setNoc(rs.getString("NATURE_OF_CONVICTION"));
					bean.setDoc(rs.getString("DATE_OF_CONVICTION"));
					
					bean.setComments(rs.getString("COMMENTS"));
					
					
					ar.add(bean);
					System.out.println(ar);
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ar;
		
	}


	public AddConvcBean delconvc(AddConvcBean bean1,boolean confirmDelete) {
		
        Connection conn=null;
        AddConvcBean beann= new AddConvcBean();
		Connection1 acu=new Connection1();
		
		try {
		      
			 conn= acu.getMyConnection();
			 String sql="select * from fq_ConvictionHistory where Conviction_history_id="+bean1.getConvictionid()+"";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			boolean found=false;
			if (rs.next())
			{
				beann.setConvictionid(rs.getLong(1));
				beann.setUid(rs.getLong(5));
				beann.setNoc(rs.getString(4));
				beann.setDoc(rs.getString(3));
				beann.setComments(rs.getString(2));
				found=true;
			}
			
			if(found && confirmDelete){
				String sql1="delete from fq_convictionhistory where conviction_history_id="+bean1.getConvictionid();
				PreparedStatement ps=conn.prepareStatement(sql1);
				int i=ps.executeUpdate();
				System.out.println("Op code "+i);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return beann;
	}


	public Boolean getDetails() {
		 Connection conn=null;
		 Boolean chk=false;
			
			Connection1 acu=new Connection1();
			
			try {
			       
				    Statement s=conn.createStatement();
					ResultSet rs=s.executeQuery("select * from AddConvcHistory where Convictionid="+bean.getConvictionid()+"");
					if(rs.next())
					{
						bean.setUid(rs.getInt(1));
						bean.setDoc(rs.getString(2));
						bean.setNoc(rs.getString(3));
						bean.setComments(rs.getString(4));
						bean.setConvictionid(Integer.parseInt(rs.getString(5)));
						
						chk=true;
					}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return chk;
	}
	
	
	
	
	public AddConvcBean updateConviction(AddConvcBean bean1,boolean confirmUpdate) {
	
	     Connection conn=null;
	        AddConvcBean beann= new AddConvcBean();
			Connection1 acu=new Connection1();
			
			try {
			      
				 conn= acu.getMyConnection();
				 if(!confirmUpdate){
				 String sql="select * from fq_ConvictionHistory where Conviction_history_id="+bean1.getConvictionid()+"";
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery(sql);
				boolean found=false;
				if (rs.next())
				{
					beann.setConvictionid(rs.getLong(1));
					beann.setUid(rs.getLong(5));
					beann.setNoc(rs.getString(4));
					beann.setDoc(rs.getString(3));
					beann.setComments(rs.getString(2));
					found=true;
				}
				 }
				if(confirmUpdate){
					PreparedStatement ps = conn.prepareStatement("update FQ_ConvictionHistory set user_id = ? ,nature_of_conviction = ? ,date_of_conviction =(TO_DATE(?,'YYYY/mm/dd')), comments = ?    where conviction_history_id = "+bean1.getConvictionid()+"");
					//ps.setInt(1, ub.getConviction_id());
						//System.out.println(ub.getComments());
						
						
						ps.setLong(1, bean1.getUid());
						ps.setString(2,bean1.getNoc());	
						
						ps.setString(3, bean1.getDoc());
						ps.setString(4, bean1.getComments());
						
						int ros=ps.executeUpdate();
						beann=bean1;
					System.out.println("Op code "+ros);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return beann;
		}
}
