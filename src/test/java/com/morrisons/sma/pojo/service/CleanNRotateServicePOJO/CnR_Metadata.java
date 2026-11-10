package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.ALWAYS)

@JsonPropertyOrder({ "limit", "offset", "count", "total", "links"})
public class CnR_Metadata {

	private Integer limit;
	private Long offset;
	private int count;
	private int total;
	private CnR_Links links;
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Long getOffset() {
		return offset;
	}
	public void setOffset(Long offset) {
		this.offset = offset;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public CnR_Links getLinks() {
		return links;
	}
	public void setLinks(CnR_Links links) {
		this.links = links;
	}
	@Override
	public String toString() {
		return "Metadata [limit=" + limit + ", offset=" + offset + ", count=" + count + ", total=" + total + ", links="
				+ links + "]";
	}
}
