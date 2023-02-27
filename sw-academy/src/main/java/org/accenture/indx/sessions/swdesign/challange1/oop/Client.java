package org.accenture.indx.sessions.swdesign.challange1.oop;

import org.accenture.indx.sessions.swdesign.challange1.oop.model.Order;
import org.accenture.indx.sessions.swdesign.challange1.oop.order.printer.strategy.DetailPrinter;
import org.accenture.indx.sessions.swdesign.challange1.oop.service.PrintService;

import java.util.LinkedList;

public class Client {

    private static LinkedList<Order> orders = new LinkedList<>();

    public static void main(String[] args) {
        createOrders();
        //print all orders
        PrintService service = new PrintService(new DetailPrinter());
        service.printOrders(orders);
        
    }

    private static void createOrders() {
        Order o = new Order("100");
        o.addItem("Beer", 2);
        o.addItem("Chips", 10);
        orders.add(o);

        o = new Order("200");
        o.addItem("Baklava", 20);
        o.addItem("Cookies", 5);
        orders.add(o);

        o = new Order("300");
        o.addItem("Burger", 8);
        o.addItem("Fries", 5);
        orders.add(o);
    }
}
