package org.accenture.indx.sessions.swdesign.challange1.oop.service;

import org.accenture.indx.sessions.swdesign.challange1.oop.model.Order;
import org.accenture.indx.sessions.swdesign.challange1.oop.order.printer.OrderPrinter;

import java.util.LinkedList;

//Context 
public class PrintService {

	private OrderPrinter printer;
	
    public PrintService(OrderPrinter printer) {
    	this.printer = printer;
    }

    public void printOrders(LinkedList<Order> orders) {
        printer.print(orders);
    }
}
