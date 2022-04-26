package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
      
        
		System.out.println("Enter the cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY) ");
		String date = sc.nextLine();
		LocalDate birthDate = LocalDate.parse(date, dtf);
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("");
		System.out.println("Enter the order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);
		
		for (int i = 0; i<n; i++) {
			System.out.println("");
			System.out.println("Enter #"+ (i+1) + " item data");
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			Double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("");
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());


		sc.close();
	}

}
