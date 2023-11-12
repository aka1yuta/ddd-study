package com.nhn.cloud.ddd.order.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface OrderRepository extends Repository<Order, OrderNo> {
    Optional<Order> findById(OrderNo no);

    List<Order> findByOrdererId(String ordererId, int startRow, int size);

    void save(Order order);

    void delete(Order order);
}
