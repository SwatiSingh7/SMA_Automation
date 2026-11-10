package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GetStorewalksss_Root {

	public List<GetStorewalksss_Storewalk> storewalks;
    public GetStorewalksss_Metadata metadata;
    
	public List<GetStorewalksss_Storewalk> getStorewalks() {
		return storewalks;
	}
	public void setStorewalks(List<GetStorewalksss_Storewalk> storewalks) {
		this.storewalks = storewalks;
	}
	public GetStorewalksss_Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(GetStorewalksss_Metadata metadata) {
		this.metadata = metadata;
	}
	@Override
	public String toString() {
		return "GetStorewalksss_Root [storewalks=" + storewalks + ", metadata=" + metadata + "]";
	}
    
    
}
