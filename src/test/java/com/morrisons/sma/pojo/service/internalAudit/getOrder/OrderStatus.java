package com.morrisons.sma.pojo.service.internalAudit.getOrder;

import lombok.Value;

@Value
public class OrderStatus {
    private OrderedQuantity ordered;
    private ReceiptedQuantityDetails receipted;
}
