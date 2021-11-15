package com.egen.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_table")
public class Order {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "order_id")
    private String orderId;

    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_status")
    private char orderStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",
            referencedColumnName = "order_id")
    private List<Item> item;     //Multiple items can be added to cart and place order

    @OneToMany(cascade = CascadeType.ALL)

    @JoinColumn(name = "order_id",
    referencedColumnName = "order_id")
    private List<Payment> payment;        // Accepts Multiple payments

    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "address_id",
            referencedColumnName = "address_id")
//    insertable = false,
//    updatable = false)
    private ShippingDetails shippingDetails;
}


