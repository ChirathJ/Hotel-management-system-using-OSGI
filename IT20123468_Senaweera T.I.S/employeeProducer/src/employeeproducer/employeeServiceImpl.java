package employeeproducer;

import java.util.HashMap;
import java.util.Scanner;

import employeeProducerService.employeeService;

public class employeeServiceImpl implements employeeService {

	int noEmployees = 3;

	HashMap<Integer, String> name = new HashMap<Integer, String>();
	HashMap<Integer, String> designation = new HashMap<Integer, String>();

	@Override
	public void showEmployeeList() {

		System.out.println("");
		System.out.println("Employee Details");
		System.out.println("");
		System.out.println("ID\t\tName\t\tDesignation");
		System.out.println("-------------------------------------------------------");

		for (int i = 1; i <= noEmployees; ++i) {
			if (name.get(i) != null) {
				System.out.print(i);
				System.out.print("\t\t");
				System.out.print(name.get(i));
				System.out.print("\t\t");
				System.out.println(designation.get(i));
			}
		}
		
		System.out.println("");
		System.out.println("************************* END *************************");

	}

	@Override
	public void addNewEmployee() {

		System.out.println("");
		System.out.println("Add New Employee Details");
		System.out.println("");

		System.out.print("Enter Employee Name : ");
		Scanner empName = new Scanner(System.in);
		String empNameInput = empName.next();
		System.out.println("");

		System.out.print("Enter Employee Designation : ");
		Scanner empDesignation = new Scanner(System.in);
		String empDesignationInput = empDesignation.next();
		System.out.println("");

		noEmployees++;
		name.put(noEmployees, empNameInput);
		designation.put(noEmployees, empDesignationInput);
		System.out.println("Successfully Added " + empNameInput + "'s Employee Details");
		System.out.println("");
	}

	@Override
	public void deleteEmployee() {

		System.out.println("");
		System.out.println("Delete Employee Details");
		System.out.println("");

		showEmployeeList();

		System.out.println("");
		System.out.print("Enter Employee ID : ");
		Scanner empId = new Scanner(System.in);
		int empIdInput = empId.nextInt();
		System.out.println("");

		name.remove(empIdInput);
		designation.remove(empIdInput);

		System.out.println("Successfully Deleted " + empIdInput + "'s Employee Details");
		System.out.println("");
	}

	@Override
	public void updateEmployee() {
		System.out.println("");
		System.out.println("Update Employee Details");
		System.out.println("");
		showEmployeeList();

		System.out.println("");
		System.out.print("Enter Employee ID : ");
		Scanner empId = new Scanner(System.in);
		int empIdInput = empId.nextInt();

		System.out.println("");
		System.out.print("Enter Employee Name : ");
		Scanner empName = new Scanner(System.in);
		String empNameInput = empName.next();

		System.out.println("");
		System.out.print("Enter Employee Designation : ");
		Scanner empDesignation = new Scanner(System.in);
		String empDesignationInput = empDesignation.next();

		name.put(empIdInput, empNameInput);
		designation.put(empIdInput, empDesignationInput);

		System.out.println("Successfully Updated " + empIdInput + " " + empNameInput + "'s Employee Details");
		System.out.println("");
	}

	@Override
	public void loadEmployee() {

		name.put(1, "Kamal");
		name.put(2, "Saman");
		name.put(3, "Lakal");

		designation.put(1, "Bartender");
		designation.put(2, "Reception");
		designation.put(3, "Chef");

	}

	@Override
	public void searchEmployee() {

		System.out.println("");
		System.out.println("Search an Employee");
		System.out.println("");
		System.out.print("Please Enter a Name: ");
		Scanner empName = new Scanner(System.in);
		String empNameInput = empName.next();

		Boolean value = false;
		for (int i = 1; i <= noEmployees; ++i) {
			if (name.get(i) != null) {
				if (name.get(i).equalsIgnoreCase(empNameInput)) {
					System.out.println("");
					System.out.print("ID");
					System.out.print("\t\t");
					System.out.print("Name");
					System.out.print("\t\t");
					System.out.println("Designation");

					System.out.println("------------------------------------------------------");

					System.out.print(i);
					System.out.print("\t\t");
					System.out.print(name.get(i));
					System.out.print("\t\t");
					System.out.println(designation.get(i));
					value = true;
					break;
				}
			}

		}
		if (value == false) {
			System.out.println("");
			System.out.println("***** No Employee is Found by this Name *****");
		}

	}

}
