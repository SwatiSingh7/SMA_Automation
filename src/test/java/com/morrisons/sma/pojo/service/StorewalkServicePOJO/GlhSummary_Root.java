package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

public class GlhSummary_Root {

	public List<GetStorewalksss_Storewalk> storewalks;
	public List<GlhSummary_Level1> level1;
	
	public List<GetStorewalksss_Storewalk> getStorewalks() {
		return storewalks;
	}
	public void setStorewalks(List<GetStorewalksss_Storewalk> storewalks) {
		this.storewalks = storewalks;
	}
	public List<GlhSummary_Level1> getLevel1() {
		return level1;
	}
	public void setLevel1(List<GlhSummary_Level1> level1) {
		this.level1 = level1;
	}
	@Override
	public String toString() {
		return "GlhSummary_Root [storewalks=" + storewalks + ", level1=" + level1 + "]";
	}


}
