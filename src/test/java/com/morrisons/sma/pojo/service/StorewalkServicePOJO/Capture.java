package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Capture {
	
	    @JsonProperty("productId")
	    private String productId;
		@JsonProperty("description")
	    private String description;
	    @JsonProperty("sectionId")
	    private Integer sectionId;
	    @JsonProperty("sectionStatus")
	    private String sectionStatus;
	   

	    @JsonProperty("productId")
	    public String getProductId() {
	        return productId;
	    }

	    @JsonProperty("productId")
	    public void setProductId(String productId) {
	        this.productId = productId;
	    }

	    @JsonProperty("description")
	    public String getDescription() {
	        return description;
	    }

	    @JsonProperty("description")
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    @JsonProperty("sectionId")
	    public Integer getSectionId() {
	        return sectionId;
	    }

	    @JsonProperty("sectionId")
	    public void setSectionId(Integer sectionId) {
	        this.sectionId = sectionId;
	    }

	    @JsonProperty("sectionStatus")
	    public String getSectionStatus() {
	        return sectionStatus;
	    }

	    @JsonProperty("sectionStatus")
	    public void setSectionStatus(String sectionStatus) {
	        this.sectionStatus = sectionStatus;
	    }
	    @Override
		public String toString() {
			return "Storewalk_GETCapturesPOJO [productId=" + productId + ", description=" + description + ", sectionId="
					+ sectionId + ", sectionStatus=" + sectionStatus + "]";
		}
	    
	}


