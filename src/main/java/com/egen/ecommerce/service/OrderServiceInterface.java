package com.egen.ecommerce.service;

import com.egen.ecommerce.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderServiceInterface {

    String getOrderStatus(String id);

    Order getOrderByID(String id);

    String cancelOrderByID(String id);

    Order createOrder(Order order);

    String deleteOrder(String id);

    List<Order> getAllOrders();
}
