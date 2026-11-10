package com.morrisons.sma.pojo.service.internalAudit.getOrder;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Lines {
    private Integer itemLineId;
    private String itemId;
    private String quantityUnitId;
    private String quantityType;
    private List<OrderStatus> status = new ArrayList<OrderStatus>();
    private DeliveryDetails delivery;

}
