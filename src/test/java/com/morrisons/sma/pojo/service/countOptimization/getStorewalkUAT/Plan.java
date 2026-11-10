package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Plan {
    @JsonProperty("class")
    public int myclass;
    public String type;
    public String name;
    public String planLocation;
    public int fillQty;
    public String storeWalkSequence;
    public String aisle;
    public String bayNumber;
    public String shelfNumber;
    public String position;

}
