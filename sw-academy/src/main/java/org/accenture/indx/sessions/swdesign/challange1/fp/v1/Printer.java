package org.accenture.indx.sessions.swdesign.challange1.fp.v1;

import org.accenture.indx.sessions.swdesign.challange1.fp.model.Order;
import org.accenture.indx.sessions.swdesign.challange1.fp.service.OrderService;

import java.util.Collection;
import java.util.function.Consumer;

public enum Printer {
    SUMMARY(summaryPrint()),
    DETAILED(detailedPrint());

    private static Consumer<Collection<Order>> detailedPrint() {
        return orders -> {
            orders.forEach(detailedPrinter);
            System.out.println("GrandTotal: " + OrderService.getGrandTotalCost.apply(orders).orElse(-1.0));
        };
    }

    private static Consumer<Collection<Order>> summaryPrint() {
        return orders -> {
            orders.forEach(summaryPrinter);
            System.out.println("GrandTotal: " + OrderService.getGrandTotalCost.apply(orders).orElse(-1.0));
        };
    }

    public final Consumer<Collection<Order>> printer;
    Printer(Consumer<Collection<Order>> printer) {
        this.printer = printer;
    }

    private static final Consumer<Order> summaryPrinter = order -> System.out.println(order.getId() + " - " + order.getTotal());
    private static final Consumer<Order> detailedPrinter = Printer::staticDetailedPrinterBuilder;

    private static void staticDetailedPrinterBuilder(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        var idAndDateAppended = OrderReportBuilder.buildOrderIdAndDate.apply(order, stringBuilder);
        var nameAndCostAppended= OrderReportBuilder.buildOrderNameAndCost.apply(order, idAndDateAppended);
        var totalCostAppended = OrderReportBuilder.buildOrderTotalCost.apply(order, nameAndCostAppended);
        System.out.println(totalCostAppended);
        System.out.println("----------------------------------------");
    }

}
