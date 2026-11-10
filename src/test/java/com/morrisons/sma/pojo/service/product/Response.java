package com.morrisons.sma.pojo.service.product;

import java.util.List;
import lombok.Value;

@Value
public class Response{
	Metadata metadata;
	List<ItemListItem> itemList;
}