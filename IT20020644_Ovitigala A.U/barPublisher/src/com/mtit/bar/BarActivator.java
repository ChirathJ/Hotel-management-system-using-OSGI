package com.mtit.bar;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.mtit.bar.service.BarPublish;

public class BarActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration; 

	public void start(BundleContext context) throws Exception {
		
		System.out.println("barPublisher Start");

		BarPublish barPublisherService = new BarPublishImpl(); 
		
		publishServiceRegistration = context.registerService(BarPublish.class.getName(), barPublisherService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		publishServiceRegistration.unregister();
		System.out.println("barPublisher Stop");
		
	}

}
