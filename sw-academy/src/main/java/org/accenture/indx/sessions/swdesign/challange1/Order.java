package org.accenture.indx.sessions.swdesign.challange1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Order {

    private String id;

    private LocalDate date;

    private Map<String, Double> items = new HashMap<>();

    private double total;
}
