package com.nhn.cloud.ddd.catalog.domain.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.nhn.cloud.ddd.common.domain.Money;
import com.nhn.cloud.ddd.common.jpa.MoneyConverter;

@Entity
@Table(name = "product")
public class Product {
    @EmbeddedId
    private ProductId id;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private String detail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    protected Product() {
    }

    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }
}
