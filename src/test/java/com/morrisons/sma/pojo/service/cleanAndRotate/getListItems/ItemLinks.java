package com.morrisons.sma.pojo.service.cleanAndRotate.getListItems;

import lombok.Value;

@Value
public class ItemLinks {
    private Object next;
    private String current;
    private Object previous;
}
