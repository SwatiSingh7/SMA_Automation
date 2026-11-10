package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;

import java.util.ArrayList;


import lombok.Value;

@Value

public class Group {
    public int id;
    public String name;
    public int sortOrder;
    public ArrayList<Section> sections;

}
