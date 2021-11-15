package com.egen.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_payment")
public class Payment {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_confirmation")
    private String paymentConfirmation;




}
