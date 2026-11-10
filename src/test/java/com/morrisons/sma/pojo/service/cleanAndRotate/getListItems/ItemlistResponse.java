package com.morrisons.sma.pojo.service.cleanAndRotate.getListItems;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class ItemlistResponse {
    private List<ItemDetails> itemList = new ArrayList<ItemDetails>();
    private ItemDetailsInfo itemInfo;

}
