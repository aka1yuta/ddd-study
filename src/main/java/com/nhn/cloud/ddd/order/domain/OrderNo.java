package com.nhn.cloud.ddd.order.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderNo implements Serializable {
    @Column("order_number")
    private String number;

    public boolean is2ndGeneration() {
        return number.startsWith("N");
    }
}
