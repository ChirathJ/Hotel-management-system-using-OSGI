package roomProducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import roomProducerService.roomsServices;

public class roomActivator implements BundleActivator {

	ServiceRegistration<?> publishServiceRoomService;

	public void start(BundleContext context) throws Exception {
		roomsServices roomsService = new roomsServiceImpl();
		publishServiceRoomService = context.registerService(roomsServices.class.getName(), roomsService, null);
		System.out.println("Start Room Producer");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		publishServiceRoomService.unregister();
		System.out.println("Stop Room Producer");
	}

}
