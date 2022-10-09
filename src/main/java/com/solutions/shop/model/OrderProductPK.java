package com.solutions.shop.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderProductPK implements Serializable {
    protected Integer orderId;
    protected Integer productId;

    public OrderProductPK() {}

    public OrderProductPK(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductPK that = (OrderProductPK) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
