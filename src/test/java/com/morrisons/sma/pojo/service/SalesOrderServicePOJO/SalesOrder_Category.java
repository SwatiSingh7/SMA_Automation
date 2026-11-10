package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

public class SalesOrder_Category {

	public String categoryId;
	public String categoryName;

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "SalesOrder_Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}


}
