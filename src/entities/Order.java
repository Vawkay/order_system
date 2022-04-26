package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus orderStatus;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	

	
	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus orderStatus, Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem i : items) {
			sum += i.subTotal();
					
		}
		return sum;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("Order Moment: ");
		sb.append(moment.format(formatter) + "\n");
		sb.append("Order Status: ");
		sb.append(orderStatus + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order Items: \n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total Price: $");
		sb.append(String.format("%.2f", total()));

		return sb.toString();		
	}
	
	
}
