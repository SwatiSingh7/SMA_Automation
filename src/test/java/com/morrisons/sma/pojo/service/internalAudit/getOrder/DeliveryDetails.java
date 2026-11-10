package com.morrisons.sma.pojo.service.internalAudit.getOrder;

import lombok.Value;

@Value
public class DeliveryDetails {
    private String dateAvailabilityExpected;
    private String dateDeliveryExpected;
}
