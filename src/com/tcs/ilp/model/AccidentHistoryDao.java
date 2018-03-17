package com.tcs.ilp.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class AccidentHistoryDao {

	public boolean getUserDetails(FqUser user) {

        
		boolean found=false;
		FqUser bean=null;
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqConvictionhistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		try{
		bean=(FqUser) session.get(FqUser.class, user.getUserId());
		
		if(bean.getUserId() != 0 || bean!=null)
		{
			found=true;
		}
		
		}
		catch(Exception e){
			found=false;
		}
		finally{
			session.close();
			factory.close();
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
		}
		
		
		return found;
	}
	
	
	public boolean getVehicleDetails(FqVehicle vehicle){
		boolean found=false;
		FqVehicle bean=null;
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqAccidenthistory.class);
		config.addAnnotatedClass(FqVehicle.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		try{
		bean=(FqVehicle) session.get(FqVehicle.class, vehicle.getVehicleId());
		if(bean.getVehicleId()!=0 || bean!=null)
		{
			found=true;
		}
		}
		catch(Exception e){
			found=false;
		}
		finally{
			session.close();
			factory.close();
		}
		
		if(found && bean!=null){
			vehicle.setFqAccidenthistories(bean.getFqAccidenthistories());
			vehicle.setMake(bean.getMake());
			vehicle.setModel(bean.getModel());
			vehicle.setOnRoadPrice(bean.getOnRoadPrice());
			vehicle.setTypeIn(bean.getTypeIn());
			vehicle.setUserId(bean.getUserId());
			vehicle.setVehicleId(bean.getVehicleId());
			vehicle.setYearOfManufacture(bean.getYearOfManufacture());
		}
		
		
		return found;
		
	}


	public FqAccidenthistory insert(FqAccidenthistory fqbean) {
		
		int res=0;
		
		long Accid=0;
		try
		{
			
			System.out.println("inside try dao");
			FqAccidenthistory fqh=new FqAccidenthistory();
			AnnotationConfiguration config=new AnnotationConfiguration();
			config.addAnnotatedClass(FqAccidenthistory.class);
			config.addAnnotatedClass(FqUser.class);
			config.addAnnotatedClass(FqVehicle.class);
			config.configure();
			SessionFactory factory=config.buildSessionFactory();
			Session session=factory.openSession();
			session.beginTransaction();
			//new SchemaExport(config).create(true,true);
			
			try{
			Accid=(Long)session.save(fqbean);
			}
			catch(Exception e){
				fqbean.setAccidentHistoryId(0);
			}
			fqbean.setAccidentHistoryId(Accid);
			System.out.println(Accid);
			session.getTransaction().commit();
		
		     res=1;
		}
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
		
	      
	       FqAccidenthistory accresult=this.getAccidentDetails(Accid);
	       System.out.println(accresult.getAccidentHistoryId());
	         return accresult;
		
		
	}

	public ArrayList<FqAccidenthistory> view(FqAccidenthistory fqbean) {


		FqAccidenthistory fqh=new FqAccidenthistory();
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqAccidenthistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		String str="FROM FqAccidenthistory as I where I.accidentHistoryId="+fqbean.getAccidentHistoryId();
		Query query=session.createQuery(str);
		List<FqAccidenthistory> list=query.list();
   
		   

		
		return (ArrayList<FqAccidenthistory>) list;
		
	}

	public int deleteconvc(FqAccidenthistory fqbean) {
       
		FqAccidenthistory fqh=new FqAccidenthistory();
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqAccidenthistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		System.out.println(fqbean.getAccidentHistoryId());
		String str="FROM FqAccidenthistory as I where I.accidentHistoryId="+fqbean.getAccidentHistoryId();
		Query query=session.createQuery(str);
		List<FqAccidenthistory> list=query.list();
   
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
		
		
			for(FqAccidenthistory hib : list)
			{
				System.out.println("iam in found");
				System.out.println(hib.getAccidentHistoryId());
				System.out.println(hib.getNatureOfAccident());
				System.out.println(hib.getDateOfAccident());
				System.out.println(hib.getFqUser().getUserId());
				System.out.println(hib.getComments());
			}
			found=true;
		
		}
		
		
		
		if(found )
		{
			System.out.println(fqbean.getAccidentHistoryId());
			String delhql="delete FqAccidenthistory where accidentHistoryId ="+fqbean.getAccidentHistoryId();
			Query query1=session.createQuery(delhql);
		    resu=query1.executeUpdate();
			System.out.println("opcode"+resu);
			
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		return resu;
	
	
	}
	
	

	
public FqAccidenthistory getAccidentDetails(long accidentHistoryId) {
	
	System.out.println("hah"+accidentHistoryId);
        
	FqAccidenthistory Beancon=new FqAccidenthistory();
		
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqAccidenthistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.addAnnotatedClass(FqVehicle.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("FROM FqAccidenthistory as I where I.accidentHistoryId="+accidentHistoryId );
		List<FqAccidenthistory> list=query.list();
		System.out.println("list size"+list.size());
		for(FqAccidenthistory fq: list)
		{
			System.out.println("iam in dao fq"+fq.getAccidentHistoryId());
			Beancon.setAccidentHistoryId(fq.getAccidentHistoryId());
			Beancon.setComments(fq.getComments());
			Beancon.setNatureOfAccident(fq.getNatureOfAccident());
			Beancon.setDateOfAccident(fq.getDateOfAccident());
			FqUser user=new FqUser();
			user.setUserId(fq.getFqUser().getUserId());
			Beancon.setFqUser(user);
			if(fq.getFqVehicle()!=null)
				Beancon.setFqVehicle(fq.getFqVehicle());
		}
		
		System.out.println("beancon"+Beancon.getAccidentHistoryId());
		
		return Beancon;
	}
	public int update(FqAccidenthistory foundbean) {
		
		int result=0;
		
		try
		{
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqAccidenthistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.addAnnotatedClass(FqVehicle.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		System.out.println( "convchid:"+foundbean.getAccidentHistoryId());
		
		System.out.println("conda:"+foundbean.getDateOfAccident());
		System.out.println("connature:"+foundbean.getNatureOfAccident());
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


	public ArrayList<FqAccidenthistory> getAcctab() {
		
		
		ArrayList<FqAccidenthistory> ar=new ArrayList<FqAccidenthistory>();
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqAccidenthistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.addAnnotatedClass(FqVehicle.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		String hql="from FqAccidenthistory";
	    Query query=session.createQuery(hql);
		List<FqAccidenthistory> users=query.list();
		for(FqAccidenthistory acc : users)
		{
			
			FqAccidenthistory bean=new FqAccidenthistory();
		  
			bean.setAccidentHistoryId(acc.getAccidentHistoryId());
		    bean.setFqUser(acc.getFqUser());
		    bean.setFqVehicle(acc.getFqVehicle());
		    bean.setDateOfAccident(acc.getDateOfAccident());
		    bean.setNatureOfAccident(acc.getNatureOfAccident());
		    bean.setComments(acc.getComments());
		    
		    ar.add(bean);
			
		}
		
		
		return ar;
	}
	
	

}
