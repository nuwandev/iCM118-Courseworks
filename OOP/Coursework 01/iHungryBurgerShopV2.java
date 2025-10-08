import java.util.*;
class Order{
	public static final double BURGERPRICE=500;
	public static final int PENDING=0;
	public static final int PREPARING=1;
	public static final int DELIVERED=2;
	public static final int CANCELLED=3;
	
    private String orderID;
    private String customerID;
    private String customerName;
    private int quantity;
    private double totalPrice;
    private int orderStatus;
	
	public Order(String orderID, String customerID, String customerName, int quantity) {
		this.orderID = orderID;
		this.customerID = customerID;
		this.customerName = customerName;
		this.quantity = quantity;
		this.totalPrice = this.quantity * BURGERPRICE;
		this.orderStatus = PENDING;
	}
	
	//getters
	public String getOrderID() {return this.orderID;}
	public String getCustomerID() {return this.customerID;}
	public String getCustomerName() {return this.customerName;}
	public int getQuantity() {return this.quantity;}
	public double getTotalPrice() {return this.totalPrice;}
	public int getOrderStatus() {return this.orderStatus;}
	
	// setters
	public void setOrderID(String id) {this.orderID = id;}
	public void setCustomerID(String id) {this.customerID = id;}
	public void setCustomerName(String name) {this.customerName = name;}
	public void setQuantity(int qty) {this.quantity = qty;}
	public void setTotalPrice(double tot) {this.totalPrice = tot;}
	public void setOrderStatus(int status) {this.orderStatus = status;}
}

class iHungryBurgerShopV2{
	public static Order[] orderList = new Order[0];
	public static Scanner input = new Scanner(System.in);
	public static int orderCount = 1;
	
	public static void main(String[] args) {
		createOrder(generateID(), "0705028061", "Theekshana", 5);
		createOrder(generateID(), "0705028061", "Theekshana", 2);
		createOrder(generateID(), "0705028066", "Nuwan", 3);
		createOrder(generateID(), "0705028062", "Shehara", 4);
		
		homePage();
	}
	
	// pages
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
			
			String orderID = generateID();
			System.out.println("        ORDER ID - "+orderID);
			System.out.println("        ================");
			System.out.println("\n");
			
			String customerID = "";
			while(true){				
				System.out.print("        Enter Customer ID (phone no.): ");
				customerID = input.next();
				
				if (isValidCustomerID(customerID)){
					break;
				}
				
				System.out.println("           Invalid Phone number...");
			}
			
			String customerName = "";
			int index = indexOf(customerID, "customerID");
			if (index == -1){
				System.out.print("        Customer Name                 : ");
				input.nextLine();
				customerName = input.nextLine();
			}else {
				System.out.println("        Customer Name                 : "+orderList[index].getCustomerName());
				customerName = orderList[index].getCustomerName();
			}
			
			int quantity = 0;
			while(true){
				System.out.print("        Enter Burger Quantity         : ");
				quantity = input.nextInt();
				if (quantity>0){
					break;
				}
				System.out.println("           Quantity must be > 0...");
			}
			
			double total = quantity * Order.BURGERPRICE;
			System.out.printf("        Total value                   : %.2f%n",total);
			
			System.out.print("                Are you confirm order - ");
			char op1 = input.next().toLowerCase().charAt(0);
			
			if (op1 == 'y'){
				createOrder(orderID, customerID, customerName, quantity);
				
				System.out.println("\n                Your order is enter to the system successfully...\n");
				
				System.out.print("        Do you want to place another order - ");
				char op2 = input.next().toLowerCase().charAt(0);
				if (op2 == 'n'){
					return;
				}
			}else if (op1 == 'n'){
				orderCount--;
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
			
			int size = 0;
			for (int i = 0; i < orderList.length; i++){
				boolean isDuplicate = false;
				for (int j = 0; j < i; j++){
					if (orderList[i].getCustomerID().equals(orderList[j].getCustomerID())){
						isDuplicate = true;
						break;
					}
				}
				if (!isDuplicate){					
					size++;
				}
			}
			
			Order[] bestCustomers = new Order[size];
			
			int count= 0;
			for (int i = 0; i < orderList.length; i++){
				boolean isDuplicate = false;
				for (int j = 0; j < i; j++){
					if (orderList[i].getCustomerID().equals(orderList[j].getCustomerID())){
						isDuplicate = true;
						break;
					}
				}
				if (!isDuplicate){					
					bestCustomers[count++] = orderList[i];
				}
			}
			
			for (int i = 0; i < size; i++){
				double sum = 0;
				for (int j = 0; j < orderList.length; j++){
					if (orderList[j].getCustomerID().equals(bestCustomers[i].getCustomerID())){
						sum += orderList[j].getTotalPrice();
					}
				}
				bestCustomers[i].setTotalPrice(sum);
			}
			
			
			for (int i = 1; i < size; i++){
				for (int j = 0; j < i; j++){
					if (bestCustomers[i].getTotalPrice() > bestCustomers[j].getTotalPrice()){
						Order tmp = bestCustomers[i];
						bestCustomers[i] = bestCustomers[j];
						bestCustomers[j] = tmp;
					}
				}
			}
			
			for (int i = 0; i < size; i++){				
				delay(70); // for animation
				System.out.printf("                 %10s   %-12s %9.2f%n",bestCustomers[i].getCustomerID(), bestCustomers[i].getCustomerName(), bestCustomers[i].getTotalPrice());
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
			
			int index = indexOf(orderId, "orderID");
			
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
			if (orderList[index].getOrderStatus() == 0){
				status = "Pending";
			}else if (orderList[index].getOrderStatus() == 1){
				status = "Preparing";
			}else if (orderList[index].getOrderStatus() == 2){
				status = "Delivered";
			}else if (orderList[index].getOrderStatus() == 3){
				status = "Canceled";
			}
			
			System.out.printf("\n ---------------------------------------------------------------  %n");
			System.out.printf(" | OrderID   CustomerID   Name      Quantity  Value   Status   |  %n");
			System.out.printf(" ---------------------------------------------------------------  %n");
			System.out.printf(" | %-8s  %10s   %-12s %2d    %7.2f %-10s|  %n", orderList[index].getOrderID(), orderList[index].getCustomerID(), orderList[index].getCustomerName(), orderList[index].getQuantity(), orderList[index].getTotalPrice(), status);
			System.out.printf(" ---------------------------------------------------------------  %n");
			
			System.out.print("\n\n   Do you want to search another order details (y/n): ");
			char op = input.next().toLowerCase().charAt(0);
			if (op == 'n'){
				return;
			}
		}
	}
	
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
			
			int index = indexOf(customerID, "customerID");
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
			System.out.println("         [1] Pending Order  ");
			System.out.println("         [2] Preparing Order  ");
			System.out.println("         [3] Delivered Order  ");
			System.out.println("         [4] Canceled Order  ");
			System.out.println("         [5] Exit  ");
			System.out.println();
			
			while (true){
				System.out.print("         Enter an option to continue > ");
				int op = input.nextInt();
				
				if (op == 1){
					if(ordersPage(Order.PENDING)){
						return;
					}else {
						break;
					}
				}else if (op == 2){
					if(ordersPage(Order.PREPARING)){
						return;
					}else {
						break;
					}
				}else if (op == 3){
					if(ordersPage(Order.DELIVERED)){
						return;
					}else {
						break;
					}
				}else if (op == 4){
					if(ordersPage(Order.CANCELLED)){
						return;
					}else {
						break;
					}
				}else if (op == 5){
					return;
				}else {
					System.out.println("           Wrong Option...");
				}
			}
		}
	}
	
	public static boolean ordersPage(int status) {
		clearConsole();
		
		String statusStr = ""; 
		if (status == Order.PENDING){
			statusStr = "PENDING";
		}else if (status == Order.PREPARING){
			statusStr = "PREPARING";
		}else if (status == Order.DELIVERED){
			statusStr = "DELIVERED";
		}else if (status == Order.CANCELLED){
			statusStr = "CANCELED";
		}
		
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println("   |                     "+statusStr+" ORDER                      |  ");
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println();
		
		int size = 0;
		for (int i = 0; i < orderList.length; i++){
			if (orderList[i].getOrderStatus() == status){
				size++;
			}
		}
		
		Order[] filteredList = new Order[size];
		
		int count = 0;
		for (int i = 0; i < orderList.length; i++){
			if (orderList[i].getOrderStatus() == status){
				filteredList[count++] = orderList[i];
			}
		}
		
		printOrderDetails(filteredList);
		
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
			
			int index = indexOf(orderId, "orderID");
			
			if (index == -1){
				System.out.print("\n\n\n     Invalid Order ID. Do you want to enter again? (y/n)> ");
				char op = input.next().toLowerCase().charAt(0);
				if (op=='y'){
					continue;
				}else if(op == 'n') {
					return;
				}
			}
			
			int orderStatus = orderList[index].getOrderStatus();
			if (orderStatus != Order.PENDING){
				if (orderStatus == Order.PREPARING){
					System.out.println("\n     This Order is already Preparing... You can not update this order... ");
				}else if (orderStatus == Order.DELIVERED){
					System.out.println("\n     This Order is already deliverd... You can not update this order... ");
				}else if(orderStatus == Order.CANCELLED) {
					System.out.println("\n     This Order is already cancelled... You can not update this order... ");
				}
				
				System.out.print("\n\n     Do you want to update another order details (y/n): ");
				char op = input.next().toLowerCase().charAt(0);
				
				if (op == 'y'){
					continue;
				}else if (op =='n') {
					return;
				}
			}
			
			String statusStr = "";
			if (orderStatus == Order.CANCELLED){
				statusStr = "Cancel";
			}else if (orderStatus == Order.PREPARING){
				statusStr = "Preparing";
			}else if (orderStatus == Order.DELIVERED){
				statusStr = "Delivered";
			}else if (orderStatus == Order.PENDING){
				statusStr = "Pending";
			}
			
			System.out.println("\n     OrderID     - "+orderList[index].getOrderID());
			System.out.println("     CustomerID  - "+orderList[index].getCustomerID());
			System.out.println("     Name        - "+orderList[index].getCustomerName());
			System.out.println("     Quantity    - "+orderList[index].getQuantity());
			System.out.println("     OrderValue  - "+orderList[index].getTotalPrice());
			System.out.println("     OrderStatus - "+statusStr);
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
		System.out.println("     OrderId    - "+orderList[index].getOrderID());
		System.out.println("     CustomerID - "+orderList[index].getCustomerID());
		System.out.println("     Name       - "+orderList[index].getCustomerName());
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
		
		orderList[index].setQuantity(quantity);
		orderList[index].setTotalPrice(Order.BURGERPRICE * quantity);
		System.out.println("\n          update order quantity successfully.... \n");
		
		System.out.println("     new Order quantity - "+orderList[index].getQuantity());
		System.out.printf("     new Order value - %.2f%n",orderList[index].getTotalPrice());
		
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
		System.out.println("     OrderId    - "+orderList[index].getOrderID());
		System.out.println("     CustomerID - "+orderList[index].getCustomerID());
		System.out.println("     Name       - "+orderList[index].getCustomerName());
		System.out.println();
		System.out.println("\n          (0) Pending");
		System.out.println("          (1) Preparing");
		System.out.println("          (2) Delivered");
		System.out.println("          (3) Cancelled");
		System.out.println();
		
		int status;
		while (true){
			System.out.print("     Enter new order status - ");
			status = input.nextInt();
			
			if (status == Order.PENDING || status == Order.PREPARING || status == Order.DELIVERED || status == Order.CANCELLED){
				break;
			}
			System.out.println("          invalid........");
		}
		
		orderList[index].setOrderStatus(status);
		System.out.println("\n          Update order stataus successfully....\n");
				
		System.out.println("     new order status - "+orderList[index].getOrderStatus());
		
		System.out.print("\n\n     Do you want to update another order details (y/n): ");
		char op = input.next().toLowerCase().charAt(0);
		
		if (op == 'n'){
			return true;
		}
		
		return false;
	}
	
	// helper methods
	public static void createOrder(String orderID, String customerID, String customerName, int quantity) {
		Order[] newOrderList = new Order[orderList.length + 1];
		for (int i = 0; i < orderList.length; i++){
			newOrderList[i] = orderList[i];
		}
		newOrderList[newOrderList.length-1] = new Order(orderID, customerID, customerName, quantity);
		orderList = newOrderList;
	}	
	
	public static int indexOf(String value, String kind){
		for (int i = 0; i < orderList.length; i++){
			if (kind.equals("orderID")){				
				if (orderList[i].getOrderID().equals(value)){
					return i;
				}
			}else if(kind.equals("customerID")){
				if (orderList[i].getCustomerID().equals(value)){
					return i;
				}				
			}
		}
		return -1;
	}
	
	public static String generateID(){
		String num = "" + orderCount;
		while (num.length() < 4){
			num = "0" + num;
		}
		orderCount++;
		return "B"+num;
	}
	
	// printing suppport
	public static void printCustomerDetails(int index) {
		System.out.println("          CustomerID - "+orderList[index].getCustomerID());
		System.out.println("          Name       - "+orderList[index].getCustomerName());
		System.out.println();
		System.out.println("          Customer Order Details");
		System.out.println("          ======================\n");
		
		int size = 0;
		for (int i = 0; i < orderList.length; i++){
			if (orderList[i].getCustomerID().equals(orderList[index].getCustomerID())){
				size++;
			}
		}
		
		Order[] orders = new Order[size];
		
		int count = 0;
		for (int i = 0; i < orderList.length; i++){
			if (orderList[i].getCustomerID().equals(orderList[index].getCustomerID())){
				orders[count++] = orderList[i];
			}
		}
		
		System.out.println("          -----------------------------------------");
		System.out.println("           Order_ID   Order_Quantity   Total_Value ");
		System.out.println("          -----------------------------------------");
		
		for (int i = 0; i < orders.length; i++){
			System.out.printf("            %5s          %-2d        %11.2f   %n",orders[i].getOrderID(), orders[i].getQuantity(), orders[i].getTotalPrice());			
		}
		
		System.out.println("          -----------------------------------------");
	}
	
	public static void printOrderDetails(Order[] o) {
		System.out.println("   ------------------------------------------------------------  ");
		System.out.println("    OrderID    CustomerID    Name        Quantity   OrderValue ");
		System.out.println("   ------------------------------------------------------------  ");
		
		for (int i = 0; i < o.length; i++){
			System.out.printf("      %5s     %10s   %-12s %3d %13.2f %n",o[i].getOrderID(), o[i].getCustomerID(), o[i].getCustomerName(), o[i].getQuantity(), o[i].getTotalPrice());
			System.out.println("   ------------------------------------------------------------  ");
		}		
	}
	
	// validations
	public static boolean isValidCustomerID(String customerID) {
		return customerID.charAt(0) == '0' && customerID.length() == 10;
	}
	
	//console controlers
	public static void delay(int t){
		try{Thread.sleep(t);}catch (Exception ex){}
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
		}
	}

	public static void exit(){
		clearConsole();
		System.out.println("\n\t\tYou left the program...\n");
		System.exit(0);
	}
}
