package com.nhn.cloud.ddd.common.domain;

public class Email {
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
