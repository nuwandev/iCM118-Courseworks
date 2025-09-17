import java.util.*;
class BillPrintV2 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		double Basmathi = 250.00;
		double Dhal = 180.00;
		double Sugar = 150.00;
		double Higland = 1200.00;
		double Yoghurt = 50.00;
		double Flour = 120.00;
		double Soap = 160.00;
		double discount = 0.1;
		double total = 0;

        	System.out.print("\033[H\033[2J");  
        	System.out.flush();

		System.out.println("====================================================================================");
		System.out.println();
		System.out.println();

		System.out.println("  __          __  _                            _          _ __  __            _     ");
		System.out.println("  \\ \\        / / | |                          | |        (_)  \\/  |          | |    ");
		System.out.println("   \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___    _| \\  / | __ _ _ __| |_   ");
		System.out.println("    \\ \\/  \\/ / _ \\ |/ __/ _ \\| \'_ ` _ \\ / _ \\ |  _/ _ \\  | | |\\/| |/ _` | `__| __|  ");
		System.out.println("     \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | | |  | | (_| | |  | |_   ");
		System.out.println("      \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_|_|  |_|\\__,_|_|   \\__|  ");

		System.out.println();
		System.out.println();
		System.out.println("====================================================================================");
		System.out.println();
		System.out.println();

		System.out.print("\t\tEnter Customer Phone Number - ");
		String tpNumber = input.nextLine();;

		System.out.println();

		System.out.print("\t\tEnter Customer Name         - ");
		String name = input.nextLine();
		
		System.out.println();
		System.out.println();
		System.out.println("====================================================================================");

        	System.out.print("\033[H\033[2J");  
        	System.out.flush();

		System.out.println();
		System.out.println();
		
		System.out.print("\t\tBasmathi Qty(Kg) - ");
		int qtyBasmathi = input.nextInt();

		System.out.print("\n\n\t\tDhal Qty(Kg)     - ");
		int qtyDhal = input.nextInt();

		System.out.print("\n\n\t\tSugar Qty(Kg)    - ");
		int qtySugar = input.nextInt();

		System.out.print("\n\n\t\tHigland Qty      - ");
		int qtyHigland = input.nextInt();

		System.out.print("\n\n\t\tYoghurt Qty      - ");
		int qtyYoghurt = input.nextInt();

		System.out.print("\n\n\t\tFlour Qty(Kg)    - ");
		int qtyFlour = input.nextInt();

		System.out.print("\n\n\t\tSoap Qty         - ");
		int qtySoap = input.nextInt();

		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("|                  _   __  __          _____ _______                   |");
		System.out.println("|                 (_) |  \\/  |   /\\   |  __ \\__   __|                  |");
		System.out.println("|                  _  | \\  / |  /  \\  | |__) | | |                     |");
		System.out.println("|                 | | | |\\/| | / /\\ \\ |  _  /  | |                     |");
		System.out.println("|                 | | | |  | |/ ____ \\| | \\ \\  | |                     |");
		System.out.println("|                 |_| |_|  |_/_/    \\_\\_|  \\_\\ |_|                     |"); 
		System.out.println("|                      225,Galle Road, Panadura.                       |");
		System.out.println("|                                                                      |");
		System.out.println("+----------------------------------------------------------------------+");

		// System.out.println("|                         # Tel : 0123445                              |");
		// System.out.println("|                         # Name : Example                             |");

		System.out.printf("|%35s%-35s|%n", "# Tel  : " , tpNumber);
		System.out.printf("|%35s%-35s|%n", "# Name : " , name);

		System.out.println("+------------------+---------------+----------------+------------------+");
		System.out.println("|                  |      Qty      |   Unit Price   |       Price      |");
		System.out.println("+------------------+---------------+----------------+------------------+");
		System.out.println("|                  |               |                |                  |");
		System.out.printf("|  %-16s|       %-8d|%13.1f   |%15.1f   |\n","# Basmathi", qtyBasmathi, Basmathi, Basmathi * qtyBasmathi);
		total += Basmathi * qtyBasmathi;

		System.out.println("|                  |               |                |                  |");
		System.out.printf("|  %-16s|       %-8d|%13.1f   |%15.1f   |\n","# Dhal", qtyDhal, Dhal, Dhal * qtyDhal);
		total += Dhal * qtyDhal;

		System.out.println("|                  |               |                |                  |");
		System.out.printf("|  %-16s|       %-8d|%13.1f   |%15.1f   |\n","# Sugar", qtySugar, Sugar, Sugar * qtySugar);
		total += Sugar * qtySugar;

		System.out.println("|                  |               |                |                  |");
		System.out.printf("|  %-16s|       %-8d|%13.1f   |%15.1f   |\n","# Higland", qtyHigland, Higland, Higland * qtyHigland);
		total += Higland * qtyHigland;

		System.out.println("|                  |               |                |                  |");
		System.out.printf("|  %-16s|       %-8d|%13.1f   |%15.1f   |\n","# Yoghurt", qtyYoghurt, Yoghurt, Yoghurt * qtyYoghurt);
		total += Yoghurt * qtyYoghurt;

		System.out.println("|                  |               |                |                  |");
		System.out.printf("|  %-16s|       %-8d|%13.1f   |%15.1f   |\n","# Flour", qtyFlour, Flour, Flour * qtyFlour);
		total += Flour * qtyFlour;

		System.out.println("|                  |               |                |                  |");
		System.out.printf("|  %-16s|       %-8d|%13.1f   |%15.1f   |\n","# Soap", qtySoap, Soap, Soap * qtySoap);
		total += Soap * qtySoap;

		System.out.println("|                  |               |                |                  |");
		System.out.println("+------------------+---------------+----------------+------------------+");
		System.out.printf("|%34s|  %-14s|%15.1f   |\n"," ","Total", total );
		System.out.println("|                                  +----------------+------------------+");
		System.out.printf("|%34s|  %-14s|%15.1f   |\n"," ","Discount(10%)", total*discount );
		System.out.println("|                                  +----------------+------------------+");
		total=total-(total*discount);
		System.out.printf("|%34s|  %-14s|%15.1f   |\n"," ","Price", total );
		System.out.println("+----------------------------------+----------------+------------------+");

		System.out.println();
		System.out.println();
		System.out.println();

		System.out.print("\t      Enter customer given amount -> ");
		double cash = input.nextDouble();
		double change = cash-total;

        	System.out.print("\033[H\033[2J");  
        	System.out.flush();

		System.out.println();
		System.out.println();

		System.out.println("                   +---------------+----------------+                   ");
		System.out.printf( "                   |  %-13s|%13.2f   |%n", "Net Amount", total);
		System.out.println("                   +---------------+----------------+                   ");
		System.out.printf( "                   |  %-13s|%13.2f   |%n", "Cash", cash);
		System.out.println("                   +---------------+----------------+                   ");
		System.out.printf( "                   |  %-13s|%13.0f   |%n", "Change", change);
		System.out.println("                   +---------------+----------------+                   ");

		System.out.println();
		System.out.println("                ========================================            ");
		System.out.println();	

		int rs5000 = (int)change/5000;
		change = (int)change%5000;

		int rs2000 = (int)change/2000;
		change = (int)change%2000;

		int rs1000 = (int)change/1000;
		change = (int)change%1000;

		int rs500 = (int)change/500;
		change = (int)change%500;

		int rs100 = (int)change/100;
		change = (int)change%100;

		int rs50 = (int)change/50;
		change = (int)change%50;

		int rs20 = (int)change/20;
		change = (int)change%20;

		int rs10 = (int)change/10;
		change = (int)change%10;

		int rs5 = (int)change/5;
		change = (int)change%5;

		int rs2 = (int)change/2;
		change = (int)change%2;

		int rs1 = (int)change/1;
		change = (int)change%1;

		int noNotes = rs5000+rs2000+rs1000+rs500+rs100+rs50+rs20;
		int noCoins = rs10+rs5+rs2+rs1;

		System.out.println("                     +--------------+-------------+                   ");
		System.out.println("                     |     Value    |      No     |                   ");
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.5000", rs5000);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.2000", rs2000);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.1000", rs1000);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.500", rs500);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.100", rs100);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.50", rs50);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.20", rs20);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.10", rs10);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.5", rs5);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.2", rs2);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |    %-10s|      %1d      |%n", "Rs.1", rs1);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |  %-12s|      %1d      |%n", "No of Notes", noNotes);
		System.out.println("                     +--------------+-------------+                   ");
		System.out.printf( "                     |  %-12s|      %1d      |%n", "No of Coins", noCoins);
		System.out.println("                     +--------------+-------------+                   ");

		System.out.println();
		System.out.println("                ==========================================");
		System.out.println("                      THANK YOU FOR SHOPPING WITH US                   ");
		System.out.println("                ==========================================");
		System.out.println();
		System.out.println();
	}

} 