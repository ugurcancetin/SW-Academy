package org.accenture.indx.sessions.swdesign.challange1.fp.v2;

import org.accenture.indx.sessions.swdesign.challange1.fp.service.OrderService;

import java.util.function.Function;

public class OrderReportBuilderV2 {

    public static final Function<OrderReportWrapper, OrderReportWrapper> buildOrderIdAndDate =
            orderReportWrapper -> {
                orderReportWrapper.getStringBuilder()
                        .append("'\n")
                        .append(orderReportWrapper.getOrder().getId())
                        .append("\t")
                        .append(orderReportWrapper.getOrder().getDate())
                        .append("\n");
                return orderReportWrapper;
            };

    public static final Function<OrderReportWrapper, OrderReportWrapper> buildOrderNameAndCost =
            orderReportWrapper -> {
                orderReportWrapper.getOrder().getItems()
                        .forEach((k, v) -> orderReportWrapper.getStringBuilder()
                                .append("\t")
                                .append(k)
                                .append("\t")
                                .append(v)
                                .append("\n"));
                return orderReportWrapper;
            };

    public static final Function<OrderReportWrapper, OrderReportWrapper> buildOrderTotalCost =
            orderReportWrapper -> {
                orderReportWrapper.getStringBuilder().append("\n\t\t Total  ").append(OrderService.getTotalCost.apply(orderReportWrapper.getOrder()));
                return orderReportWrapper;
            };
}
