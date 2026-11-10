package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;


public class GlhSummary_Level1 {

	private int id;
	private String name;
	private int sortOrder;
	private String totalGaps;
	private String totalHighs;
	private String totalLows;
	private String type;
	private GlhSummary_Gaps gaps;
	private GlhSummary_Highs highs;
	private GlhSummary_Lows lows;
	
	public List<GlhSummary_Level2> level2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getTotalGaps() {
		return totalGaps;
	}

	public void setTotalGaps(String totalGaps) {
		this.totalGaps = totalGaps;
	}

	public String getTotalHighs() {
		return totalHighs;
	}

	public void setTotalHighs(String totalHighs) {
		this.totalHighs = totalHighs;
	}

	public String getTotalLows() {
		return totalLows;
	}

	public void setTotalLows(String totalLows) {
		this.totalLows = totalLows;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GlhSummary_Gaps getGaps() {
		return gaps;
	}

	public void setGaps(GlhSummary_Gaps gaps) {
		this.gaps = gaps;
	}

	public GlhSummary_Highs getHighs() {
		return highs;
	}

	public void setHighs(GlhSummary_Highs highs) {
		this.highs = highs;
	}

	public GlhSummary_Lows getLows() {
		return lows;
	}

	public void setLows(GlhSummary_Lows lows) {
		this.lows = lows;
	}

	public List<GlhSummary_Level2> getLevel2() {
		return level2;
	}

	public void setLevel2(List<GlhSummary_Level2> level2) {
		this.level2 = level2;
	}

	@Override
	public String toString() {
		return "GlhSummary_Level1 [id=" + id + ", name=" + name + ", sortOrder=" + sortOrder + ", totalGaps="
				+ totalGaps + ", totalHighs=" + totalHighs + ", totalLows=" + totalLows + ", type=" + type + ", gaps="
				+ gaps + ", highs=" + highs + ", lows=" + lows + ", level2=" + level2 + "]";
	}
	
	
	
    
}
