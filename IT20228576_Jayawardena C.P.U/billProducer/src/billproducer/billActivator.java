package billproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import billProducerService.billService;

public class billActivator implements BundleActivator {

	ServiceRegistration<?> publishServiceBillService;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Bill Producer");
		billService billService = new billServiceImpl();
		publishServiceBillService = context.registerService(billService.class.getName(), billService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		publishServiceBillService.unregister();
		System.out.println("Stop Bill Producer");
	}

}
