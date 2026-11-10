package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;
import lombok.Value;

import java.util.Date;

@Value
public class UpdateAudit {
    public Date when;
    public Who who;
}
