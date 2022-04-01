package servicepublisherr;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceRegistration;

import FoodService.FoodService;

public class ServiceeActivator implements BundleActivator {
	ServiceRegistration publishServiceFood;

	public void start(BundleContext context) {
		FoodService FoodService = new foodServiceImpl();
		publishServiceFood = context.registerService(FoodService.class.getName(), FoodService, null);
		System.out.println(" Food reservation service publisher registered and started successfully");
	}

	public void stop(BundleContext context) {
		System.out.println(" Food reservation service publisher stopped");
		publishServiceFood.unregister();

	}
}
