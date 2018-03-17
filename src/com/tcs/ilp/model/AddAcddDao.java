package com.tcs.ilp.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tcs.ilp.util.Connection1;

public class AddAcddDao {
	
	AddAcddBean bean = new AddAcddBean();
	Boolean a;
	int count;

	public AddAcddBean addAcdd(AddAcddBean bean) {
Connection conn=null;
		
		try {
			long Acc_id = 0;
			 conn= Connection1.getMyConnection();
			String sql="insert into fq_accidenthistory values(?,?,?,(TO_DATE(?,'yyyy/mm/dd')),?,?) ";
			PreparedStatement st=conn.prepareStatement(sql);
			//System.out.println("insert into AddAccdHistory values(?,(TO_DATE(?,'mm/dd/yyyy')),?,?) ");
//			String sql="select accid from AddAccdHistory where id='"+bean.getUser_id()+ "'";
//			System.out.println(sql);
//			
//			
			
			
			 String sql1="select accidentid.nextval from dual";
			 Statement s1=conn.createStatement();
			 ResultSet result=s1.executeQuery(sql1);
			 if(result.next())
			 {
				 Acc_id = Long.parseLong(result.getString(1));
			 }
			bean.setAcc_id(Acc_id);
			//String sql2="insert into fq_convictionhistory values(?,?,?,(TO_DATE(?,'yyyy/mm/dd')),?) ";
			//PreparedStatement st=conn.prepareStatement(sql2);
		//	System.out.println(sql2);
			//String sql="select convictionid from fq_convictionhistory where id='"+bean.getUid()+ "'";
	
			st.setLong(1, Acc_id);
			st.setLong(5, bean.getUser_id());
			st.setLong(6, bean.getVeh_id());
			st.setString(3, bean.getDoa());
			st.setString(4, bean.getNac());
			st.setString(2, bean.getComments());
			st.execute();

			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bean;
		
	}
	
public ArrayList<AddAcddBean> viewAccd ()
	
	{
		Connection conn=null;
		ArrayList<AddAcddBean> ar=new ArrayList<AddAcddBean>();
		
		try
		{
			 conn= Connection1.getMyConnection();
				
			 Statement s=conn.createStatement();
				ResultSet rs=s.executeQuery("select * from fq_accidenthistory");
				while(rs.next())
				{
					bean=new AddAcddBean();
					
					bean.setUser_id(rs.getInt(2));
					bean.setDoa(rs.getString(4));
					bean.setNac(rs.getString(5));
					bean.setComments(rs.getString(6));
					bean.setAcc_id(rs.getLong(1));
					
					ar.add(bean);
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ar;
		
	}
public AddAcddBean delAccd(AddAcddBean bean1, boolean confirmDelete) {
    Connection conn=null;
    AddAcddBean beann= new AddAcddBean();
	Connection1 acu=new Connection1();
	
	try {
	      
		 conn= Connection1.getMyConnection();
		 String sql="select * from fq_accidentHistory where accident_history_id="+bean1.getAcc_id()+"";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		boolean found=false;
		if (rs.next())
		{
			beann.setAcc_id(rs.getLong(1));
			beann.setUser_id(rs.getLong(2));
			beann.setVeh_id(rs.getLong(3));
			beann.setDoa(rs.getString(4));
			beann.setNac(rs.getString(5));
			beann.setComments(rs.getString(6));
			found=true;
		}
		
		if(found && confirmDelete){
			String sql1="delete from fq_accidenthistory where accident_history_id="+bean1.getAcc_id();
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

public AddAcddBean updateAccident(AddAcddBean bean2, boolean confirmUpdate) {

	
    Connection conn=null;
       AddAcddBean beann= new AddAcddBean();
		Connection1 acu=new Connection1();
		
		try {
		      
			 conn= acu.getMyConnection();
			 if(!confirmUpdate){
			 String sql="select * from fq_Accidenthistory where Accident_history_id="+bean2.getAcc_id()+"";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			boolean found=false;
			if (rs.next())
			{
				beann.setAcc_id((rs.getLong(1)));
				beann.setUser_id((rs.getLong(2)));
				beann.setVeh_id((rs.getLong(3)));
				beann.setDoa((rs.getString(4)));
				beann.setNac(rs.getString(5));
				beann.setComments(rs.getString(6));
				found=true;
			}
			 }
			if(confirmUpdate){
				PreparedStatement ps = conn.prepareStatement("update FQ_AccidentHistory set user_id = ?, vehicle_id=? ,nature_of_accident = ? ,date_of_accident =(TO_DATE(?,'YYYY/mm/dd')), comments = ?    where accident_history_id = "+bean2.getAcc_id()+"");
				//ps.setInt(1, ub.getConviction_id());
					//System.out.println(ub.getComments());
					
					
					ps.setLong(1, bean2.getUser_id());
					ps.setLong(2, bean2.getVeh_id());
					ps.setString(3,bean2.getNac());	
					ps.setString(4, bean2.getDoa());
					ps.setString(5, bean2.getComments());
					
					int ros=ps.executeUpdate();
					beann=bean2;
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
