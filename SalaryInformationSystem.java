import java.util.Scanner;
class SalaryInformationSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println(" -----------------------------------------------");
		System.out.println(" |          SALARY INFORMATION SYSTEM          |");
		System.out.println(" -----------------------------------------------");	
		System.out.println();
		System.out.println("            [1] Calculate Income Tax            ");
		System.out.println("            [2] Calculate Annual Bonus            ");
		System.out.println("            [3] Calculate Loan amount            ");
		System.out.println();
		System.out.print("         Enter an option to continue > ");
		int mainMenuOption = input.nextInt();
		
		clearScreen();
		input.nextLine();
		
		if (mainMenuOption == 1) {
			System.out.println(" -----------------------------------------------");
			System.out.println(" |            CALCULATE INCOME TAX             |");
			System.out.println(" -----------------------------------------------");
			System.out.println();
			System.out.print("          Input Employee name   > ");
			String name = input.nextLine();
			System.out.print("          Input Employee salary > ");
			int salary = input.nextInt();
			
			int incomeTax = 0;
			
			 //this is wrong.i just kept it (my first attempt)
			//if (100000 < salary && salary <= 141667) {
				//incomeTax += (salary - 100000)*(0.06);
			//} 
			//if (141667 < salary && salary <= 183333) {
				//incomeTax +=  (salary - 141667)*(0.12);
			//}
			//if (183333 < salary && salary <= 225000) {
				//incomeTax +=  41667*(0.18);
			//}
			//if (225000 < salary && salary <= 266667) {
				//incomeTax +=  41667*(0.24);
			//}
			//if (266667 < salary && salary <= 308333) {
				//incomeTax +=  41667*(0.30);
			//}
			//if ( salary > 308333) {
				//incomeTax +=  41667*(0.36);
			//}
			
			
			// it took me about 3.5 hours to write this logic.
			if( salary <= 100000) {
				incomeTax = 0;
			}if (salary > 100000) {
				if( salary > 141667) {
					incomeTax += 41667 * 0.06;
				}else {
					incomeTax += (salary-100000) * 0.06;
				}
			}if (salary > 141667) {
				if( salary > 183333) {
					incomeTax += 41667 * 0.12;
				}else {
					incomeTax += (salary-141667) * 0.12;
				}
			}if (salary > 183333) {
				if( salary > 225000) {
					incomeTax += 41667 * 0.18;
				}else {
					incomeTax += (salary-183333) * 0.18;
				}
			}if (salary > 225000) {
				if( salary > 266667) {
					incomeTax += 41667 * 0.24;
				}else {
					incomeTax += (salary-225000) * 0.24;
				}
			}if (salary > 266667) {
				if( salary > 308333) {
					incomeTax += 41667 * 0.30;
				}else {
					incomeTax += (salary-266667) * 0.30;
				}
			}if (salary > 308333) {
				incomeTax += (salary-308333) * 0.36;
			}
			
			System.out.println();			
			System.out.println(incomeTax == 0 
			? "   You don't have to pay income Tax" 
			: "   You have to pay Income Tax per month: "+incomeTax);
			
		}else if (mainMenuOption == 2) {
			System.out.println(" -----------------------------------------------");
			System.out.println(" |           CALCULATE ANNUAL BONUS            |");
			System.out.println(" -----------------------------------------------");
			System.out.println();
			System.out.print("          Input Employee name   > ");
			String name = input.nextLine();
			System.out.print("          Input Employee salary > ");
			int salary = input.nextInt();
			
			double annualBonus = 0;
			
			if(salary < 100000) {
				annualBonus = 5000;
			}else if (salary < 200000){
				annualBonus = salary * 0.10;
			}else if (salary < 300000){
				annualBonus = salary * 0.15;
			}else if (salary < 400000) {
				annualBonus = salary * 0.20;
			}else {
				annualBonus = salary * 0.35;
			}
			
			System.out.println();
			System.out.println("Annual bonus   - "+annualBonus);
			
		}else if (mainMenuOption == 3) {
			System.out.println(" -----------------------------------------------");
			System.out.println(" |           CALCULATE LOAN AMOUNT             |");
			System.out.println(" -----------------------------------------------");
			System.out.println();
			System.out.print("          Input Employee name   > ");
			String name = input.nextLine();
			System.out.print("          Input Employee salary > ");
			int salary = input.nextInt();
			
			if(salary < 50000) {
				System.out.println("   You can not get a loan because your salary less than Rs.50 000...");
			}else {
				System.out.print("          Entere number of year > ");
				int year = input.nextInt();
				
				if (year > 5) {
					System.out.println("The maximum number of year is 5");
				}else {					
					double monthlyInstallment = salary * 0.60;
					double annuwalInterestRate = 0.15;
					int nOMonths = year * 12;	
					double loanAmount = monthlyInstallment * ((1 - Math.pow(1 / (1 + (annuwalInterestRate / 12)), nOMonths)) / (annuwalInterestRate / 12)) ;
					
					// I found this method from google. I serached this "how to round a number round of nearest 1000 in java"
					loanAmount = (int) Math.round((double) loanAmount / 1000) * 1000;
					
					System.out.printf("%n   You can get Loan Amount : %.0f",loanAmount);
				}
			}
		}
	}
	
	public static void clearScreen(){
		/*
		 * I wanted to clear the screen so i googled how and
		 *  i found out this method works so,
		 *  that's why i'm using it here so,
		 *  no ai or other person involved.
		 * 
		 * I'm trying to prove that i'm not doing anykind of illegal thing :))
		 * 
		 * Sorry if not allowed to use methods
		*/
		System.out.print("\033[H\033[2J");  
        System.out.flush();
	}
}
