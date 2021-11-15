package com.egen.ecommerce.service;

import com.egen.ecommerce.exception.BusinessException;
import com.egen.ecommerce.model.Order;
import com.egen.ecommerce.repo.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@Service
public class OrderService implements OrderServiceInterface {

    @Autowired
   public OrderRepo orderRepo;


    @Override
    public Order createOrder(Order order) {
        log.info("running createOrder in OrderSerive ");
        if (order.getOrderId().isEmpty()    ||
                order.getCustomerId().isEmpty() ||
                order.getPayment().isEmpty()) {

            throw new BusinessException("Cannot create Order, No values entered in one or more fields","702");
        }

        return orderRepo.save(order);
    }

    //    Get Method
    @Override
    public String getOrderStatus(String id) {
        log.info("running getOrderStatus in OrderSerive with id "+id);
        Optional<Order> order = orderRepo.findById(id);

        if (!order.isPresent()){
            throw new BusinessException("No order Found With Give ID","701");
        }

        Order current = order.get();
        char status = current.getOrderStatus();

        Map<Character,String> map = new HashMap<>();
        map.put('o',"Order Created");
        map.put('s',"Shipping");
        map.put('d',"delivered");
        map.put('c',"Order canceled");
        map.put('j',"Junk");

       return map.getOrDefault(status,"Incorrect input: try again with correct Status value");

        }

    //    Get Method
    @Override
    public Order getOrderByID(String id) {
        log.info("running getOrderByID in OrderSerive with id "+id);
        Optional<Order> order = orderRepo.findById(id);



        if (!order.isPresent())
            throw new BusinessException("No order Found With Give ID","701");

        return order.get();
    }

    @Override
    public String cancelOrderByID(String id) {
        log.info("running cancelOrderByID in OrderSerive with id "+id);
        Optional<Order> order = orderRepo.findById(id);

        if (!order.isPresent())
            throw new BusinessException("No order Found With Give ID","701");

        order.get().setOrderStatus('c');

        return new String("order with id"+id+ "cancelled") ;
    }


    @Override
    public String deleteOrder(String id) {
        log.info("running deleteOrder in OrderSerive with id "+id);


        Optional<Order> order = orderRepo.findById(id);

        if (!order.isPresent())
            throw new BusinessException("No order Found With Give ID","701");

        if (order.get().getOrderStatus()!='j')
            throw new BusinessException("Cannot delete the order, Order status should be j","710");

        orderRepo.deleteById(id);

        return "Success : Deleted the Order with given ID";
    }

    @Override
    public List<Order> getAllOrders() {
        log.info("running getAllOrders in OrderSerive");
        return (List<Order>) orderRepo.findAll();
    }


}
