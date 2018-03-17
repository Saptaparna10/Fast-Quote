package com.tcs.ilp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.tcs.ilp.model.FqAccidenthistory;
import com.tcs.ilp.model.FqConvictionhistory;
import com.tcs.ilp.model.FqLogin;
import com.tcs.ilp.model.FqUser;
import com.tcs.ilp.model.FqVehicle;



public class HibUtil {

	
	public static SessionFactory getFactory(){
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(FqConvictionhistory.class);
		config.addAnnotatedClass(FqAccidenthistory.class);
		config.addAnnotatedClass(FqUser.class);
		config.addAnnotatedClass(FqVehicle.class);
		config.addAnnotatedClass(FqLogin.class);
		config.configure();
		SessionFactory factory=config.buildSessionFactory();
		return factory;
	}
	
}
