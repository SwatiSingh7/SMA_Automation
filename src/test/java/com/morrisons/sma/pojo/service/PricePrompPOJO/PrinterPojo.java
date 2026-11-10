package com.morrisons.sma.pojo.service.PricePrompPOJO;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.util.CollectionUtils;

public class PrinterPojo {

	private String printerId;
	private List<Integer> markdownEventIds;
//	private String markdownEventIds;
	public String getPrinterId() {
		return printerId;
	}
	public void setPrinterId(String printerId) {
		this.printerId = printerId;
	}
	
	
	public List<Integer> getMarkdownEventIds() {
		if(CollectionUtils.isNullOrEmpty(markdownEventIds)) {
			return new ArrayList<>();
		}
		return markdownEventIds;
	}
	public void setMarkdownEventIds(List<Integer> markdownEventIds) {
		this.markdownEventIds = markdownEventIds;
	}
	@Override
	public String toString() {
		return "PrinterPojo [printerId=" + printerId + ", markdownEventIds=" + markdownEventIds + "]";
	}

	
	
	
}
