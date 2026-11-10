package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

public class SalesOrder_Metadata {

	   public String limit;
	    public String offset;
	    public String count;
	    public String total;
	    public SalesOrder_Links links;
	    
		public String getLimit() {
			return limit;
		}
		public void setLimit(String limit) {
			this.limit = limit;
		}
		public String getOffset() {
			return offset;
		}
		public void setOffset(String offset) {
			this.offset = offset;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public SalesOrder_Links getLinks() {
			return links;
		}
		public void setLinks(SalesOrder_Links links) {
			this.links = links;
		}
		@Override
		public String toString() {
			return "SalesOrder_Metadata [limit=" + limit + ", offset=" + offset + ", count=" + count + ", total="
					+ total + ", links=" + links + "]";
		}
	    
	    
}
