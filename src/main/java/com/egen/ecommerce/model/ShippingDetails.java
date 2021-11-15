package com.egen.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_shipping")
public class ShippingDetails {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "address_id")
    private String addressId;
    @Column(name = "order_shipping_addressline1")
    private String addressLine1;
    @Column(name = "order_shipping_addressline2")
    private String addressLine2;
    @Column(name = "shipping_method")
    private String shippingMethod;
    @Column(name = "zip")
    private int Zip;
    @Column(name = "state")
    private String State;
    @Column(name = "city")
    private String City;

}
