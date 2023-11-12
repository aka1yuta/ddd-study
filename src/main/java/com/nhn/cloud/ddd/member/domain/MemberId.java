package com.nhn.cloud.ddd.member.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MemberId implements Serializable {
    @Column(name = "member_id")
    private String id;

    public String getId() {
        return id;
    }
}
