package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;

import lombok.Value;

import java.util.ArrayList;

@Value
public class Section {
    public int id;
    public String name;
    public int sortOrder;
    public String status;
    public UpdateAudit updateAudit;
    public ArrayList<Item> items;

}
