package com.nhn.cloud.ddd.common.domain;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
