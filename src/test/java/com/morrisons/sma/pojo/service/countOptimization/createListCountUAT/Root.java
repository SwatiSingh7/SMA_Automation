package com.morrisons.sma.pojo.service.countOptimization.createListCountUAT;

import java.util.ArrayList;
import java.util.Date;

import lombok.Value;

@Value

public class Root {
    public String walkId;
    public int storeNumber;
    public String walkType;
    public String mode;
    public String name;
    public Date startTime;
    public Date endTime;
    public Date date;
    public String scheduleRef;
    public ArrayList<Location> locations;
    public String storeWalkStatus;
    public boolean isCurfewStore;
    public String ingredientsOnly;
    public CreationAudit creationAudit;
}
