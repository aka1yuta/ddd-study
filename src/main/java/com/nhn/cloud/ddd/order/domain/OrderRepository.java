package com.nhn.cloud.ddd.order.domain;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(OrderNo no);

    List<Order> findByOrdererId(String ordererId, int startRow, int size);

    void save(Order order);

    void delete(Order order);
}
