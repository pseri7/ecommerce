package com.egen.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_item")
public class Item
{
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "item_id")
    private String itemId;
    @Column(name = "order_item_name")
    private String itemName;
    @Column(name = "order_item_qty")
    private double itemQty;
    @Column(name = "order_subtotal")
    private double subtotal;
    @Column(name = "order_tax")
    private double tax;
    @Column(name = "order_shipping_charges")
    private double shippingCharges;
    @Column(name = "total_amount")
    private double totalAmount;
}

