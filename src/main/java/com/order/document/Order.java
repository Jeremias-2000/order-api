package com.order.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "orders")

public class Order {
    @Id
    private String orderId;
    private User user;
    private List<Product> products;

    public Order(String orderId, User user, List<Product> products) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
    }
}
