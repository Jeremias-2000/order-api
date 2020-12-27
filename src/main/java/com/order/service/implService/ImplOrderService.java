package com.order.service.implService;

import com.order.document.Order;
import com.order.repository.OrderRepository;

import com.order.service.OrderService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;



import static org.springframework.data.crossstore.ChangeSetPersister.*;


@Service
public class ImplOrderService implements OrderService<Order> {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ImplUserService implUserService;

    public ImplOrderService(OrderRepository orderRepository, ImplUserService implUserService) {
        this.orderRepository = orderRepository;
        this.implUserService = implUserService;
    }


    public Page<Order> findAllOrders(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findAll(pageable);

    }

    @SneakyThrows
    public Order findById(String orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(()
                -> new NotFoundException());
    }




    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order o) {
        return null;
    }

    public void deleteOrder(String orderId) {
       orderRepository.deleteById(orderId);
    }
}
