package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;

import lombok.Value;

@Value
public class Capture {
    public int captureId;
    public String captureType;
    public String captureStatus;
    public int qty;
    public double value;
    public String location;
    public boolean isACase;
    public CreationAudit creationAudit;
    public Plan plan;
    public UpdateAudit updateAudit;


}
