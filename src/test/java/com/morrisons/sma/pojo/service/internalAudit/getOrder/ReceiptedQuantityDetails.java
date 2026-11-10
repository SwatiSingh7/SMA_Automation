package com.morrisons.sma.pojo.service.internalAudit.getOrder;

import lombok.Value;

@Value
public class ReceiptedQuantityDetails {
    private Double quantity;
    private String quantityUnit;
    private String quantityType;
    private String date;
}
