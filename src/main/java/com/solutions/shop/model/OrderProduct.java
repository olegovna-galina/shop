package com.solutions.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;

import java.io.Serializable;

@Data
@Entity
@Table(name = "order_product")
@NoArgsConstructor
@IdClass(OrderProductPK.class)
public class OrderProduct implements Serializable {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Id
    @Column(name = "product_id")
    private Integer productId;
}
