package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	public class GlhBurst_Delivery {

		@JsonProperty
		private String qty;
		
		@JsonProperty
		private String date;
		
		@JsonProperty
		private String unit;
		
		@JsonProperty
		private String status;

		public String getQty() {
			return qty;
		}

		public void setQty(String qty) {
			this.qty = qty;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "GlhBurst_Delivery [qty=" + qty + ", date=" + date + ", unit=" + unit + ", status=" + status + "]";
		}	
	}

