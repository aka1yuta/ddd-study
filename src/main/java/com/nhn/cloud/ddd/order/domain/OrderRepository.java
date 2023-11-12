package com.nhn.cloud.ddd.order.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.nhn.cloud.ddd.member.domain.MemberId;

public interface OrderRepository extends Repository<Order, OrderNo> {
    Optional<Order> findById(OrderNo no);

    List<Order> findByOrderer(Orderer orderer);

    List<Order> findByOrdererMemberId(MemberId memberId);

    void save(Order order);

    void delete(Order order);

    void deleteById(OrderNo id);
}
