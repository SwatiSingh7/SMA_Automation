package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class GetStorewalk_Capture {

	 public String walk_item_id;
	    public String captureId;
	    public String captureType;
	    public String captureStatus;
	    public String qty;
	    public String value;
	    public String location;
	    public String isACase;
	   
	    public String getWalk_item_id() {
			return walk_item_id;
		}
		public void setWalk_item_id(String walk_item_id) {
			this.walk_item_id = walk_item_id;
		}
		public String getCaptureId() {
			return captureId;
		}
		public void setCaptureId(String captureId) {
			this.captureId = captureId;
		}
		public String getCaptureType() {
			return captureType;
		}
		public void setCaptureType(String captureType) {
			this.captureType = captureType;
		}
		public String getCaptureStatus() {
			return captureStatus;
		}
		public void setCaptureStatus(String captureStatus) {
			this.captureStatus = captureStatus;
		}
		public String getQty() {
			return qty;
		}
		public void setQty(String qty) {
			this.qty = qty;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getIsACase() {
			return isACase;
		}
		public void setIsACase(String isACase) {
			this.isACase = isACase;
		}

		@Override
		public String toString() {
			return "GetStorewalk_Capture [walk_item_id=" + walk_item_id + ", captureId=" + captureId + ", captureType="
					+ captureType + ", captureStatus=" + captureStatus + ", qty=" + qty + ", value=" + value
					+ ", location=" + location + ", isACase=" + isACase + "]";
		}
	    
	    
}
