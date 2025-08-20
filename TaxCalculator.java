import java.util.*;
class TaxCalculator{
	private static final Scanner input = new Scanner(System.in);
	// I only know that above code make the 'input' accible in every methods. i used INTERNET to get this command...
	
	public static void main(String args[]) {
		home();
	}
	
	// interfaces
	public static void home(){
		while(true){
			clearConsole();
			System.out.println("\n");
			System.out.println("                                                __   ______   ________  ________             ");
			System.out.println("                                               |  \\ /      \\ |        \\|        \\         ");
			System.out.println("                                                \\$$|  $$$$$$\\| $$$$$$$$ \\$$$$$$$$         ");
			System.out.println("                                               |  \\| $$   \\$$| $$__       | $$            ");
			System.out.println("                                               | $$| $$      | $$  \\      | $$            ");
			System.out.println("                                               | $$| $$   __ | $$$$$      | $$            ");
			System.out.println("                                               | $$| $$__/  \\| $$_____    | $$            ");
			System.out.println("                                               | $$ \\$$    $$| $$     \\   | $$            ");
			System.out.println("                                                \\$$  \\$$$$$$  \\$$$$$$$$    \\$$            ");
			System.out.println();
			System.out.println("      _______   ___     __   __     _____      ___      _       _____  _    _  _           ___   _______  ____   _____       ");
			System.out.println("     |__   __| /   \\    \\ \\ / /    / ____|    /   \\    | |     / ____|| |  | || |         /   \\ |__   __|/ __ \\ |  __ \\     ");
			System.out.println("        | |   /  ^  \\    \\ V /    | |        /  ^  \\   | |    | |     | |  | || |        /  ^  \\   | |  | |  | || |__) |    ");
			System.out.println("        | |  /  /_\\  \\    > <     | |       /  /_\\  \\  | |    | |     | |  | || |       /  /_\\  \\  | |  | |  | ||  _  /     ");
			System.out.println("        | | /  _____  \\  / . \\    | |____  /  _____  \\ | |____| |____ | |__| || |____  /  _____  \\ | |  | |__| || | \\ \\     ");
			System.out.println("        |_|/__/     \\__\\/_/ \\_\\    \\_____|/__/     \\__\\|______|\\_____| \\____/ |______|/__/     \\__\\|_|   \\____/ |_|  \\_\\    ");
			System.out.println();
			System.out.println();
			System.out.println("=================================================================================================================================");
			System.out.println("\n\n");
			System.out.println("                 [1] Withholding Tax \n");
			System.out.println("                 [2] Payable Tax \n");
			System.out.println("                 [3] Income Tax \n");
			System.out.println("                 [4] Social Security Contribution Levy (SSCL) Tax \n");
			System.out.println("                 [5] Leasing Payment \n");
			System.out.println("                 [6] Exit \n\n");
						
			int op = getOption();
			
			if(op == 1){
				withholdingTax();
			}else if(op == 2){
				payableTax();
			}else if(op == 3){
				incomeTax();
			}else if(op == 4){
				ssclTax();
			}else if(op == 5){
				leasingPayment();
			}else if(op == 6){
				return;
			}else {
				wrongOption();
			}
		}
	}
	
	// with holding tax
	public static void withholdingTax(){
		while(true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                      WITHHOLDING TAX                      |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("\n                [1] Rent Tax \n");
			System.out.println("                [2] Bank Interest Tax \n");
			System.out.println("                [3] Devidend Tax \n");
			System.out.println("                [4] Exit \n\n");
			
			int op = getOption();
			
			if (op == 1){
				rentTax();
				return;
			}else if (op == 2){
				bankInterestTax();
				return;
			}else if (op == 3){
				dividendTax();
				return;
			}else if (op == 4){
				return;
			}else {
				wrongOption();
			}
		}
	}
	
	public static void rentTax(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                         Rent TAX                          |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n         %-25s : ","Enter your rent");
			double rent = input.nextDouble();
			
			if (rent>=0){
				if (rent <= 100000){
					printDont("Rent Tax");
				}else {
					double tax = rent * 0.10;
					System.out.printf("\n         %-25s : %,.2f","You have to pay Rent Tax", tax);
				}
				if (tryAgain("Rent Tax")){
					return;
				}
			}else {				
				if(invalidInput()){
					return;
				}
			}
		}
	}
	
	public static void bankInterestTax(){
		while(true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                     Bank Interest TAX                     |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n         %-43s : ","Enter your Bank interest per year");
			double bankInterest = input.nextDouble();
			
			if (bankInterest>=0){
				double tax = bankInterest * 0.05;
				System.out.printf("\n         %-43s : %,.2f","You have to pay Bank Interest Tax per year",tax);
				
				if (tryAgain("Bank Interest Tax")){
					return;
				}
			}else {
				if(invalidInput()){
					return;
				}
			}
		}
	}
	
	public static void dividendTax(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                        Devidend TAX                       |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n         %-37s : ","Enter your total  devidend per year");
			double dividend = input.nextDouble();
			
			if (dividend >= 0){
				if (dividend > 100000){
					double tax = dividend * 0.14;
					System.out.printf("\n         %-37s : %,.2f","You have to pay Dividend Tax per year",tax);
				}else {
					printDont("Dividend Tax");
				}
				if (tryAgain("Dividend Tax")){
					return;
				}
			}else {
				if (invalidInput()){
					return;
				}
			}
			
			System.out.printf("\n         %-37s : ","You have to pay Dividend Tax per year");
		}
	}
	
	public static void payableTax(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                        PAYABLE TAX                        |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n         %-37s : ","Enter your employee payment per month");
			double employeePayment = input.nextDouble();

			if (employeePayment >= 0){
				if (employeePayment < 100000){
					printDont("Payable Tax");
				}else {
					double tax = getPayableTax(employeePayment);
					System.out.printf("\n         %-37s : %.2f","Enter your employee payment per month", tax);
				}
				
				if (tryAgain("Payable Tax")){
					return;
				}
			}else {
				if(invalidInput()){
					return;
				}
			}
		}
	}
	
	public static void incomeTax(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                         INCOME TAX                        |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n         %-35s : ","Enter your total income per year");
			double income = input.nextDouble();
			
			if (income >= 0){
				if (income < 1200000){
					printDont("Income Tax");
				}else {
					double tax = findIncomeTax(income);
					System.out.printf("\n         %-35s : %,.2f","You have to pay Income Tax per year",tax);
				}

				if (tryAgain("Income Tax")){
					return;
				}
			}else {
				if (invalidInput()){
					return;
				}
			}
		}
	}
	
	public static void ssclTax(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |        SOCIAL SECURITY CONTIBUTION LEVY (SSCL) TAX        |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n         %-30s : ","Enter value of Good or Service");
			double value = input.nextDouble();
			
			if (value >= 0){
				double tax = calculateSSCLTax(value);
				System.out.printf("\n         %-30s : %,.2f","You have to pay SSCL Tax", tax);

				if (tryAgain("SSCL Tax")){
					return;
				}
			}else {
				if (invalidInput()){
					return;
				}
			}
		}
	}
	
	public static void leasingPayment(){
		while(true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                      LEASING PAYMENT                      |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("\n                [1] Calculate Monthly Installment \n");
			System.out.println("                [2] Search Leasing Category \n");
			System.out.println("                [3] Find Leasing Amount\n");
			System.out.println("                [4] Exit \n\n");
			
			int op = getOption();
			
			if (op == 1){
				monthlyInstallment();
				return;
			}else if (op == 2){
				leasingCategory();
				return;
			}else if (op == 3){
				leasingAmount();
				return;
			}else if (op == 4){
				return;
			}else {
				wrongOption();
			}
		}
	}
	
	public static void monthlyInstallment(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                      LEASING PAYMENT                      |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n      %-26s : ","Enter lease amount");
			double amount = input.nextDouble();
			double rate = 0;
			while(true){
				System.out.printf("\n      %-26s : ","Enter annual interest rate");
				rate = input.nextDouble();
				if (rate<0){	
					System.out.println("\n        Invalid rate... Enter the correct value again...");
				}else {
					break;
				}
			}
			
			double year = 0;
			while(true){
				System.out.printf("\n      %-26s : ","Enter number of year");
				year = input.nextDouble();
				if (year > 5){
					System.out.println("\n        Invalid number of year... Enter the correct value again...");
				}else {
					break;
				}
			}
			
			double instalment = calculateInstallment(amount, rate, year);
			System.out.printf("\n      %-26s : %,.2f","Enter monthly instalment",instalment);
			
			if(tryAgain("monthly instalment")){
				return;
			}
		}
	}
	
	public static void leasingCategory(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                   SEARCH LEASING CATEGORY                 |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n      %-26s : ","Enter lease amount");
			double amount = input.nextDouble();
			double rate = 0;
			while(true){
				System.out.printf("\n      %-26s : ","Enter annual interest rate");
				rate = input.nextDouble();
				if (rate<0){	
					System.out.println("\n        Invalid rate... Enter the correct value again...");
				}else {
					break;
				}
			}
			
			double instalment3Yr = calculateInstallment(amount, rate, 3);
			double instalment4Yr = calculateInstallment(amount, rate, 4);
			double instalment5Yr = calculateInstallment(amount, rate, 5);
			
			System.out.printf("\n      Your monthly instalment for 3 year leasingg plan - %.2f",instalment3Yr);
			System.out.printf("\n      Your monthly instalment for 4 year leasingg plan - %.2f",instalment4Yr);
			System.out.printf("\n      Your monthly instalment for 5 year leasingg plan - %.2f",instalment5Yr);
			
			if (tryAgain("Search","Leasing Category")){
				return;
			}
		}
	}
	
	public static void leasingAmount(){
		while (true){
			clearConsole();
			System.out.println("    +-----------------------------------------------------------+");
			System.out.println("    |                     FIND LEASING AMOUNT                   |");
			System.out.println("    +-----------------------------------------------------------+");
			System.out.printf("\n      %-53s : ","Enter the monthly lease payment amount you can afford");
			double mInstallment = input.nextDouble();
			double year = 0;
			while(true){
				System.out.printf("\n      %-53s : ","Enter number of year");
				year = input.nextDouble();
				if (year > 5){
					System.out.println("\n        Invalid number of year... Enter the correct value again...");
				}else {
					break;
				}
			}
			double rate = 0;
			while(true){
				System.out.printf("\n      %-53s : ","Enter annual interest rate");
				rate = input.nextDouble();
				if (rate<0){	
					System.out.println("\n        Invalid rate... Enter the correct value again...");
				}else {
					break;
				}
			}
			
			double lease = findLeasingAmount(mInstallment, rate, year);
			lease = Math.ceil(lease); // form google <-
			System.out.printf("\n      %-53s : %.2f","You can get Lease Amount",lease);
			
			if (tryAgain("monthly installment")){
				return;
			}
		}
	}
	
	// calculation methods;
	public static double findLeasingAmount(double installment, double rate, double year){
		double i = (rate / 100.0) / 12.0;
		double n = year*12;

		return installment * (1 - Math.pow(1 + i, -n)) / i;
	}
	
	public static double calculateInstallment(double amount, double rate, double year){
		double a = amount;
		double i = (rate / 100.0) / 12.0;
		double n = year*12;
		
		return a*i / (1- Math.pow(1+i, -n));
	}
	
	public static double calculateSSCLTax(double value){
		double salesTax = (value*0.025);
		double vat = (value+salesTax) * 0.15;
		return salesTax + vat;
	}
	
	public static double findIncomeTax(double income){
		double tax = 0;
		
		if (income > 1200000){
			tax += (min(income, 1700000) - 1200000) * 0.06;
		}
		if (income > 1700000){
			tax += (min(income, 2200000) - 1700000) * 0.12;
		}
		if (income > 2200000){
			tax += (min(income, 2700000) - 2200000) * 0.18;
		}
		if (income > 2700000){
			tax += (min(income, 3200000) - 2700000) * 0.24;
		}
		if (income > 3200000){
			tax += (min(income, 3700000) - 3200000) * 0.30;
		}
		if (income > 3700000){
			tax += (income - 3700000) * 0.36;
		}
		
		return tax;
	}
	 
	public static double getPayableTax(double income){
		double tax = 0;
		
		if (income < 100000){
			return 0;
		}
		if (income > 100000){
			if (income > 141667){
				tax += (141667 - 100000) * 0.06;
			}else {
				tax += (income - 100000) * 0.06;
			}
		}
		if (income > 141667){
			if (income > 183333){
				tax += (183333 - 141667) * 0.12;
			}else {
				tax += (income - 141667) * 0.12;
			}
		}
		if (income > 183333){
			if (income > 225000){
				tax += (225000 - 183333) * 0.18;
			}else {
				tax += (income - 183333) * 0.18;
			}
		}
		if (income > 225000){
			if (income > 266667){
				tax += (266667 - 225000) * 0.24;
			}else {
				tax += (income - 225000) * 0.24;
			}
		}
		if (income > 266667){
			if (income > 308333){
				tax += (308333 - 266667) * 0.30;
			}else {
				tax += (income - 266667) * 0.30;
			}
		}
		
		if (income > 308333){
			tax += (income - 308333) * 0.36;
		}
		
		return tax;
	}
	
	// help methods
	public static double min(double a, double b){
		return a < b ? a : b;
	}
	
	public static void printDont(String tax){
		System.out.println("\n               You Don't have to pay "+tax+"...");
	}
	
	public static int getOption(){
		System.out.print("        Enter an option to continue -> ");
		int op = input.nextInt();
		return op;
	}
	
	public static boolean tryAgain(String tax){
		//note: if usr y -> recalcuate, if n -> go to home pge
		System.out.print("\n\n\n    Do you want to calculate another "+tax+" (Y/N): ");
		char opTryAgain = input.next().toLowerCase().charAt(0);
		
		return opTryAgain == 'n';
	}
	
	public static boolean tryAgain(String type,String tax){
		//note: if usr y -> recalcuate, if n -> go to home pge
		System.out.print("\n\n\n    Do you want to "+type+" another "+tax+" (Y/N): ");
		char opTryAgain = input.next().toLowerCase().charAt(0);
		
		return opTryAgain == 'n';
	}
	
	public static void wrongOption(){
		System.out.print("\n    Wrong Option Selected, Press Enter to try again... ");
		input.nextLine();
		input.nextLine();
	}
	
	public static boolean invalidInput(){
		System.out.println("\n               Invalid input...");
		System.out.print("\n\n\n    Do you want to enter the correct value again (Y/N): ");
		char opInvalidInput = input.next().toLowerCase().charAt(0);
		
		return opInvalidInput == 'n';
	}
	
	// from google
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle exceptions, e.g., print an error message
		}
	}
}
