package org.accenture.indx.sessions.swdesign.challange1.fp.v2;


import org.accenture.indx.sessions.swdesign.challange1.fp.model.Order;

public class OrderReportWrapper {
    public OrderReportWrapper(StringBuilder stringBuilder, Order order) {
        this.stringBuilder = stringBuilder;
        this.order = order;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public Order getOrder() {
        return order;
    }

    private StringBuilder stringBuilder;
    private Order order;
}
