package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class CnR_ItemListVo {
	
	@JsonProperty("itemList")
		private List<CnR_DepartmentProductCheck> itemList;
	@JsonProperty("metadata")
		private CnR_Metadata metadata;
	
	public List<CnR_DepartmentProductCheck> getItemList() {
		return itemList;
	}
	public void setItemList(List<CnR_DepartmentProductCheck> itemList) {
		this.itemList = itemList;
	}
	public CnR_Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(CnR_Metadata metadata) {
		this.metadata = metadata;
	}
	
	@Override
	public String toString() {
		return "ItemListResponse [itemList=" + itemList + ", metadata=" + metadata + "]";
	}
}


