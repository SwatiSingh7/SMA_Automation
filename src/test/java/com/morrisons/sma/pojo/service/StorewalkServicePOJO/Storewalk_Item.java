package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Storewalk_Item {

	 public String productId;
	    public String standardUnitOfMeasure;
	    public String stockUom;
	    public String description;
	    public String qtyOnHand;
	    @JsonProperty("SOHValue") 
	    public String sOHValue;

	    public List<GetStorewalk_Capture> captures;
	    
	    @JsonInclude(Include.NON_NULL)
	    public String reason;
	    
		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getStandardUnitOfMeasure() {
			return standardUnitOfMeasure;
		}

		public void setStandardUnitOfMeasure(String standardUnitOfMeasure) {
			this.standardUnitOfMeasure = standardUnitOfMeasure;
		}

		public String getStockUom() {
			return stockUom;
		}

		public void setStockUom(String stockUom) {
			this.stockUom = stockUom;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getQtyOnHand() {
			return qtyOnHand;
		}

		public void setQtyOnHand(String qtyOnHand) {
			this.qtyOnHand = qtyOnHand;
		}

		public String getsOHValue() {
			return sOHValue;
		}

		public void setsOHValue(String sOHValue) {
			this.sOHValue = sOHValue;
		}

		public List<GetStorewalk_Capture> getCaptures() {
			return captures;
		}

		public void setCaptures(List<GetStorewalk_Capture> captures) {
			this.captures = captures;
		}
		
		

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		@Override
		public String toString() {
			return "Storewalk_Item [productId=" + productId + ", standardUnitOfMeasure=" + standardUnitOfMeasure
					+ ", stockUom=" + stockUom + ", description=" + description + ", qtyOnHand=" + qtyOnHand
					+ ", sOHValue=" + sOHValue + ", captures=" + captures + ", reason=" + reason + "]";
		}
	    
	    
}
