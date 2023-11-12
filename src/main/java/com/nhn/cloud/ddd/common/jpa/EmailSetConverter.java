package com.nhn.cloud.ddd.common.jpa;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;

import com.nhn.cloud.ddd.common.domain.Email;
import com.nhn.cloud.ddd.common.domain.EmailSet;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {
    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        if (attribute == null) return null;
        return attribute.getEmails().stream()
            .map(Email::getAddress)
            .collect(Collectors.joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        String[] emails = dbData.split(",");
        Set<Email> emailSet = Arrays.stream(emails)
            .map(Email::new)
            .collect(toSet());
        return new EmailSet(emailSet);
    }
}
