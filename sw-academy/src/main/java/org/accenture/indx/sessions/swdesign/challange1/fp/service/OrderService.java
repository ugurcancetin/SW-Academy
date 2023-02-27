package org.accenture.indx.sessions.swdesign.challange1.fp.service;

import org.accenture.indx.sessions.swdesign.challange1.fp.model.Order;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

public class OrderService {

    public static Function<Order, Double> getTotalCost = order -> order.getItems().values()
            .stream()
            .reduce(0.0, Double::sum);
    public static Function<Collection<Order>, Optional<Double>> getGrandTotalCost = orders -> orders.stream()
            .map(order -> getTotalCost.apply(order))
            .reduce(Double::sum);
}
