package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;

import lombok.Value;

import java.util.ArrayList;

@Value
public class Department {
    public int id;
    public String name;
    public int sortOrder;
    public ArrayList<Group> groups;


}
