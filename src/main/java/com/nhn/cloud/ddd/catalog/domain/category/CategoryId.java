package com.nhn.cloud.ddd.catalog.domain.category;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class CategoryId implements Serializable {
    @Column(name = "category_id")
    private Long value;

    protected CategoryId() {
    }

    public CategoryId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
