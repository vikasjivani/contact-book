package com.axelor.guice;

import com.axelor.service.ContectDao;
import com.axelor.service.ContectService;
import com.axelor.serviceimp.ContectDaoImp;
import com.axelor.serviceimp.ContectServiceImp;
import com.axelor.servlet.AddContect;
import com.axelor.servlet.DeleteContect;
import com.axelor.servlet.Extra;
import com.axelor.servlet.Login;
import com.axelor.servlet.Update;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class GuiceServletConfigure extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new ServletModule() {
			
			@Override
			protected void configureServlets() {
				serve("/login").with(Login.class);
				serve("/addContect").with(AddContect.class);
				serve("/DeleteContect").with(DeleteContect.class);
				serve("/extra").with(Extra.class);
				serve("/update").with(Update.class);
				
				bind(ContectDao.class).to(ContectDaoImp.class);
				bind(ContectService.class).to(ContectServiceImp.class);
				
			}
			
		});
	}
								

}
