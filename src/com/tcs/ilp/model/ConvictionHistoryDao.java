package com.tcs.ilp.model;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;








public class ConvictionHistoryDao {
	public int getUserDetails(FqUser user){
		boolean found=false;
		int resultCode;
		FqUser bean=null;
		try
		{
		
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqConvictionhistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		try{
		bean=(FqUser) session.get(FqUser.class, user.getUserId());
		found=true;
		resultCode=1;
		
		}
		catch(Exception e){
			found=false;
			resultCode=0;
		}
		finally{
			session.close();
			factory.close();
		}
		}
		catch(Exception e)
		{
			resultCode =-2;
		}
		
		
		
		if(found && bean!=null){
			user.setAgeWhenFirstLicensed(bean.getAgeWhenFirstLicensed());
			user.setAnnualIncome(bean.getAnnualIncome());
			user.setCurrentUsLicenseStatus(bean.getCurrentUsLicenseStatus());
			user.setDateOfBirth(bean.getDateOfBirth());
			user.setGender(bean.getGender());
			user.setHighestLevelOfEducation(bean.getHighestLevelOfEducation());
			user.setMailingAddress(bean.getMailingAddress());
			user.setName(bean.getName());
			user.setOccupation(bean.getOccupation());
			user.setSsn(bean.getSsn());
			resultCode=1;
		}
		
		else if(found && bean==null)
		{
			resultCode=0;
		}
		
		return resultCode;
		
	}
	public FqConvictionhistory insert(FqConvictionhistory fq)
	{
		int res=0;
		long convid = 0;
		try
		{
			
			System.out.println("inside try dao");
			FqConvictionhistory fqh=new FqConvictionhistory();
			AnnotationConfiguration config=new AnnotationConfiguration();
			config.addAnnotatedClass(FqConvictionhistory.class);
			config.addAnnotatedClass(FqUser.class);
			config.configure();
			SessionFactory factory=config.buildSessionFactory();
			Session session=factory.openSession();
			session.beginTransaction();
			//new SchemaExport(config).create(true,true);
			
			convid=(Long)session.save(fq);
			System.out.println(convid);
			session.getTransaction().commit();
		
		     res=1;
		}
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
		
	        
	         
	         FqConvictionhistory fbean=this.getConvictionDetails(convid);
	         
	         return fbean;
	}
	public int view(FqConvictionhistory conBean)
	{
		
		Query query = null;
		int resultCode;
		
		try
		{
			
		
		FqConvictionhistory fqh=new FqConvictionhistory();
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqConvictionhistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		String str="FROM FqConvictionhistory as I where I.convictionHistoryId="+conBean.getConvictionHistoryId();
		query=session.createQuery(str);
		}
		catch (Exception e)
		{
			resultCode=-2;
		}
		
		
		List<FqConvictionhistory> list=query.list();
		
		if(list.size()==0)
		{
			resultCode=0;
		}
		else
	{   
			 
			conBean.setList((ArrayList<FqConvictionhistory>)list);
			resultCode=1;
	}
   
		   

		
		return resultCode;	
		
	}

	public int deleteconvc(FqConvictionhistory conBean) {
		

		
		FqConvictionhistory fqh=new FqConvictionhistory();
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqConvictionhistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		System.out.println(conBean.getConvictionHistoryId());
		String str="FROM FqConvictionhistory as I where I.convictionHistoryId="+conBean.getConvictionHistoryId();
		Query query=session.createQuery(str);
		List<FqConvictionhistory> list=query.list();
   
		int resu=0;
		boolean found=false;
		System.out.println(list.size());
		
		if(list.size()==0)
		{
			System.out.println("pls dont come here");
			resu=2;
		}
		else
		{
		
		
			for(FqConvictionhistory hib : list)
			{
				System.out.println("iam in found");
				System.out.println(hib.getConvictionHistoryId());
				System.out.println(hib.getNatureOfConviction());
				System.out.println(hib.getDateOfConviction());
				System.out.println(hib.getFqUser().getUserId());
				System.out.println(hib.getComments());
			}
			found=true;
		
		}
		
		
		
		if(found )
		{
			System.out.println(conBean.getConvictionHistoryId());
			String delhql="delete FqConvictionhistory where convictionHistoryId ="+conBean.getConvictionHistoryId();
			Query query1=session.createQuery(delhql);
		    resu=query1.executeUpdate();
			System.out.println("opcode"+resu);
			
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		return resu;
	
	}
	
	
public FqConvictionhistory getConvictionDetails(long convictionHistoryId) {
        
		FqConvictionhistory Beancon=new FqConvictionhistory();
		
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqConvictionhistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("FROM FqConvictionhistory as I where I.convictionHistoryId="+convictionHistoryId );
		List<FqConvictionhistory> list=query.list();
		for(FqConvictionhistory fq: list)
		{
			
			Beancon.setConvictionHistoryId(fq.getConvictionHistoryId());
			Beancon.setDateOfConviction(fq.getDateOfConviction());
			Beancon.setNatureOfConviction(fq.getNatureOfConviction());
			Beancon.setComments(fq.getComments());
			FqUser user=new FqUser();
			user.setUserId(fq.getFqUser().getUserId());
			Beancon.setFqUser(user);
			
			
		}
		
	System.out.println("convc dai convcid"+Beancon.getConvictionHistoryId());	
		
		return Beancon;
	}
	public int update(FqConvictionhistory foundbean) {
		
		int result=0;
		
		try
		{
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqConvictionhistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		System.out.println( "convchid:"+foundbean.getConvictionHistoryId());
		
		System.out.println("conda:"+foundbean.getDateOfConviction());
		System.out.println("connature:"+foundbean.getNatureOfConviction());
		System.out.println("commente :"+foundbean.getComments());
		session.update(foundbean);
	     session.getTransaction().commit();
	     session.close();
	     result=1;
	     
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		


		
		return result;
	}


}