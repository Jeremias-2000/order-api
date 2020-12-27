package com.order.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService<O> {
    Page<O> findAllOrders(int page,int size);
    O findById(String o);
    O save(O o);
    O update(O o);
    void deleteOrder(String o);
}
