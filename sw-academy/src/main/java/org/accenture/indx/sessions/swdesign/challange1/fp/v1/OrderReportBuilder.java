package org.accenture.indx.sessions.swdesign.challange1.fp.v1;

import org.accenture.indx.sessions.swdesign.challange1.fp.model.Order;
import org.accenture.indx.sessions.swdesign.challange1.fp.service.OrderService;

import java.util.function.BiFunction;

public class OrderReportBuilder {

    public static final BiFunction<Order, StringBuilder, StringBuilder> buildOrderIdAndDate =
            (order, stringBuilder) -> stringBuilder
                    .append(order.getId())
                    .append("\t")
                    .append(order.getDate())
                    .append("\n");

    public static final BiFunction<Order, StringBuilder, StringBuilder> buildOrderNameAndCost =
            (order, stringBuilder) -> {
                order.getItems()
                        .forEach((k, v) -> stringBuilder
                                .append("\t")
                                .append(k)
                                .append("\t")
                                .append(v)
                                .append("\n"));
                return stringBuilder;
            };

    public static final BiFunction<Order, StringBuilder, StringBuilder> buildOrderTotalCost =
            (order, stringBuilder) -> stringBuilder.append("\n\t\t Total  ").append(OrderService.getTotalCost.apply(order));
}
