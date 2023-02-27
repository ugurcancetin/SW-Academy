package org.accenture.indx.sessions.swdesign.challange1.fp.v3;

import org.accenture.indx.sessions.swdesign.challange1.fp.model.Order;
import org.accenture.indx.sessions.swdesign.challange1.fp.service.OrderService;
import org.accenture.indx.sessions.swdesign.challange1.fp.v2.OrderReportBuilderV2;
import org.accenture.indx.sessions.swdesign.challange1.fp.v2.OrderReportWrapper;

import java.util.Collection;

public enum PrinterV3 {
    SUMMARY{
        public StringBuilder execute(Collection<Order> orders){
            return new StringBuilder();
        }
    },
    DETAILED {
        public StringBuilder execute(Collection<Order> orders) {
            StringBuilder orderReportSB = new StringBuilder();
            return orders
                    .stream()
                    .map(order -> OrderReportBuilderV2.buildOrderIdAndDate
                            .andThen(OrderReportBuilderV2.buildOrderNameAndCost)
                            .andThen(OrderReportBuilderV2.buildOrderTotalCost)
                            .apply(new OrderReportWrapper(new StringBuilder(), order)).getStringBuilder())
                    .reduce((stringBuilder, stringBuilder2) -> stringBuilder2.append(stringBuilder)).orElseThrow()
                    .append("\n\n GrandTotal: ")
                    .append(OrderService.getGrandTotalCost.apply(orders).orElse(-1.0));

        }
    };

    public abstract StringBuilder execute(Collection<Order> orders);
}
