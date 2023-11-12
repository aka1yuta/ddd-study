package com.nhn.cloud.ddd.order.domain;

import com.nhn.cloud.ddd.member.domain.MemberId;

public class Orderer {
    private MemberId memberId;

    public MemberId getMemberId() {
        return memberId;
    }
}
