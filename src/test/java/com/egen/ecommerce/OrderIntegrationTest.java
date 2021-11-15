package com.egen.ecommerce;

import com.egen.ecommerce.model.Item;
import com.egen.ecommerce.model.Order;
import com.egen.ecommerce.model.Payment;
import com.egen.ecommerce.model.ShippingDetails;
import com.egen.ecommerce.repo.OrderRepo;
import com.egen.ecommerce.service.OrderService;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.test.context.junit4.SpringRunner;


import java.time.Instant;
import java.util.*;


@RunWith(SpringRunner.class)
public class OrderIntegrationTest {


    @InjectMocks
   OrderService orderService = new OrderService();


    @Mock
    OrderRepo orderRepo;

    Order testOrder;

    @Before
    public void setup() throws Exception{

        List<Item> item= new ArrayList<Item>(Arrays.asList(
                new Item("String",
                        "Laptop",
                        1,
                        20,
                        30,
                        40,
                        90)));


        List<Payment> payment= new ArrayList<Payment>(Arrays.asList(new Payment("String",
                "Door",
                Date.from(Instant.now()),
                "18hnn9")));

        ShippingDetails shippingDetails= new ShippingDetails("String","500","selene St","Door",13242,"MO","Mason");

        testOrder=new Order("String","String",'c',item,payment,shippingDetails);




    }

    @Test
    public void testGetOrders() throws Exception{

        Mockito.when(orderRepo.findAll()).thenReturn(Arrays.asList(testOrder));
        List<Order> test= orderService.getAllOrders();

        assertEquals(1, test.size());
        assertEquals('c', test.get(0).getOrderStatus());


    }
    @Test
    public void testGetOrderByID () throws Exception{
        Mockito.when(orderRepo.findById(testOrder.getOrderId())).thenReturn(java.util.Optional.ofNullable(testOrder));

        Order test= testOrder;

        assertEquals('c',test.getOrderStatus());
        assertEquals(true,test.equals(testOrder));

    }

    @Test
    public void testCreateOrder () throws Exception{

        Order test= testOrder;
        Mockito.when(orderRepo.save(test)).thenReturn(test);

        assertEquals(true,test.equals(testOrder));
        assertEquals('c',test.getOrderStatus());


    }

}
