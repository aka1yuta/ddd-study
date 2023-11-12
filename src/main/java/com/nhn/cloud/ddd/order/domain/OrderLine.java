package com.nhn.cloud.ddd.order.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.nhn.cloud.ddd.catalog.domain.product.ProductId;
import com.nhn.cloud.ddd.common.domain.Money;
import com.nhn.cloud.ddd.common.jpa.MoneyConverter;

@Embeddable
public class OrderLine {
    @Embedded
    private ProductId productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;
}
