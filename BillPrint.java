import java.util.*;
class BillPrint {
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
		System.out.println("====================================================================================");
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
		System.out.printf("|%34s|  %-14s|%15.1f   |\n"," ","Price", total-(total*discount) );
		System.out.println("+----------------------------------+----------------+------------------+");
	}

} 