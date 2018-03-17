package com.tcs.ilp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.tcs.ilp.util.Connection1;


public class AddQuoteDao {
	ClaimBean bean;
	ArrayList<ClaimBean> ar=new ArrayList<ClaimBean>();
	ArrayList<QuoteBean> ar1=new ArrayList<QuoteBean>();
	private Connection con;
	DecimalFormat newFormat = new DecimalFormat("#.##");
	
	public ArrayList<ClaimBean> getClaim(String status){
		String sql="select fq_proposaldesc.proposal_id,insurance_id,amount_claimed from FQ_PROPOSALDESC, FQ_VehicleDamageProposal where  status='"+status+"' and FQ_VEHICLEDAMAGEPROPOSAL.PROPOSAL_ID=FQ_PROPOSALDESC.PROPOSAL_ID union select fq_proposaldesc.proposal_id,insurance_id,amount_claimed from FQ_PROPOSALDESC, FQ_BODYINJURYPROPOSAL where status='"+status+"' and FQ_BODYINJURYPROPOSAL.PROPOSAL_ID=FQ_PROPOSALDESC.PROPOSAL_ID union select fq_proposaldesc.proposal_id,insurance_id,amount_claimed from FQ_PROPOSALDESC, FQ_LIABILITYPROPOSAL where status='"+status+"' and FQ_LIABILITYPROPOSAL.PROPOSAL_ID=FQ_PROPOSALDESC.PROPOSAL_ID";
        Connection conn=null;
		Statement stmt;
		try {
			 conn= Connection1.getMyConnection();

			stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()){
			bean=new ClaimBean();
			bean.setProposalId(rs.getLong(1));
			bean.setInsuranceId(rs.getLong(2));
			bean.setClaimAmt(rs.getDouble(3));
			
			ar.add(bean);
		}
		
		conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}

	
	public ArrayList<QuoteBean> getQuote(){
		String sql="select * from fq_quote where status='APPROVED'";
		//ArrayList<ClaimBean> cb=getClaim("APPROVED");
		QuoteBean bean=null;
        Connection conn=null;
		Statement stmt;
		try {
			 conn= Connection1.getMyConnection();

			stmt = conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(sql);
		double claim=0;

		while(rs.next()){
			bean=new QuoteBean();
			bean.setQuote_id(rs.getLong("QUOTE_ID"));
			bean.setUser_id(rs.getLong("USER_ID"));
			bean.setProposal_id(rs.getLong("PROPOSAL_ID"));
			bean.setQuote(Double.valueOf(newFormat.format(rs.getDouble("QUOTE"))));
			bean.setAccident_history_id(rs.getLong("ACCIDENT_HISTORY_ID"));
			bean.setConviction_history_id(rs.getLong("CONVICTION_HISTORY_ID"));
			bean.setStatus(rs.getString("STATUS"));
			bean.setDeduction(Double.valueOf(newFormat.format(rs.getDouble("DEDUCTION"))));
			claim=Double.valueOf(newFormat.format(bean.getQuote()+bean.getDeduction()));
			bean.setClaim(claim);
			ar1.add(bean);
		}
		
		conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar1;
	}

	
	
	
	
	public String getNOA(QuoteBean qb){
		String noa="NONE";
		con = null;
		
		//System.out.println("trying accid: "+qb.getAccident_history_id());
		String sql="select accident_history_id,nature_of_accident from FQ_ACCIDENTHISTORY where user_id="+qb.getUser_id()+" and rownum<=1 order by accident_history_id desc";
		//String sql="select nature_of_accident from FQ_ACCIDENTHISTORY where accident_history_id="+qb.getAccident_history_id();
		try {con=Connection1.getMyConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				qb.setAccident_history_id(rs.getLong("ACCIDENT_HISTORY_ID"));
				noa= rs.getString("NATURE_OF_ACCIDENT");
			}
			System.out.println("got noa:: "+noa);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return noa;
	}
	public String getNOC(QuoteBean qb){
		String noc="NONE";
		String sql="select conviction_history_id,nature_of_conviction from FQ_CONVICTIONHISTORY where user_id="+qb.getUser_id()+" and rownum<=1 order by conviction_history_id desc";
		try {
			con=Connection1.getMyConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				qb.setConviction_history_id(rs.getLong(1));
				noc=rs.getString(2);
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return noc;
	}
	
	
	public void getquotedetails(ArrayList<QuoteBean> ar2,String status) {
		
	Iterator it=ar2.iterator();
	Connection con=null;
	try {
		con=Connection1.getMyConnection();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	while(it.hasNext())
	{
			QuoteBean qb=(QuoteBean)it.next();
			long proposal_id=qb.getProposal_id();
			//String sql="select * from FQ_QUOTE,FQ_ACCIDENTHISTORY,FQ_CONVICTIONHISTORY where FQ_QUOTE.ACCIDENT_HISTORY_ID=FQ_ACCIDENTHISTORY.ACCIDENT_HISTORY_ID and FQ_QUOTE.CONVICTION_HISTORY_ID=FQ_CONVICTIONHISTORY.CONVICTION_HISTORY_ID and proposal_id="+proposal_id;
			String sql1="select user_id from fq_proposaldesc where status='"+status+"' and proposal_id="+proposal_id;
			String sql2="select proposal_id,amount_claimed from (select proposal_id,amount_claimed from FQ_BODYINJURYPROPOSAL union select proposal_id,amount_claimed from FQ_LIABILITYPROPOSAL union select proposal_id,AMOUNT_CLAIMED from FQ_VEHICLEDAMAGEPROPOSAL) where proposal_id=?";
			//String sql1="select proposal_id, claim from fq_proposaldesc where status='PENDING'";
			//String sql="select * from fq_quote where proposal_id="+proposal_id;
			//String noc,noa;
			try{
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(rs.next()){
					qb.setUser_id(rs.getLong("USER_ID"));
				}
					qb.setStatus("APPROVED");
				PreparedStatement ps1=con.prepareStatement(sql2);
				ps1.setLong(1, proposal_id);
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					qb.setProposal_id(rs1.getLong("PROPOSAL_ID"));
					qb.setClaim(Double.valueOf(newFormat.format(rs1.getDouble("AMOUNT_CLAIMED"))));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println("getquotedetails:::: "+qb.getProposal_id()+"\t"+qb.getClaim());
		}
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		

	}


	/*public void updateQuote(ArrayList<QuoteBean> ar) throws SQLException, Exception {
		// TODO Auto-generated method stub
		String sql="update fq_quote set quote=?, status='APPROVED', deduction=? where proposal_id=?";
		Iterator it=ar.iterator();
		Connection con=Connection1.getMyConnection();
		con.setAutoCommit(false);
		Statement stmt=con.createStatement();
	//	PreparedStatement ps=Connection1.getMyConnection().prepareStatement(sql);
		while(it.hasNext()){
			QuoteBean qb=(QuoteBean) it.next();
			stmt.addBatch("update fq_quote set quote="+qb.getQuote()+", status='APPROVED', deduction="+qb.getDeduction()+" where proposal_id="+qb.getProposal_id());
			stmt.addBatch("update fq_proposaldesc set status='APPROVED' where proposal_id="+qb.getProposal_id());
			System.out.println("Quote: "+qb.getQuote()+"\tDeduction: "+qb.getDeduction()+"\tproposalid: "+qb.getProposal_id());
			qb.setStatus("APPROVED");
	}
		int res[]=stmt.executeBatch();
		con.commit();
		con.close();
		for(int i:res){
		System.out.println("Update status "+i);
		}
	}*/
	
	
	
	
	
	public void insertQuote(ArrayList<QuoteBean> ar) throws SQLException, Exception {
		// TODO Auto-generated method stub
		//String sql="insert into fq_quote values(?,?,?,?,?,?,?)";
		//String sql="update fq_quote set quote=?, status='APPROVED', deduction=? where proposal_id=?";
		Iterator it=ar.iterator();
		Connection con=Connection1.getMyConnection();
		con.setAutoCommit(false);
		
		Statement stmt=con.createStatement();
	//	PreparedStatement ps=Connection1.getMyConnection().prepareStatement(sql);
		while(it.hasNext()){
			QuoteBean qb=(QuoteBean) it.next();
			//PreparedStatement ps=con.prepareStatement(sql);
			String sql="insert into fq_quote values(quoteid.nextval,"+qb.getUser_id()+","+
					qb.getProposal_id()+","+qb.getQuote()+","+qb.getAccident_history_id()
					+","+qb.getConviction_history_id()
					+",'APPROVED',"+
					qb.getDeduction()+")";
			if(qb.getAccident_history_id()==0){
				if(qb.getConviction_history_id()==0)
				sql="insert into fq_quote values(quoteid.nextval,"+qb.getUser_id()+","+
						qb.getProposal_id()+","+qb.getQuote()+",''"
						+",''"
						+",'APPROVED',"+
						qb.getDeduction()+")";
				else
					sql="insert into fq_quote values(quoteid.nextval,"+qb.getUser_id()+","+
							qb.getProposal_id()+","+qb.getQuote()+",''"
							+","+qb.getConviction_history_id()
							+",'APPROVED',"+
							qb.getDeduction()+")";
			}
			else
				{
				if(qb.getConviction_history_id()==0)
					sql="insert into fq_quote values(quoteid.nextval,"+qb.getUser_id()+","+
							qb.getProposal_id()+","+qb.getQuote()+","+qb.getAccident_history_id()
							+",''"
							+",'APPROVED',"+
							qb.getDeduction()+")";
				else
					sql="insert into fq_quote values(quoteid.nextval,"+qb.getUser_id()+","+
							qb.getProposal_id()+","+qb.getQuote()+","+qb.getAccident_history_id()
							+","+qb.getConviction_history_id()
							+",'APPROVED',"+
							qb.getDeduction()+")";
				}
		
			System.out.println(sql);
			stmt.addBatch(sql);
			//stmt.addBatch("update fq_quote set quote="+qb.getQuote()+", status='APPROVED', deduction="+qb.getDeduction()+" where proposal_id="+qb.getProposal_id());
			System.out.println("update fq_proposaldesc set status='APPROVED' where proposal_id="+qb.getProposal_id());
			stmt.addBatch("update fq_proposaldesc set status='APPROVED' where proposal_id="+qb.getProposal_id());
			qb.setStatus("APPROVED");
			System.out.println("Quote: "+qb.getQuote()+"\tDeduction: "+qb.getDeduction()+"\tproposalid: "+qb.getProposal_id());
			//qb.setStatus("APPROVED");
			
	}
		int res[]=stmt.executeBatch();
		con.commit();
		con.close();
		for(int i:res){
		System.out.println("Update status "+i);
		}
	}
	
	
	public void updateQuote(ArrayList<QuoteBean> ar) throws SQLException, Exception {
		// TODO Auto-generated method stub
		//String sql="insert into fq_quote values(?,?,?,?,?,?,?)";
		//String sql="update fq_quote set quote=?, status='APPROVED', deduction=? where proposal_id=?";
		Iterator it=ar.iterator();
		Connection con=Connection1.getMyConnection();
		con.setAutoCommit(false);
		
		Statement stmt=con.createStatement();
	//	PreparedStatement ps=Connection1.getMyConnection().prepareStatement(sql);
		while(it.hasNext()){
			QuoteBean qb=(QuoteBean) it.next();
			//PreparedStatement ps=con.prepareStatement(sql);
		String sql="update fq_quote set quote="+qb.getQuote()
				+", accident_history_id="+qb.getAccident_history_id()
				+", conviction_history_id="+qb.getConviction_history_id()
				+", status='APPROVED' "
				+", deduction="+qb.getDeduction()
				+" where proposal_id="+qb.getProposal_id();
		
			System.out.println(sql);
			qb.setStatus("APPROVED");
			stmt.addBatch(sql);
			
	}
		int res[]=stmt.executeBatch();
		con.commit();
		con.close();
		for(int i:res){
		System.out.println("Update status "+i);
		}
	}
	


	public boolean deleteTheseQuotes(ArrayList<QuoteBean> arr) throws Exception {
		
	
		Iterator it=arr.iterator();
		Connection con=Connection1.getMyConnection();
		con.setAutoCommit(false);
		boolean done=false;
		Statement stmt=con.createStatement();
	//	PreparedStatement ps=Connection1.getMyConnection().prepareStatement(sql);
		while(it.hasNext()){
			QuoteBean qb=(QuoteBean) it.next();
			//PreparedStatement ps=con.prepareStatement(sql);
			String sql="delete from fq_quote where proposal_id="+qb.getProposal_id();
			String sql1="update fq_proposaldesc set status='REJECTED' where proposal_id="+qb.getProposal_id();
			System.out.println(sql+"\n"+sql1);
			stmt.addBatch(sql);
			stmt.addBatch(sql1);
			//stmt.addBatch("update fq_quote set quote="+qb.getQuote()+", status='APPROVED', deduction="+qb.getDeduction()+" where proposal_id="+qb.getProposal_id());
			System.out.println("update fq_proposaldesc set status='APPROVED' where proposal_id="+qb.getProposal_id());
			stmt.addBatch("update fq_proposaldesc set status='APPROVED' where proposal_id="+qb.getProposal_id());
			qb.setStatus("REJECTED");
			System.out.println("Quote: "+qb.getQuote()+"\tDeduction: "+qb.getDeduction()+"\tproposalid: "+qb.getProposal_id());
			//qb.setStatus("APPROVED");
			
	}
		int res[]=stmt.executeBatch();
		con.commit();
		done=true;
		con.close();
		for(int i:res){
		System.out.println("Update status "+i);
		}
		
		return done;
		
	}
}
