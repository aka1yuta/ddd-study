package com.nhn.cloud.ddd.order.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.nhn.cloud.ddd.member.domain.MemberId;

@Embeddable
public class Orderer {
    @Embedded
    @AttributeOverrides(
        @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

    public MemberId getMemberId() {
        return memberId;
    }
}
