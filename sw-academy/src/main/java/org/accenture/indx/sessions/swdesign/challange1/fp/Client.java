package org.accenture.indx.sessions.swdesign.challange1.fp;

import org.accenture.indx.sessions.swdesign.challange1.fp.model.Order;
import org.accenture.indx.sessions.swdesign.challange1.fp.v1.Printer;
import org.accenture.indx.sessions.swdesign.challange1.fp.v2.PrinterV2;
import org.accenture.indx.sessions.swdesign.challange1.fp.v3.PrinterV3;

import java.util.LinkedList;


public class Client {

    private static final LinkedList<Order> orders = new LinkedList<>();

    public static void main(String[] args) {
        createOrders();

        //V1
        Printer.SUMMARY.printer.accept(orders);
        Printer.DETAILED.printer.accept(orders);

        //V2
        PrinterV2.SUMMARY.printer.accept(orders);
        PrinterV2.DETAILED.printer.accept(orders);

        //V3
        System.out.println(PrinterV3.SUMMARY.execute(orders));
        System.out.println(PrinterV3.DETAILED.execute(orders));
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
