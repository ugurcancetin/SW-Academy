package org.accenture.indx.sessions.swdesign.challange1.oop.order.printer;

import org.accenture.indx.sessions.swdesign.challange1.oop.model.Order;

import java.util.Collection;

//Strategy
public interface OrderPrinter {
	
	void print(Collection<Order> orders);
}
