package com.nhn.cloud.ddd.order.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.nhn.cloud.ddd.order.OrderNotFoundException;
import com.nhn.cloud.ddd.order.domain.Order;
import com.nhn.cloud.ddd.order.domain.OrderNo;
import com.nhn.cloud.ddd.order.domain.OrderRepository;
import com.nhn.cloud.ddd.order.domain.ShippingInfo;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void changeShippingInfo(OrderNo no, ShippingInfo newShippingInfo) {
        Order order = orderRepository.findById(no)
            .orElseThrow(OrderNotFoundException::new);
        order.changeShippingInfo(newShippingInfo);
    }
}
