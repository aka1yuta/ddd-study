package com.nhn.cloud.ddd.common.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nhn.cloud.ddd.common.domain.Money;

@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Money money) {
        return money == null ? null : money.getValue();
    }

    @Override
    public Money convertToEntityAttribute(Integer value) {
        return value == null ? null : new Money(value);
    }
}
