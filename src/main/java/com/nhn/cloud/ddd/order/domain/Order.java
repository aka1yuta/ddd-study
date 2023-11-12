package com.nhn.cloud.ddd.order.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="purchase_order")
@Access(AccessType.FIELD)
public class Order {
    @EmbeddedId
    private OrderNo number;

    private Orderer orderer;

    public void changeShippingInfo(ShippingInfo shippingInfo) {

    }

    public void cancel() {

    }

    public Orderer getOrderer() {
        return orderer;
    }
}
