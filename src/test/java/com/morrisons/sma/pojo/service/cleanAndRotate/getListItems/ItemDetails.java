package com.morrisons.sma.pojo.service.cleanAndRotate.getListItems;

import lombok.Value;

@Value
public class ItemDetails {
    private Integer locationId;
    private Integer departmentId;
    private String departmentName;
    private Integer departmentCheckId;
    private Integer departmentConfigId;
    private Integer deptProductCheckId;
    private String itemNumber;
    private String itemDescription;
    private String expiryDate;
    private String createdById;
    private String createdOn;
    private String updatedOn;
    private Boolean isDeleted;
    private Integer actionId;
    private String actionPerformed;
    private String actionName;
    private Integer quantity;
    private String wastageMessageId;
    private Integer wastageReasonCode;
    private String category;
    private String barcodeId;
}
