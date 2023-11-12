package com.nhn.cloud.ddd.order.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.nhn.cloud.ddd.order.NoCancellablePermission;
import com.nhn.cloud.ddd.order.OrderNotFoundException;
import com.nhn.cloud.ddd.order.domain.CancelPolicy;
import com.nhn.cloud.ddd.order.domain.Canceller;
import com.nhn.cloud.ddd.order.domain.Order;
import com.nhn.cloud.ddd.order.domain.OrderNo;
import com.nhn.cloud.ddd.order.domain.OrderRepository;
import com.nhn.cloud.ddd.order.domain.ShippingInfo;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CancelPolicy cancelPolicy;

    @Transactional
    public void changeShippingInfo(OrderNo no, ShippingInfo newShippingInfo) {
        Order order = orderRepository.findById(no)
            .orElseThrow(OrderNotFoundException::new);
        order.changeShippingInfo(newShippingInfo);
    }

    @Transactional
    public void cancel(OrderNo orderNo, Canceller canceller) {
        Order order = orderRepository.findById(orderNo)
            .orElseThrow(OrderNotFoundException::new);
        if (!cancelPolicy.hasCancellationPermission(order, canceller)) {
            throw new NoCancellablePermission();
        }
        order.cancel();
    }
}
