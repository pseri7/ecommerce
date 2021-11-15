package com.egen.ecommerce.controller;

import com.egen.ecommerce.exception.BusinessException;
import com.egen.ecommerce.model.Order;
import com.egen.ecommerce.service.OrderService;
import com.egen.ecommerce.service.OrderServiceInterface;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path="/api")
public class OrderController {

    @Autowired
    public OrderServiceInterface orderService;

//-------------------------------------------------------------
    @GetMapping("/getOrderStatus/{id}")
    @ApiOperation(value= "Gets Order status given input an order ID",
        notes = "Provide an id to look up specific order and get the status",
                  response = ResponseEntity.class)


    public ResponseEntity<String> getOrderStatus(@PathVariable String id) {
        log.info("running getOrderStatus in OrderController ");
        return new ResponseEntity<String>(orderService.getOrderStatus(id), HttpStatus.OK);
    }

//-------------------------------------------------------------

    @GetMapping("/getOrderById/{id}")
    @ApiOperation(value= "Gets Order Details given input an order ID",
            notes = "Provide an id to look up specific order",
            response = ResponseEntity.class)

    public ResponseEntity<Order> orderById(@PathVariable String id){
        log.info("running orderById in OrderController with id : "+id);
        return new ResponseEntity<Order>(orderService.getOrderByID(id),HttpStatus.OK);
    }

//-------------------------------------------------------------

    @PutMapping("/cancelOrderById/{id}")
    @ApiOperation(value= "Cancels Order,to be given an order ID",
            notes = "Provide an id to cancel a specific order",
            response = ResponseEntity.class)

    public ResponseEntity<String> cancelOrderById(@PathVariable String id){
        log.info("running cancelOrderById in OrderController with id : "+id);
        return new ResponseEntity<>(orderService.cancelOrderByID(id),HttpStatus.ACCEPTED);
    }

//-------------------------------------------------------------

    @PostMapping("/createOrder")
    @ApiOperation(value= "Creates a new Order",
            notes = "Input all necessary fields to create a new order",
            response = ResponseEntity.class)

    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        log.info("running createOrder in OrderController ");
        return new ResponseEntity<>(orderService.createOrder(order),HttpStatus.ACCEPTED) ;}

//-------------------------------------------------------------

    @DeleteMapping(path = {"/deleteOrder/{id}","/deleteOrder"})
    @ApiOperation(value= "Delete an existing Order",
            notes = "Provide ID of the order to be deleted ",
            response = ResponseEntity.class)

    public ResponseEntity<String> deleteOrder(@PathVariable Optional<String> id){
        if(!id.isPresent()){
            throw new IllegalArgumentException("empty input: please enter a value");}
        log.info("running deleteOrder in OrderController with id : "+id);
        return new ResponseEntity<String>(orderService.deleteOrder(id.get()),HttpStatus.ACCEPTED);
    }

//-------------------------------------------------------------

    @GetMapping("/getAllOrders")
    @ApiOperation(value= "Hit the endpoint, no arguments to be passed",
            notes = "Prints out all the orders",
            response = ResponseEntity.class)

    public ResponseEntity<List<Order>> getAllOrders() {
        log.info("running getAllOrders in OrderController ");
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
    }

}
