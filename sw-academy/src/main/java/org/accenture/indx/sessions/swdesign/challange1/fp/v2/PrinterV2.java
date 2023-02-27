package org.accenture.indx.sessions.swdesign.challange1.fp.v2;

import org.accenture.indx.sessions.swdesign.challange1.fp.model.Order;
import org.accenture.indx.sessions.swdesign.challange1.fp.service.OrderService;

import java.util.Collection;
import java.util.function.Consumer;

public enum PrinterV2 {
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

    PrinterV2(Consumer<Collection<Order>> printer) {
        this.printer = printer;
    }

    private static final Consumer<Order> summaryPrinter = order -> System.out.println(order.getId() + " - " + order.getTotal());
    private static final Consumer<Order> detailedPrinter = PrinterV2::detailedPrinterBuilder;

    private static void detailedPrinterBuilder(Order order) {
        System.out.println(
                OrderReportBuilderV2.buildOrderIdAndDate
                        .andThen(OrderReportBuilderV2.buildOrderNameAndCost)
                        .andThen(OrderReportBuilderV2.buildOrderTotalCost)
                        .apply(new OrderReportWrapper(new StringBuilder(), order)).getStringBuilder()
        );
        System.out.println("----------------------------------------");
    }

}
