package com.nhn.cloud.ddd.member.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.nhn.cloud.ddd.common.domain.EmailSet;
import com.nhn.cloud.ddd.common.jpa.EmailSetConverter;

@Entity
@Table(name = "member")
public class Member {
    @EmbeddedId
    private MemberId memberId;

    @Transient
    private String firstName;
    @Transient
    private String lastName;

    private String memberName;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;

    @Access(AccessType.PROPERTY)
    public String getMemberName() {
        return firstName + lastName;
    }
}
