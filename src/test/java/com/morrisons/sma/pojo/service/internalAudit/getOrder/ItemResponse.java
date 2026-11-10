package com.morrisons.sma.pojo.service.internalAudit.getOrder;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class ItemResponse {
    private List<OrderDetails> orders = new ArrayList<OrderDetails>();

}
