package com.mj.container;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;

// @HandlesTypes({HttpServlet.class})
@HandlesTypes({MyServlet.class})
public class WebContainerInitializer implements ServletContainerInitializer {

	public void onStartup(Set<Class<?>> classes, ServletContext ctx)
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Initializing container app .....") ;
		
		for (Class c : classes) {
			System.out.println("Found ..." + c.getName()) ;
			System.out.println("calling annotation") ;
			MyServlet ann = (MyServlet)c.getAnnotation(MyServlet.class) ;
			System.out.println("path = "+ann.path()) ;
		
			ServletRegistration.Dynamic d = ctx.addServlet("hello", c) ;
			d.addMapping(ann.path()) ;
			
		}

	}

}
