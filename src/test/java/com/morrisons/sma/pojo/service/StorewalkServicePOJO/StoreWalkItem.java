package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "walkid",
    "storenumber",
    "walktype",
    "items"
})

public class StoreWalkItem {
	 
	@JsonProperty("walkid")
	    public String walkid;
	 @JsonProperty("storenumber")
	    public Integer storenumber;
	    @JsonProperty("walktype")
	    public String walktype;
	    @JsonProperty("items")
	    public List<GlhBurst_Items> items = null;
	    
		public String getWalkid() {
			return walkid;
		}
		public void setWalkid(String walkid) {
			this.walkid = walkid;
		}
		public Integer getStorenumber() {
			return storenumber;
		}
		public void setStorenumber(Integer storenumber) {
			this.storenumber = storenumber;
		}
		public String getWalktype() {
			return walktype;
		}
		public void setWalktype(String walktype) {
			this.walktype = walktype;
		}
		public List<GlhBurst_Items> getItems() {
			return items;
		}
		public void setItems(List<GlhBurst_Items> items) {
			this.items = items;
		}
		
		  @Override
			public String toString() {
				return "StoreWalkItem [walkid=" + walkid + ", storenumber=" + storenumber + ", walktype=" + walktype
						+ ", items=" + items + "]";
			}

}
