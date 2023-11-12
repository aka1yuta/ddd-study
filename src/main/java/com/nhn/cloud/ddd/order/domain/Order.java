package com.nhn.cloud.ddd.order.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.nhn.cloud.ddd.common.domain.Money;
import com.nhn.cloud.ddd.common.jpa.MoneyConverter;

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
public class Order {
    @EmbeddedId
    private OrderNo number;

    @Embedded
    private Orderer orderer;

    @Embedded
    private ShippingInfo shippingInfo;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    public Order() {
    }

    public void changeShippingInfo(ShippingInfo shippingInfo) {

    }

    public void cancel() {

    }

    public Orderer getOrderer() {
        return orderer;
    }
}
