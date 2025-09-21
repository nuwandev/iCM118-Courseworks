import java.util.*;
class iHungryBurgerShop{
	final static double BURGERPRICE=500;
	public static final int PREPARING=0;
	public static final int DELIVERED=1;
	public static final int CANCEL=2;
	
	public static Scanner input = new Scanner(System.in);
	public static int idCount = 1;
	
	// max orders this system can handle is 100 :)
	public static String[] orderIDs = new String[100];
	public static String[] customerIDs = new String[100];
	public static String[] customerNames = new String[100];
	public static int[] quantities = new int[100];
	public static double[] totals = new double[100];
	public static int[] orderStatus = new int[100];
	public static int orderCount = 0;
	
	public static void main(String[] args){
		//adding orders manualy for testing;
		
		//order1
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0705028061";
		customerNames[orderCount] = "Theekshana";
		quantities[orderCount] = 3;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 3*BURGERPRICE;
		orderCount++;
		
		//order2
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0705028062";
		customerNames[orderCount] = "Nuwan";
		quantities[orderCount] = 5;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 5*BURGERPRICE;
		orderCount++;
		
		//order3 -> same customer at order2
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0705028062";
		customerNames[orderCount] = "Nuwan";
		quantities[orderCount] = 2;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 2*BURGERPRICE;
		orderCount++;
		
		//order4 -> same name as order2 but different customer
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0123456789";
		customerNames[orderCount] = "Nuwan";
		quantities[orderCount] = 4;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 4*BURGERPRICE;
		orderCount++;
		
		//order5
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0701234567";
		customerNames[orderCount] = "Shehara";
		quantities[orderCount] = 1;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 1*BURGERPRICE;
		orderCount++;
		
		//order6
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0771000001";
		customerNames[orderCount] = "Alex";
		quantities[orderCount] = 2;
		orderStatus[orderCount] = DELIVERED;
		totals[orderCount] = 2*BURGERPRICE;
		orderCount++;

		//order7
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0771000002";
		customerNames[orderCount] = "Sandila";
		quantities[orderCount] = 6;
		orderStatus[orderCount] = CANCEL;
		totals[orderCount] = 6*BURGERPRICE;
		orderCount++;

		//order8 (same customer as order6)
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0771000002";
		customerNames[orderCount] = "Dineth";
		quantities[orderCount] = 1;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 1*BURGERPRICE;
		orderCount++;

		//order9
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0712345678";
		customerNames[orderCount] = "Kalana";
		quantities[orderCount] = 4;
		orderStatus[orderCount] = DELIVERED;
		totals[orderCount] = 4*BURGERPRICE;
		orderCount++;

		//order10
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0723456789";
		customerNames[orderCount] = "Thisal";
		quantities[orderCount] = 7;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 7*BURGERPRICE;
		orderCount++;

		//order11
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0789999999";
		customerNames[orderCount] = "Niroth";
		quantities[orderCount] = 3;
		orderStatus[orderCount] = CANCEL;
		totals[orderCount] = 3*BURGERPRICE;
		orderCount++;

		//order12 -> same name but different customer ID
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0708888888";
		customerNames[orderCount] = "Niroth";
		quantities[orderCount] = 5;
		orderStatus[orderCount] = PREPARING;
		totals[orderCount] = 5*BURGERPRICE;
		orderCount++;

		//order13
		orderIDs[orderCount] = generateID();
		customerIDs[orderCount] = "0755555555";
		customerNames[orderCount] = "Muli";
		quantities[orderCount] = 2;
		orderStatus[orderCount] = DELIVERED;
		totals[orderCount] = 2*BURGERPRICE;
		orderCount++;
		
		homePage();
	}
	
	public static void homePage() {
		while (true) {
			clearConsole();
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println("   |                      iHungry Burger                      |  ");
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println();
			System.out.println("       [1] Place Order          [2] Search Best Customer   ");
			System.out.println("       [3] Search Order         [4] Search Customer        ");
			System.out.println("       [5] View Order           [6] Update Order Details   ");
			System.out.println("       [7] Exit   ");
			System.out.println();
			while (true){
				System.out.print("      Enter an option to continue > ");
				int op = input.nextInt();
				
				if (op == 1){
					placeOrderPage();
					break;
				}else if (op == 2){
					searchBestCustomerPage();
					break;
				}else if (op == 3){
					searchOrderPage();
					break;
				}else if (op == 4){
					searchCustomerPage();
					break;
				}else if (op == 5){
					viewOrdersPage();
					break;
				}else if (op == 6){
					updateOrderDetailsPage();
					break;
				}else if (op == 7){
					exit();
				}else {
					System.out.println("      Wrong Option...");
				}
			}
		}
	}
	
	public static void placeOrderPage(){
		while (true){
			clearConsole();
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println("   |                        PLACE ORDER                       |  ");
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println();
			
			//orderId section
			String orderID = generateID();
			System.out.println("        ORDER ID - "+orderID);
			System.out.println("        ================");
			System.out.println("\n");
			
			//customerId section
			String customerID = "";
			while(true){				
				System.out.print("        Enter Customer ID (phone no.): ");
				customerID = input.next();
				
				if (isValidCustomerID(customerID)){
					break;
				}
				
				System.out.println("           Invalid Phone number...");
			}
			
			//customerName section
			String customerName = "";
			int index = indexOf(customerID, customerIDs);
			//System.out.println(indexOf(customerID, customerIDs));
			if (index == -1){
				System.out.print("        Customer Name                 : ");
				input.nextLine();
				customerName = input.nextLine();
			}else {
				System.out.println("        Customer Name                 : "+customerNames[index]);
				customerName = customerNames[index]; // other wise this gonna store blank name;
			}
			
			//quantity section
			int quantity = 0;
			while(true){
				System.out.print("        Enter Burger Quantity         : ");
				quantity = input.nextInt();
				if (quantity>0){
					break;
				}
				System.out.println("           Quantity must be > 0...");
			}
			
			//end
			double total = quantity * BURGERPRICE;
			System.out.printf("        Total value                   : %.2f%n",total);
			
			System.out.print("                Are you confirm order - ");
			char op1 = input.next().toLowerCase().charAt(0);
			
			if (op1 == 'y'){
				//adding to the system;
				orderIDs[orderCount] = orderID;
				customerIDs[orderCount] = customerID;
				customerNames[orderCount] = customerName;
				quantities[orderCount] = quantity;
				orderStatus[orderCount] = PREPARING;
				totals[orderCount] = total;
				
				orderCount++;
				System.out.println("\n                Your order is enter to the system successfully...\n");
				
				System.out.print("        Do you want to place another order - ");
				char op2 = input.next().toLowerCase().charAt(0);
				if (op2 == 'n'){
					return;
				}
			}else if (op1 == 'n'){
				idCount--;
				return;
			}
		}
	}
	
	public static void searchBestCustomerPage(){
		while (true){
			clearConsole();
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println("   |                       BEST CUSTOMER                      |  ");
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println();
			System.out.println("               --------------------------------------");
			System.out.printf("                 %10s   %-12s %9s%n","CustomerID","    Name ","  Total ");
			System.out.println("               --------------------------------------");
			
			//--------- this part gets total of orders of same customer to one...
			int size = 0;
			for (int i = 0; i < orderCount; i++){
				boolean isDuplicate = false;
				for (int j = 0; j < i; j++){
					if (customerIDs[i].equals(customerIDs[j])){
						isDuplicate = true;
						break;
					}
				}
				if (!isDuplicate){					
					size++;
				}
			}
			
			String[] uniqueCustomerIDs = new String[size];
			String[] newNames = new String[size];
			double[] newTotals = new double[size];
			
			int count= 0;
			for (int i = 0; i < orderCount; i++){
				boolean isDuplicate = false;
				for (int j = 0; j < i; j++){
					if (customerIDs[i].equals(customerIDs[j])){
						isDuplicate = true;
						break;
					}
				}
				if (!isDuplicate){					
					uniqueCustomerIDs[count++] = customerIDs[i];
				}
			}
			
			for (int i = 0; i < orderCount; i++){
				for (int j = 0; j < size; j++){
					if (customerIDs[i].equals(uniqueCustomerIDs[j])){
						newNames[j] = customerNames[i];
						newTotals[j] += totals[i];
					}
				}
			}
			
			//System.out.println("unique: "+Arrays.toString(uniqueCustomerIDs));
			//System.out.println("newnames: "+Arrays.toString(newNames));
			//System.out.println("new totals: "+Arrays.toString(newTotals));
			
			//--------- below part's going to sort this;
			for (int i = 0; i < size-1; i++){
				for (int j = 0; j < size-i-1; j++){
					if (newTotals[j]<newTotals[j+1]){
						double tmp = newTotals[j];
						newTotals[j] = newTotals[j+1];
						newTotals[j+1] = tmp;
						
						String tmp2 = newNames[j];
						newNames[j] = newNames[j+1];
						newNames[j+1] = tmp2;
						
						String tmp3 = uniqueCustomerIDs[j];
						uniqueCustomerIDs[j] = uniqueCustomerIDs[j+1];
						uniqueCustomerIDs[j+1] = tmp3;
					}
				}
			}
			
			for (int i = 0; i < size; i++){				
				delay(70); // i made this and used becase is adds animation to thee app
				System.out.printf("                 %10s   %-12s %9.2f%n",uniqueCustomerIDs[i],newNames[i],newTotals[i]);
				System.out.println("               --------------------------------------");
			}
			
			System.out.print("\n            Do you want to go back to main menu? (y/n)");
			char op = input.next().toLowerCase().charAt(0);
			if (op=='y'){
				return;
			}
		}
	}
	
	public static void searchOrderPage(){
		while (true){
			clearConsole();
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println("   |                  SERACH ORDER DETAILS                    |  ");
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println();
			System.out.print("     Enter order Id - ");
			String orderId = input.next();
			
			int index = indexOf(orderId, orderIDs);
			
			if (index == -1){
				System.out.print("\n\n\n     Invalid Order ID. Do you want to enter again? (y/n)> ");
				char op = input.next().toLowerCase().charAt(0);
				if (op=='y'){
					continue;
				}else if(op == 'n') {
					return;
				}
			}
			
			String status = "";
			if (orderStatus[index] == PREPARING){
				status = "Preparing";
			}else if (orderStatus[index] == DELIVERED){
				status = "Delivered";
			}else if (orderStatus[index] == CANCEL){
				status = "Cancel";
			}
			
			System.out.printf("\n ---------------------------------------------------------------  %n");
			System.out.printf(" | OrderID   CustomerID   Name      Quantity  Value   Status   |  %n");
			System.out.printf(" ---------------------------------------------------------------  %n");
			System.out.printf(" | %-8s  %10s   %-12s %2d    %7.2f %-10s|  %n", orderIDs[index], customerIDs[index], customerNames[index], quantities[index], totals[index], status);
			System.out.printf(" ---------------------------------------------------------------  %n");
			
			System.out.print("\n\n   Do you want to search anotehr order details (y/n): ");
			char op = input.next().toLowerCase().charAt(0);
			if (op == 'n'){
				return;
			}
		}
	}
	
	//Todo: day2
	public static void searchCustomerPage() {
		while (true){
			clearConsole();
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println("   |                SERACH CUSTOMER DETAILS                   |  ");
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println();
						
			String customerID = "";
			while(true){				
				System.out.print("     Enter Customer Id - ");
				customerID = input.next();
				
				if (isValidCustomerID(customerID)){
					break;
				}
				
				System.out.println("           Invalid Phone number...");
			}
			
			int index = indexOf(customerID, customerIDs);
			if (index == -1){
				System.out.println("\n\n          This customer ID is not added yet....");
				
				System.out.print("     Do you want to serach another cusotmer details (y/n): ");
				char op = input.next().toLowerCase().charAt(0);
				if (op == 'n'){
					return;
				}else if(op == 'y') {
					continue;
				}
			}
			
			System.out.println("\n");
			printCustomerDetails(index);
			
			System.out.print("\n\n     Do you want to serach another cusotmer details (y/n): ");
			char op = input.next().toLowerCase().charAt(0);
			if (op == 'n'){
				return;
			}else if(op == 'y') {
				continue;
			}
		}
	}
	
	public static void viewOrdersPage() {
		while (true){
			clearConsole();
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println("   |                     VIEW ORDER LIST                      |  ");
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println();
			System.out.println("         [1] Delivered Order  ");
			System.out.println("         [2] Preparting Order  ");
			System.out.println("         [3] Cancel Order  ");
			System.out.println("         [4] Exit  ");
			System.out.println();
			
			while (true){
				System.out.print("         Enter an option to continue > ");
				int op = input.nextInt();
				
				if (op == 1){
					if(deliveredOrdersPage()){
						return;
					}else {
						break;
					}
				}else if (op == 2){
					if(preparingOrdersPage()){
						return;
					}else {
						break;
					}
				}else if (op == 3){
					if(cancelOrdersPage()){
						return;
					}else {
						break;
					}
				}else if (op == 4){
					return;
				}else {
					System.out.println("           Wrong Option...");
				}
			}
		}
	}
	
	public static boolean deliveredOrdersPage() {
		clearConsole();
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println("   |                     DELIVERED ORDER                      |  ");
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println();
		
		int size = 0;
		for (int i = 0; i < orderCount; i++){
			if (orderStatus[i] == DELIVERED){
				size++;
			}
		}
		
		String[] d_orderIDs = new String[size];
		String[] d_customerIDs = new String[size];
		String[] d_names = new String[size];
		int[] d_quantities = new int[size];
		double[] d_values = new double[size];
		
		int count = 0;
		for (int i = 0; i < orderCount; i++){
			if (orderStatus[i] == DELIVERED){
				d_orderIDs[count] = orderIDs[i];
				d_customerIDs[count] = customerIDs[i];
				d_names[count] = customerNames[i];
				d_quantities[count] = quantities[i];
				d_values[count] = totals[i];
				count++;
			}
		}
		
		printOrderDetails(d_orderIDs, d_customerIDs, d_names, d_quantities, d_values);
		
		System.out.print("\n   Do you want to go to home page (y/n): ");
		char op = input.next().toLowerCase().charAt(0);
		if (op == 'y'){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean preparingOrdersPage() {
		clearConsole();
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println("   |                     PREPARING ORDER                      |  ");
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println();
		
		int size = 0;
		for (int i = 0; i < orderCount; i++){
			if (orderStatus[i] == PREPARING){
				size++;
			}
		}
		
		String[] p_orderIDs = new String[size];
		String[] p_customerIDs = new String[size];
		String[] p_names = new String[size];
		int[] p_quantities = new int[size];
		double[] p_values = new double[size];
		
		int count = 0;
		for (int i = 0; i < orderCount; i++){
			if (orderStatus[i] == PREPARING){
				p_orderIDs[count] = orderIDs[i];
				p_customerIDs[count] = customerIDs[i];
				p_names[count] = customerNames[i];
				p_quantities[count] = quantities[i];
				p_values[count] = totals[i];
				count++;
			}
		}
		
		printOrderDetails(p_orderIDs, p_customerIDs, p_names, p_quantities, p_values);
		
		System.out.print("\n   Do you want to go to home page (y/n): ");
		char op = input.next().toLowerCase().charAt(0);
		if (op == 'y'){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean cancelOrdersPage() {
		clearConsole();
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println("   |                      CANCEL ORDER                        |  ");
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println();
		
		int size = 0;
		for (int i = 0; i < orderCount; i++){
			if (orderStatus[i] == CANCEL){
				size++;
			}
		}
		
		String[] c_orderIDs = new String[size];
		String[] c_customerIDs = new String[size];
		String[] c_names = new String[size];
		int[] c_quantities = new int[size];
		double[] c_values = new double[size];
		
		int count = 0;
		for (int i = 0; i < orderCount; i++){
			if (orderStatus[i] == CANCEL){
				c_orderIDs[count] = orderIDs[i];
				c_customerIDs[count] = customerIDs[i];
				c_names[count] = customerNames[i];
				c_quantities[count] = quantities[i];
				c_values[count] = totals[i];
				count++;
			}
		}
		
		printOrderDetails(c_orderIDs, c_customerIDs, c_names, c_quantities, c_values);
		
		System.out.print("\n   Do you want to go to home page (y/n): ");
		char op = input.next().toLowerCase().charAt(0);
		if (op == 'y'){
			return true;
		}else{
			return false;
		}
	}
	
	public static void updateOrderDetailsPage() {
		while (true){
			clearConsole();
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println("   |                   UPDATE ORDER DETAILS                   |  ");
			System.out.println("   ------------------------------------------------------------  ");
			System.out.println();
			
			System.out.print("     Enter order Id - ");
			String orderId = input.next();
			
			int index = indexOf(orderId, orderIDs);
			
			if (index == -1){
				System.out.print("\n\n\n     Invalid Order ID. Do you want to enter again? (y/n)> ");
				char op = input.next().toLowerCase().charAt(0);
				if (op=='y'){
					continue;
				}else if(op == 'n') {
					return;
				}
			}
			
			if (orderStatus[index] != PREPARING){
				if (orderStatus[index] == DELIVERED){
					System.out.println("\n     This Order is already deliverd... You an not update this order... ");
				}else if(orderStatus[index] == CANCEL) {
					System.out.println("\n     This Order is already cancelled... You an not update this order... ");
				}
				
				System.out.print("\n\n     Do you want to update another order details (y/n): ");
				char op = input.next().toLowerCase().charAt(0);
				
				if (op == 'y'){
					continue;
				}else if (op =='n') {
					return;
				}
			}
			
			String status = "";
			if (orderStatus[index] == PREPARING){
				status = "Preparing";
			}else if (orderStatus[index] == DELIVERED){
				status = "Delivered";
			}else if (orderStatus[index] == CANCEL){
				status = "Cancel";
			}

			
			//displaying current detials;
			System.out.println("\n     OrderID     - "+orderIDs[index]);
			System.out.println("     CustomerID  - "+customerIDs[index]);
			System.out.println("     Name        - "+customerNames[index]);
			System.out.println("     Quantity    - "+quantities[index]);
			System.out.println("     OrderValue  - "+totals[index]);
			System.out.println("     OrderStatus - "+status);
			System.out.println();
			System.out.println("     What do you want to update ?");
			System.out.println("               (1) Quantity");
			System.out.println("               (2) Status");
			System.out.print("\n     Enter your option - ");
			int op = input.nextInt();
			
			if (op==1){
				if (quantityUpdatePage(index)) return;
			}else if(op==2){
				if (statusUpdatePage(index)) return;
			}
		}
	}
	
	public static boolean quantityUpdatePage(int index) {
		clearConsole();
		System.out.println("     Quantity Update");
		System.out.println("     ===============");
		System.out.println();
		System.out.println("     OrderId    - "+orderIDs[index]);
		System.out.println("     CustomerID - "+customerIDs[index]);
		System.out.println("     Name       - "+customerNames[index]);
		System.out.println();
		
		int quantity = 0;
		while(true){
			System.out.print("     Enter your quantity update value - ");
			quantity = input.nextInt();
			if (quantity>0){
				break;
			}
			System.out.println("          Quantity must be > 0...");
		}
		
		//updating values
		quantities[index] = quantity;
		totals[index] = BURGERPRICE * quantity;
		System.out.println("\n          update order quantity successfully.... \n");
		
		System.out.println("     new Order quantity - "+quantities[index]);
		System.out.printf("     new Order value - %.2f%n",totals[index]);
		
		System.out.print("\n\n     Do you want to update another order details (y/n): ");
		char op = input.next().toLowerCase().charAt(0);
		
		if (op == 'n'){
			return true;
		}
		
		return false;
	}
	
	public static boolean statusUpdatePage(int index) {
		clearConsole();
		System.out.println("     Status Update");
		System.out.println("     =============");
		System.out.println();
		System.out.println("     OrderId    - "+orderIDs[index]);
		System.out.println("     CustomerID - "+customerIDs[index]);
		System.out.println("     Name       - "+customerNames[index]);
		System.out.println();
		System.out.println("\n          (0) Preparing");
		System.out.println("          (1) Delivered");
		System.out.println("          (2) Cancel");
		System.out.println();
		
		int status;
		while (true){
			System.out.print("     Enter new order status - ");
			status = input.nextInt();
			
			if (status == PREPARING || status == DELIVERED || status == CANCEL){
				break;
			}
			System.out.println("          invalid........");
		}
		
		//updating
		orderStatus[index] = status;
		System.out.println("\n          Update order stataus successfully....\n");
				
		System.out.println("     new order status - "+orderStatus[index]);
		
		System.out.print("\n\n     Do you want to update another order details (y/n): ");
		char op = input.next().toLowerCase().charAt(0);
		
		if (op == 'n'){
			return true;
		}
		
		return false;
	}
	
	//other
	public static void printOrderDetails(String[] orderIDs, String[] customerIDs, String[] names, int[] quantities, double[] values) {
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println("    OrderID    CustomerID    Name        Quantity   OrderValue ");
		System.out.println("   ------------------------------------------------------------  ");
		
		for (int i = 0; i < orderIDs.length; i++){
			System.out.printf("      %5s     %10s   %-12s %3d %13.2f %n",orderIDs[i], customerIDs[i], names[i], quantities[i], values[i]);
			System.out.println("   ------------------------------------------------------------  ");
		}		
	}
	
	public static void printCustomerDetails(int index) {
		System.out.println("          CustomerID - "+customerIDs[index]);
		System.out.println("          Name       - "+customerNames[index]);
		System.out.println();
		System.out.println("          Customer Order Details");
		System.out.println("          ======================\n");
		
		int size = 0;
		for (int i = 0; i < orderCount; i++){
			if (customerIDs[i].equals(customerIDs[index])){
				size++;
			}
		}
		
		String[] customerOrderIDs = new String[size];
		int[] customerOrderQuantities = new int[size];
		double[] customerTotalsValues = new double[size];
		
		int count = 0;
		for (int i = 0; i < orderCount; i++){
			if (customerIDs[index].equals(customerIDs[i])){
				customerOrderIDs[count] = orderIDs[i];
				customerOrderQuantities[count] = quantities[i];
				customerTotalsValues[count] = totals[i];
				count++;
			}
		}
		
		System.out.println("          -----------------------------------------");
		System.out.println("           Order_ID   Order_Quantity   Total_Value ");
		System.out.println("          -----------------------------------------");
		
		for (int i = 0; i < customerOrderIDs.length; i++){
			System.out.printf("            %5s          %-2d        %11.2f   %n",customerOrderIDs[i], customerOrderQuantities[i], customerTotalsValues[i]);			
		}
		
		System.out.println("          -----------------------------------------");
	}
	
	public static boolean isValidCustomerID(String customerID) {
		return customerID.charAt(0) == '0' && customerID.length() == 10;
	}
	
	public static void delay(int t){ // from niroth sir...
		try{Thread.sleep(t);}catch (Exception ex){}
	}
	
	// this method return -1 if not found, if found it's index;
	public static int indexOf(String value, String[] arr){
		for (int i = 0; i <= orderCount; i++){
			if (value.equals(arr[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static int indexOf(int value, int[] arr){
		for (int i = 0; i <= orderCount; i++){
			if (value == arr[i]){
				return i;
			}
		}
		return -1;
	}
	
	public static String generateID(){
		String num = "" + idCount;
		while (num.length() < 4){
			num = "0" + num;
		}
		idCount++;
		return "B"+num;
	}
	
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

	public static void exit(){
		clearConsole();
		System.out.println("\n\t\tYou left the program...\n");
		System.exit(0);
	}
}
