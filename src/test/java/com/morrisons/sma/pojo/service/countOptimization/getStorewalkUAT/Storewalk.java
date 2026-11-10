package com.morrisons.sma.pojo.service.countOptimization.getStorewalkUAT;

import lombok.Value;

import java.util.ArrayList;
import java.util.Date;

@Value
public class Storewalk {
    public String walkId;
    public int storeNumber;
    public String walkType;
    public ArrayList<Location> locations;
    public boolean isCurfewStore;
    public CreationAudit creationAudit;
    public ArrayList<Department> departments;
    public String mode;
    public String name;
    public ArrayList<String> hierarchy;
    public ArrayList<DepartmentList> departmentList;
    public Date startTime;
    public Date endTime;
    public Date date;
    public String scheduleRef;
    public String storeWalkStatus;

}
