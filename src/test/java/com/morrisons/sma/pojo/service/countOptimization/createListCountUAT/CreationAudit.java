package com.morrisons.sma.pojo.service.countOptimization.createListCountUAT;

import java.util.Date;

import lombok.Value;

@Value
public class CreationAudit {
    public Date when;
    public Who who;

}
