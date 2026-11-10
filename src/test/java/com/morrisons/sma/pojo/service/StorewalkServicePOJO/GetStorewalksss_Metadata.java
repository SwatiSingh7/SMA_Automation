package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class GetStorewalksss_Metadata {

	 public String limit;
	    public String count;
	    public String offset;
	    
		public String getLimit() {
			return limit;
		}
		public void setLimit(String limit) {
			this.limit = limit;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public String getOffset() {
			return offset;
		}
		public void setOffset(String offset) {
			this.offset = offset;
		}
		@Override
		public String toString() {
			return "GetStorewalksss_Metadata [limit=" + limit + ", count=" + count + ", offset=" + offset + "]";
		}
	    
	    
}
