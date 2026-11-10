package com.morrisons.sma.pojo.service.cleanAndRotate.getDepartments;


import lombok.Value;

@Value
public class DepartmentResponse {
    Integer departmentId;
    Integer departmentConfigId;
    Integer departmentCheckId;
    String departmentName;
    String nextCheck;
    String status;
    String signOffUpdatedById;
    String signOffUpdatedOn;
}