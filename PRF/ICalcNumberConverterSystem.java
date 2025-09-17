import java.util.*;
class ICalcNumberConverterSystem{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		
		while(true){
			// Clear Screnn...
			System.out.print("\033[H\033[2J");
			System.out.flush();
			
			System.out.println("\n");
			System.out.println("                               __   ______             __              ");
			System.out.println("                              |  \\ /      \\           |  \\             ");
			System.out.println("                               \\$$|  $$$$$$\\  ______  | $$  _______    ");
			System.out.println("                              |  \\| $$   \\$$ |      \\ | $$ /       \\   ");
			System.out.println("                              | $$| $$        \\$$$$$$\\| $$|  $$$$$$$   ");
			System.out.println("                              | $$| $$   __  /      $$| $$| $$         ");
			System.out.println("                              | $$| $$__/  \\|  $$$$$$$| $$| $$_____    ");
			System.out.println("                              | $$ \\$$    $$ \\$$    $$| $$ \\$$     \\   ");
			System.out.println("                               \\$$  \\$$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$   ");
			System.out.println();
			System.out.println("    _   _                 _                  _____                          _              ");
			System.out.println("   | \\ | |               | |                / ____|                        | |              ");
			System.out.println("   |  \\| |_   _ _ __ ___ | |__   ___ _ __  | |     ___  _ ____   _____ _ __| |_ ___ _ __    ");
			System.out.println("   | . ` | | | | \'_ ` _ \\| \'_ \\ / _ \\ \'__| | |    / _ \\| \'_ \\ \\ / / _ \\ \'__| __/ _ \\ \'__|   ");
			System.out.println("   | |\\  | |_| | | | | | | |_) |  __/ |    | |___| (_) | | | \\ V /  __/ |  | ||  __/ |      ");
			System.out.println("   |_| \\_|\\__,_|_| |_| |_|_.__/ \\___|_|     \\_____\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_|      ");
			System.out.println();
			System.out.println("===========================================================================================");
			System.out.println("\n\n");
			System.out.println("               [01] Decimal Converter   \n");
			System.out.println("               [02] Binary Converter   \n");
			System.out.println("               [03] Octal Converter   \n");
			System.out.println("               [04] Hexadecimal Converter   \n");
			System.out.println("               [05] Roman Number Converter   \n");
			System.out.println("               [99] Exit   \n\n");
			
			System.out.print("          Enter Option -> ");
			int op = input.nextInt();
			
			if(op == 1) {
				while(true){
					System.out.print("\033[H\033[2J");
					System.out.flush();
			
					System.out.println("     +---------------------------------+");
					System.out.println("     |        Decimal Converter        |");
					System.out.println("     +---------------------------------+");
					
					System.out.println("\n\n");
					System.out.print("     Enter an Decimaml Number: ");
					int num = input.nextInt();
					int numTemp = num;
					
					if(num >=0){	
						String binaryNum = "";
						do{
							binaryNum = (num % 2) + binaryNum;
							num/=2;
						}while(num != 0);
						
						num=numTemp;
						String octalNum = "";
						do{
							octalNum = (num % 8) + octalNum;
							num/=8;
						}while(num != 0);
						
						num=numTemp;
						String hexadecimalNum = "";
						do{
							int reminder = num%16;
							switch(reminder){
								case 10:
									hexadecimalNum = 'A' + hexadecimalNum;
									break;
								case 11:
									hexadecimalNum = 'B' + hexadecimalNum;
									break;
								case 12:
									hexadecimalNum = 'c' + hexadecimalNum;
									break;
								case 13:
									hexadecimalNum = 'D' + hexadecimalNum;
									break;
								case 14:
									hexadecimalNum = 'E' + hexadecimalNum;
									break;
								case 15:
									hexadecimalNum = 'F' + hexadecimalNum;
									break;
								default: 
									hexadecimalNum = reminder + hexadecimalNum;
							}
							num/=16;
						}while(num != 0);
						
						System.out.println();
						System.out.println("          Binary number: "+binaryNum);
						System.out.println("          Octal number: "+octalNum);
						System.out.println("          Hexadecimala number: "+hexadecimalNum);
						
						System.out.print("\n\n     Do you want to go to homepage (Y/N) -> ");
						char op1 = input.next().toLowerCase().charAt(0);
						
						if(op1 == 'y'){
							break;
						}
						
					}else {
						System.out.println("       Invalid Input...");
						
						System.out.print("\nDo you wanwt to input number again(Y/N) -> ");
						char opDecimal = input.next().toLowerCase().charAt(0);
						
						if(opDecimal == 'n') {
							break;
						}
					}
				}
			}else if(op == 2) {
				while(true){
					System.out.print("\033[H\033[2J");
					System.out.flush();
			
					System.out.println("     +---------------------------------+");
					System.out.println("     |         Binary Converter        |");
					System.out.println("     +---------------------------------+");
					
					System.out.println("\n\n");
					System.out.print("     Enter a Binary Number: ");
					int num = input.nextInt();
					int tempNum = num;
					
					boolean isBinary = true;
					
					while(num != 0){
						if(!(num%10 == 0 || num%10 ==1)){
							isBinary = false;
						}
						num/=10;
					}
					
					if(isBinary){						
						int count;
						int decimal = 0;
						String octal = "";
						String hexa = "";
						
						count = 0;
						num = tempNum;
						do{
							decimal += num%10 * Math.pow(2 , count);
							count++;
							num/=10;
						}while(num != 0);
						
						count = 0;
						num = tempNum;
						int deciOf3 = 0;
						do{
							deciOf3 += num%10 * Math.pow(2 , count);
							count++;
							num/=10;
							
							if(count == 3){
								octal = deciOf3 + octal;
								count = 0;
								deciOf3 = 0;
							}
						}while(num != 0);
						
						if(count>0){
							octal = deciOf3 + octal;
						}
						
						//hex
						count = 0;
						num = tempNum;
						int deciOf4 = 0;
						do{
							deciOf4 += num%10 * Math.pow(2 , count);
							count++;
							num/=10;
							
							if(count == 4){
								switch (deciOf4){
									case 10:
										hexa = 'A' + hexa;	
										break;
									case 11:
										hexa = 'B' + hexa;	
										break;
									case 12:
										hexa = 'C' + hexa;	
										break;
									case 13:
										hexa = 'D' + hexa;	
										break;
									case 14:
										hexa = 'E' + hexa;	
										break;
									case 15:
										hexa = 'F' + hexa;	
										break;
									default: 
										hexa = deciOf4 + hexa;
										break;
								}
								count = 0;
								deciOf4 = 0;
							}
						}while(num != 0);
						
						if(count>0){
							switch (deciOf4){
								case 10:
									hexa = 'A' + hexa;	
									break;
								case 11:
									hexa = 'B' + hexa;	
									break;
								case 12:
									hexa = 'C' + hexa;	
									break;
								case 13:
									hexa = 'D' + hexa;	
									break;
								case 14:
									hexa = 'E' + hexa;	
									break;
								case 15:
									hexa = 'F' + hexa;	
									break;
								default: 
									hexa = deciOf4 + hexa;
									break;
							}
						}
												
						System.out.println();
						System.out.println("          Decimal number: "+ decimal);
						System.out.println("          Octal number: "+ octal);
						System.out.println("          Hexadecimala number: "+hexa);
						
						System.out.print("\n\n     Do you want to go to homepage (Y/N) -> ");
						char op1 = input.next().toLowerCase().charAt(0);
						
						if(op1 == 'y'){
							break;
						}
					}else {
						System.out.println("       Invalid Input...");
						
						System.out.print("\nDo you wanwt to input number again(Y/N) -> ");
						char opDecimal = input.next().toLowerCase().charAt(0);
						
						if(opDecimal == 'n') {
							break;
						}
					}
				}
			}else if(op == 3) {
				while(true){
					System.out.print("\033[H\033[2J");
					System.out.flush();
			
					System.out.println("     +---------------------------------+");
					System.out.println("     |          Octal Converter        |");
					System.out.println("     +---------------------------------+");
					
					System.out.println("\n\n");
					System.out.print("     Enter a Octal Number: ");
					int num = input.nextInt();
					int tempNum = num;
					
					boolean isBinary = true;
					
					while(num != 0){
						if(!(num%10 >= 0 && num%10 < 8)){
							isBinary = false;
						}
						num/=10;
					}
					
					if(isBinary){
						
						int decimal = 0;
						String binary = "";
						String hexa = "";
						int count;
						
						//decimal
						count = 0;
						num = tempNum;
						do{
							decimal += num%10 * Math.pow(8 , count);
							count++;
							num/=10;
						}while(num != 0);
						
						//binaray
						count = 0;
						num = tempNum;
						do{
							int lastDigit = num%10;
							num/=10;							
							
							switch(lastDigit) {
								case 0: 
									binary = "000" + binary;
									break;
								case 1: 
									binary = "001" + binary;
									break;
								case 2: 
									binary = "010" + binary;
									break;
								case 3: 
									binary = "011" + binary;
									break;
								case 4: 
									binary = "100" + binary;
									break;
								case 5: 
									binary = "101" + binary;
									break;
								case 6: 
									binary = "110" + binary;
									break;
								case 7: 
									binary = "111" + binary;
									break;
							}
						}while(num!=0);
						
						//hexa
						int length = binary.length();
						do{
							int deciOf4 = 0;
							count = 0;
							
							for (int i = 0; i < 4; i++){
								length-- ;
								if(length<0) {
									break;
								}
								
								char bit = binary.charAt(length);
								int bitInt = bit - '0';
								
								deciOf4 += bitInt * Math.pow(2, count);
								count++;
							}
							
							switch (deciOf4){
								case 10:
									hexa = 'A' + hexa;	
									break;
								case 11:
									hexa = 'B' + hexa;	
									break;
								case 12:
									hexa = 'C' + hexa;	
									break;
								case 13:
									hexa = 'D' + hexa;	
									break;
								case 14:
									hexa = 'E' + hexa;	
									break;
								case 15:
									hexa = 'F' + hexa;	
									break;
								default: 
									hexa = deciOf4 + hexa;
									break;
							}
							
						}while(length > 0);
						
						System.out.println();
						System.out.println("          Decimal number: "+decimal);
						System.out.println("          Binary number: "+binary);
						System.out.println("          Hexadecimala number: "+hexa);
						
						System.out.print("\n\n     Do you want to go to homepage (Y/N) -> ");
						char op1 = input.next().toLowerCase().charAt(0);
						
						if(op1 == 'y'){
							break;
						}
					}else {
						System.out.println("       Invalid Input...");
						
						System.out.print("\nDo you wanwt to input number again(Y/N) -> ");
						char opDecimal = input.next().toLowerCase().charAt(0);
						
						if(opDecimal == 'n') {
							break;
						}
					}
				}
			}else if(op == 4) {
				while(true){
					System.out.print("\033[H\033[2J");
					System.out.flush();
			
					System.out.println("     +---------------------------------+");
					System.out.println("     |       HexaDecimal Converter     |");
					System.out.println("     +---------------------------------+");
					
					System.out.println("\n\n");
					System.out.print("     Enter a HexaDecimal Number: ");
					String num = input.next().toUpperCase();
					String tempNum = num;
					
					boolean isHexa = true;
					
					int length = num.length();
					for (int i = 0; i < num.length(); i++){
						char lastChar = num.charAt(length-1);
						//System.out.println(lastChar);
						//System.out.println(lastChar >= '0' && lastChar <= '9' || lastChar >= 'A' && lastChar <= 'F');
						length--;
						if(!(lastChar >= '0' && lastChar <= '9' || lastChar >= 'A' && lastChar <= 'F')){
							isHexa = false;
						}
					}					
					
					if(isHexa){
						
						//decimal
						length = num.length();
						int decimal = 0;
						int count = 0;
						for (int i = 0; i < num.length(); i++){
							char lastChar = num.charAt(length-1);
							length--;
							int deciForHex = 0;
							switch(lastChar){
								case 'A':
									deciForHex = 10;
									break;
								case 'B':
									deciForHex = 11;
									break;
								case 'C':
									deciForHex = 12;
									break;
								case 'D':
									deciForHex = 13;
									break;
								case 'E':
									deciForHex = 14;
									break;
								case 'F':
									deciForHex = 15;
									break;
								default:
									deciForHex = lastChar - '0';
							}
							//System.out.println("deciForhex "+deciForHex);
							//System.out.println("count "+count);
							decimal += deciForHex * Math.pow(16, count);
							count++;
						}
						
						////binary 
						String binary = "";
						length = num.length();
						for (int i = 0; i < num.length(); i++){
							char lastChar = num.charAt(length-1);
							length--;
							switch(lastChar){
								case '0':
									binary = "0000" + binary;
									break;
								case '1':
									binary = "0001" + binary;
									break;
								case '2':
									binary = "0010" + binary;
									break;
								case '3':
									binary = "0011" + binary;
									break;
								case '4':
									binary = "0100" + binary;
									break;
								case '5':
									binary = "0101" + binary;
									break;
								case '6':
									binary = "0110" + binary;
									break;
								case '7':
									binary = "0111" + binary;
									break;
								case '8':
									binary = "1000" + binary;
									break;
								case '9':
									binary = "1001" + binary;
									break;
								case 'A':
									binary = "1010" + binary;
									break;
								case 'B':
									binary = "1011" + binary;
									break;
								case 'C':
									binary = "1100" + binary;
									break;
								case 'D':
									binary = "1101" + binary;
									break;
								case 'E':
									binary = "1110" + binary;
									break;
								case 'F':
									binary = "1111" + binary;
									break;
							}
						}
						
						//octal
						
						String octal = "";
						length = num.length();
						count = 0;
						int deciOf3 = 0;
						for (int i = binary.length() - 1; i >= 0; i--) {
							char bit = binary.charAt(i);

							if (bit == '1') {
								deciOf3 += Math.pow(2, count);
							}
							count++;

							if (count == 3) {
								octal = deciOf3 + octal;
								count = 0;
								deciOf3 = 0;
							}
						}

						// leftover bits
						if (count > 0) {
							octal = deciOf3 + octal;
						}
						
						System.out.println();
						System.out.println("          Decimal number: "+decimal);
						System.out.println("          Binary number: "+binary);
						System.out.println("          Octal number: "+octal);
						
						System.out.print("\n\n     Do you want to go to homepage (Y/N) -> ");
						char op1 = input.next().toLowerCase().charAt(0);
						
						if(op1 == 'y'){
							break;
						}
					}else {
						System.out.println("       Invalid Input...");
						
						System.out.print("\nDo you wanwt to input number again(Y/N) -> ");
						char opDecimal = input.next().toLowerCase().charAt(0);
						
						if(opDecimal == 'n') {
							break;
						}
					}
				}
			}else if(op == 5) {
				Roman:while(true) {
					System.out.print("\033[H\033[2J");
					System.out.flush();
			
					System.out.println("     +---------------------------------+");
					System.out.println("     |      Roman Number Converter     |");
					System.out.println("     +---------------------------------+");
					System.out.println("\n\n");
					System.out.println(" [01] Decimal Number to Roman Number Converter\n");					
					System.out.println(" [02] Roman Number to Decimal Number Converter");					
					System.out.println("\n\n");
					System.out.print("     Enter an option: ");
					int op1 = input.nextInt();
					
					if(op1 == 1){
						while(true){				
							System.out.print("\033[H\033[2J");
							System.out.flush();
				
							System.out.println("     +---------------------------------------------------+");
							System.out.println("     |      Decimal Number to Roman Number Converter     |");
							System.out.println("     +---------------------------------------------------+");
							System.out.println("\n\n");
							
							System.out.print("	  Enter an Decimal number : ");
							int decimal = input.nextInt();
							
							boolean isdecimal = true;
							
							if(decimal < 0){
								isdecimal = false;
							}
							
							if(isdecimal) {								
								String roman = "";
								
								//-----------------
								// trying to find the logic to convert...
								//System.out.println(decimal); // 516 for tests
								
								//System.out.println(decimal / 500 != 0);
								//System.out.println(decimal % 500);
								//decimal %= 500;
								//roman += "D";
								//System.out.println(decimal / 10 != 0);
								//System.out.println(decimal % 10);
								//decimal %= 10;
								//roman += "X";
								//System.out.println(decimal / 5 != 0);
								//System.out.println(decimal % 5);
								//decimal %= 5;
								//roman += "V";
								//System.out.println(decimal / 1 != 0);
								//System.out.println(decimal % 1);
								//decimal %= 1;
								//roman += "I";
								
								//System.out.println("Decimal "+decimal);
								//System.out.println("Roman "+roman);
								// yeahh, i's working....
								//-----------------
								
								//final one with a lot improved.... it took me about 3h to complete below while loop... 
								int pre = 0;
								while(decimal != 0) {
									if(decimal >= 1000){
										for (int i = 0; i < decimal/1000; i++) {
											roman += "M";
										}
										decimal %= 1000;
										pre = 1000;

									} else if(decimal >= 900){
										roman += "CM";
										decimal -= 900;
										pre = 100;

									} else if(decimal >= 500){
										roman += "D";
										decimal -= 500;
										pre = 500;

									} else if(decimal >= 400){
										roman += "CD";
										decimal -= 400;
										pre = 100;

									} else if(decimal >= 100){
										for (int i = 0; i < decimal/100; i++) {
											roman += "C";
										}
										decimal %= 100;
										pre = 100;

									} else if(decimal >= 90){
										roman += "XC";
										decimal -= 90;
										pre = 10;

									} else if(decimal >= 50){
										roman += "L";
										decimal -= 50;
										pre = 50;

									} else if(decimal >= 40){
										roman += "XL";
										decimal -= 40;
										pre = 10;

									} else if(decimal >= 10){
										for (int i = 0; i < decimal/10; i++) {
											roman += "X";
										}
										decimal %= 10;
										pre = 10;

									} else if(decimal >= 9){
										roman += "IX";
										decimal -= 9;
										pre = 1;

									} else if(decimal >= 5){
										roman += "V";
										decimal -= 5;
										pre = 5;

									} else if(decimal >= 4){
										roman += "IV";
										decimal -= 4;
										pre = 1;

									} else{
										for (int i = 0; i < decimal; i++){
											roman += "I";
										}
										decimal = 0;
									}
								}
								
								System.out.println();
								System.out.println("	  	  Roman Numeral: "+roman);
								
								System.out.print("\n\n     Do you want to go to homepage (Y/N) -> ");
								char op2 = input.next().toLowerCase().charAt(0);
								
								if(op2 == 'y'){
									break Roman;
								}
							}else  {
								System.out.println("       Invalid Input...");
							
								System.out.print("\nDo you wanwt to input number again(Y/N) -> ");
								char opDecimal = input.next().toLowerCase().charAt(0);
								
								if(opDecimal == 'n') {
									break;
								}
							}
						}
					}else if(op1 == 2){            
						while (true){
							System.out.print("\033[H\033[2J");
							System.out.flush();

							System.out.println("     +---------------------------------------------------+");
							System.out.println("     |      Roman Number to Decimal Number Converter     |");
							System.out.println("     +---------------------------------------------------+");
							System.out.println("\n\n");
							
							System.out.print("	  Enter an Roman number : ");
							String roman = input.next().toUpperCase();
							
							boolean isRoman = true;
							
							for (int i = 0; i < roman.length(); i++){
								//System.out.println(roman.charAt(i));
								if(!(
									roman.charAt(i) == 'I' ||
									roman.charAt(i) == 'V' ||
									roman.charAt(i) == 'X' ||
									roman.charAt(i) == 'L' ||
									roman.charAt(i) == 'C' ||
									roman.charAt(i) == 'D' ||
									roman.charAt(i) == 'M'
								)){
									isRoman = false;
								}
							}
							
							
							if(isRoman){
								int decimal = 0;
								
								for (int i = 0; i < roman.length(); i++){
									int value = 0;
									
									switch(roman.charAt(i)){
										case 'I':
											value= 1;
											break;
										case 'V':
											value= 5;
											break;
										case 'X':
											value= 10;
											break;
										case 'L':
											value= 50;
											break;
										case 'C':
											value= 100;
											break;
										case 'D':
											value= 500;
											break;
										case 'M':
											value= 1000;
											break;
									}
									if(i+1< roman.length()){
										int nextValue = 0;
										switch(roman.charAt(i + 1)){
											case 'I':
												nextValue= 1;
												break;
											case 'V':
												nextValue= 5;
												break;
											case 'X':
												nextValue= 10;
												break;
											case 'L':
												nextValue= 50;
												break;
											case 'C':
												nextValue= 100;
												break;
											case 'D':
												nextValue= 500;
												break;
											case 'M':
												nextValue= 1000;
												break;
										}
										
										decimal = value<nextValue ?  decimal - value : decimal + value;
									}else {
										decimal += value; // last one
									}
								}
								//so i just used google to check how roman numbers work
								
								//- if a smaller value comes before a bigger one -> we subtract
								//- else we just add
								//for exampel:
								//IV = 4 → 5 - 1
								//VI = 6 → 5 + 1
								//IX = 9 → 10 - 1
								//XI = 11 → 10 + 1
								//XC = 90 → 100 - 10
								
								System.out.println();
								System.out.println("	  	  Decimal Number: "+decimal);
								
								System.out.print("\n\n     Do you want to go to homepage (Y/N) -> ");
								char op2 = input.next().toLowerCase().charAt(0);
								
								if(op2 == 'y'){
									break Roman;
								}
							}else {
								System.out.println("       Invalid Input...");
							
								System.out.print("\nDo you wanwt to input number again(Y/N) -> ");
								char opromaan = input.next().toLowerCase().charAt(0);
								
								if(opromaan == 'n') {
									break;
								}
							}
						}
					}else {
						System.out.println("\n   Error: Invalid Option...");
					}
				}
			}else if(op == 99) {
				return;
			}else {
				System.out.println("\n   Error: Invalid Option...");
			}
		}
	}
}
