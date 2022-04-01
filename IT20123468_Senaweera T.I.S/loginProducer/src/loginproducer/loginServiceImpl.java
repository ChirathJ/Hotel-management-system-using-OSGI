package loginproducer;

import java.util.HashMap;
import java.util.Scanner;

import loginProducerService.loginServices;

public class loginServiceImpl implements loginServices {

	HashMap<Integer, String> userName = new HashMap<Integer, String>();
	HashMap<Integer, String> password = new HashMap<Integer, String>();

	int noPasswords = 3;
	boolean logged = false;

	@Override
	public boolean verifyLogin() {

		System.out.println("");
		System.out.print("Enter UserName :");
		Scanner scannerUsername = new Scanner(System.in);
		String inputUsername = scannerUsername.next();

		System.out.println("");
		System.out.print("Enter Password :");
		Scanner scannerPassword = new Scanner(System.in);
		String inputPassword = scannerPassword.next();

		for (int i = 1; i <= noPasswords; ++i) {
			if (userName.get(i) != null) {
				if (userName.get(i).equals(inputUsername) && password.get(i).equals(inputPassword)) {
					logged = true;
				}
			}
		}
		if (logged == false) {
			System.out.println("Incorrect Username or Password was Entered");
		}
		return logged;
	}

	@Override
	public void loadLogin() {

		userName.put(1, "Ishma");
		userName.put(2, "Kasun");
		userName.put(3, "Dasun");

		password.put(1, "Ishma123");
		password.put(2, "Kasun123");
		password.put(3, "Dasun123");

	}

}
