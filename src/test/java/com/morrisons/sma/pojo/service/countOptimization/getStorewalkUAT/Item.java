package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.ArrayList;

@Value

public class Item {
    public String productId;
    public String standardUnitOfMeasure;
    public String description;
    public int qtyOnHand;
    @JsonProperty("SOHValue")
    public double sOHValue;
    public int qtyInTransit;
    public String stockState;
    public boolean isDeliveryExpectedDateToday;
    public boolean isReceited;
    public ArrayList<Plan> plan;
    public String rangeStatus;
    public CommercialHierarchy commercialHierarchy;
    public Pack pack;
    public CountType countType;
    public boolean isLargeAdjustment;
    public Delivery delivery;
    public int packSize;
    public int variance;
    public int variancePercentage;
    public boolean partOfCount;
    public int reviewCaptureCount;
    public CreationAudit creationAudit;
    public UpdateAudit updateAudit;
    public Action action;
    public ArrayList<Capture> captures;

}
