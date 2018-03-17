package com.tcs.ilp.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.tcs.ilp.util.HibUtil;

public class LoginDao {

	SessionFactory factory;
	Session session;
	public int checkUser(FqLogin bean) {
		String hql="from FqLogin where userName=:username and password=:password";
		
		int resultCode=0;
		List<FqLogin> list = null;
		try{
		factory=HibUtil.getFactory();
		session=factory.openSession();
		Query query=session.createQuery(hql);
		query.setString("username", bean.getUserName());
		query.setString("password", bean.getPassword());
		
		list=query.list();
		}
		catch(Exception e){
			e.printStackTrace();
			resultCode=-2;
		}
		try{
			if(list.size()<1)
			resultCode=0;
		else{
			for(FqLogin b:list){
				bean.setStatus(b.getStatus());
			}
			resultCode=1;
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			resultCode=-1;
		}
		return resultCode;

}
}
