package employeeproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import employeeProducerService.employeeService;

public class employeeActivator implements BundleActivator {
	
	ServiceRegistration<?> publishEmployeeService;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Employee Producer");
		
		employeeService employeeService = new employeeServiceImpl();
		publishEmployeeService = context.registerService(employeeService.class.getName(), employeeService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		publishEmployeeService.unregister();
		System.out.println("Stop Employee Producer");
	}

}
