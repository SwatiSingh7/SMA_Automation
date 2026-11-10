package com.morrisons.sma.pojo.service.cleanAndRotate.getListItems;


import lombok.Value;

@Value
public class ItemDetailsInfo {
    private Integer limit;
    private Integer offset;
    private Integer count;
    private Integer total;
    private ItemLinks links;
}
