package loginproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import loginProducerService.loginServices;

public class loginActivator implements BundleActivator {
	
	ServiceRegistration<?> publishLoginService;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Login Producer");
		
		loginServices employeeService = new loginServiceImpl();
		publishLoginService = context.registerService(loginServices.class.getName(), employeeService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		publishLoginService.unregister();
		System.out.println("Stop Login Producer");
	}

}
