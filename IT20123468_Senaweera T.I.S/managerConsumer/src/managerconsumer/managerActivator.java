package managerconsumer;

import employeeProducerService.employeeService;
import loginProducerService.loginServices;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class managerActivator implements BundleActivator {

	ServiceReference<?> serviceReferenceEmployee, serviceReferenceLogin;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Manager Consumer");

		serviceReferenceEmployee = context.getServiceReference(employeeService.class.getName());
		employeeService employeeService = (employeeService) context.getService(serviceReferenceEmployee);

		serviceReferenceLogin = context.getServiceReference(loginServices.class.getName());
		loginServices loginService = (loginServices) context.getService(serviceReferenceLogin);

		employeeService.loadEmployee();
		loginService.loadLogin();

		int attempts = 3;
		boolean logged = false;

		while (true) {

			if (logged == false) {
				logged = loginService.verifyLogin();
				attempts--;

				if (logged == false) {
					if (attempts > 0) {
						System.out.println("You have " + attempts + " more attempts");
						continue;
					} else {
						System.out.println("Try Again Later, Too Many Invalid Attempts!");
						break;
					}
				}
			}

			System.out.println("");
			System.out.println("Display Employee Details :  1");
			System.out.println("Add New Employee Details :  2");
			System.out.println("Update Employee Details :   3");
			System.out.println("Delete Employee Details :   4");
			System.out.println("Search Employee Details :   5");

			System.out.print("Which service do you want to access :");
			Scanner scanner = new Scanner(System.in);
			int selectedService = scanner.nextInt();

			switch (selectedService) {

			case 1:
				employeeService.showEmployeeList();
				break;

			case 2:
				employeeService.addNewEmployee();
				break;

			case 3:
				employeeService.updateEmployee();
				break;

			case 4:
				employeeService.deleteEmployee();
				break;

			case 5:
				employeeService.searchEmployee();
				break;

			default:
				System.out.println("Invalid Number! Please Enter a Valid Number");
				continue;
			}

			System.out.println("");
			System.out.print("Do you want to quit? (y/n) :");
			Scanner scannerQuit = new Scanner(System.in);
			String quit = scannerQuit.next();

			if (quit.equalsIgnoreCase("y")) {
				System.out.println("");
				System.out.println("******************** Thank you ********************");
				System.out.println("******************* Login Again ********************");
				break;
			} else {
				continue;
			}
		}
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReferenceEmployee);
		System.out.println("Stop Manager Consumer");
	}

}