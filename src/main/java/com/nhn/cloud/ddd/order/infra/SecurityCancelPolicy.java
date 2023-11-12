package com.nhn.cloud.ddd.order.infra;

import com.nhn.cloud.ddd.order.domain.CancelPolicy;
import com.nhn.cloud.ddd.order.domain.Canceller;
import com.nhn.cloud.ddd.order.domain.Order;

public class SecurityCancelPolicy implements CancelPolicy {
    @Override
    public boolean hasCancellationPermission(Order order, Canceller canceller) {
        return isCancellerOrderer(order, canceller);
    }

    private boolean isCancellerOrderer(Order order, Canceller canceller) {
        return order.getOrderer().getMemberId().getId().equals(canceller.getMemberId());
    }
}
