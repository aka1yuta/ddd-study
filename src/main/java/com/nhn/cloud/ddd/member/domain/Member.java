package com.nhn.cloud.ddd.member.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nhn.cloud.ddd.common.domain.EmailSet;
import com.nhn.cloud.ddd.common.jpa.EmailSetConverter;

@Entity
@Table(name = "member")
public class Member {
    @EmbeddedId
    private MemberId memberId;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;
}
