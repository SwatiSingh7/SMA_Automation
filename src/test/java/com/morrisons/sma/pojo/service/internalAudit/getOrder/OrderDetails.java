package com.morrisons.sma.pojo.service.internalAudit.getOrder;

import lombok.Value;

@Value
public class OrderDetails {
    private String orderId;
    private String orderType;
    private String customerOrderId;
    private String customerId;
    private String statusCurrent;
    private Integer shipToLocationId;
    private String shipFromLocationId;
    private Lines lines;
    private String createdAt;
    private String orderPosition;

}
