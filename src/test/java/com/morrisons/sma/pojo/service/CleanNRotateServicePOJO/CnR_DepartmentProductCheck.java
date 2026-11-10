package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({ "locationId", "departmentId", "departmentName", "departmentCheckId", "departmentConfigId",
		"departmentWeekCheck", "departmentYearCheck", "departmentDateCheck", "departmentNextCheck",
		"departmentWeekStatus", "departmentInProgressStatus", "departmentInProgressUpdatedById",
		"departmentInProgressUpdatedOn", "departmentCompletedStatus", "departmentCompletedUpdatedById",
		"departmentCompletedUpdatedByName", "departmentCompletedUpdatedOn", "departmentSignOffStatus",
		"departmentSignOffUpdatedById", "departmentSignOffUpdatedOn", "productsExpiringBeforeNextCheck",
		"deptProductCheckId", "itemNumber", "itemDescription", "expiryDate", "createdById", "createdOn", "updatedById",
		"updatedOn", "isDeleted", "actionId", "actionPerformed", "actionName", "quantity", "wastageMessageId",
		"markdownBarcode", "wastageReasonCode", "moveToMarkdown" })
public class CnR_DepartmentProductCheck {
	@JsonProperty("locationId")
	private int storeId;
	@JsonProperty("departmentId")
	private int departmentId;
	@JsonProperty("departmentName")
	private String departmentName;
	@JsonProperty("departmentCheckId")
	private int departmentCheckId;
	@JsonProperty("departmentConfigId")
	private int departmentConfigId;// ?
	@JsonProperty("departmentWeekCheck")
	private Integer departmentWeekCheck;
	@JsonProperty("departmentYearCheck")
	private Integer departmentYearCheck;
	@JsonProperty("departmentDateCheck")
	private Date departmentDateCheck;
	@JsonProperty("departmentNextCheck")
	private Date departmentNextCheck;
	@JsonProperty("departmentWeekStatus")
	private String departmentWeekStatus;// calculate

	@JsonIgnore
	@JsonProperty("departmentInProgressStatus")
	private Boolean departmentInProgressStatus;

	@JsonProperty("departmentInProgressUpdatedById")
	private String departmentInProgressUpdatedById;
	@JsonProperty("departmentInProgressUpdatedOn")
	private String departmentInProgressUpdatedOn;

	@JsonIgnore
	@JsonProperty("departmentCompletedStatus")
	private Boolean departmentCompletedStatus;

	@JsonProperty("departmentCompletedUpdatedById")
	private String departmentCompletedUpdatedById;
	@JsonProperty("departmentCompletedUpdatedByName")
	private String departmentCompletedUpdatedByName;
	@JsonProperty("departmentCompletedUpdatedOn")
	private String departmentCompletedUpdatedOn;

	@JsonIgnore
	@JsonProperty("departmentSignOffStatus")
	private Boolean departmentSignOffStatus;

	@JsonProperty("departmentSignOffUpdatedById")
	private String departmentSignOffUpdatedById;
	@JsonProperty("departmentSignOffUpdatedOn")
	private String departmentSignOffUpdatedOn;
	@JsonProperty("productsExpiringBeforeNextCheck")
	private Integer productsExpiringBeforeNextCheck;
	@JsonProperty("deptProductCheckId")
	private int departmentProductCheckId;
	@JsonProperty("itemNumber")
	private String productMin;
	@JsonProperty("itemDescription")
	private String productName;
	@JsonProperty("expiryDate")
	private String expiryDate;
	@JsonProperty("createdById")
	private String createdById;
	@JsonProperty("createdOn")
	private String createdOn;
	@JsonProperty("updatedById")
	private String updatedById;
	@JsonProperty("updatedOn")
	private String updatedOn;
	@JsonProperty("isDeleted")
	private String isDeleted;
	@JsonProperty("actionId")
	private Integer actionId;//
	@JsonProperty("actionPerformed")
	private String actionPerformed;//
	@JsonProperty("actionName")
	private String actionName;
	@JsonProperty("quantity")
	private String quantity;
	@JsonProperty("wastageMessageId")
	private String wastageMessageId;
	@JsonProperty("barcodeId")
	private String barcodeId;
	@JsonProperty("wastageReasonCode")
	private Integer wastageReasonCode;
	@JsonProperty("moveToMarkdown")
	private Boolean moveToMarkdown;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentCheckId() {
		return departmentCheckId;
	}
	public void setDepartmentCheckId(int departmentCheckId) {
		this.departmentCheckId = departmentCheckId;
	}
	public int getDepartmentConfigId() {
		return departmentConfigId;
	}
	public void setDepartmentConfigId(int departmentConfigId) {
		this.departmentConfigId = departmentConfigId;
	}
	public Integer getDepartmentWeekCheck() {
		return departmentWeekCheck;
	}
	public void setDepartmentWeekCheck(Integer departmentWeekCheck) {
		this.departmentWeekCheck = departmentWeekCheck;
	}
	public Integer getDepartmentYearCheck() {
		return departmentYearCheck;
	}
	public void setDepartmentYearCheck(Integer departmentYearCheck) {
		this.departmentYearCheck = departmentYearCheck;
	}
	public Date getDepartmentDateCheck() {
		return departmentDateCheck;
	}
	public void setDepartmentDateCheck(Date departmentDateCheck) {
		this.departmentDateCheck = departmentDateCheck;
	}
	public Date getDepartmentNextCheck() {
		return departmentNextCheck;
	}
	public void setDepartmentNextCheck(Date departmentNextCheck) {
		this.departmentNextCheck = departmentNextCheck;
	}
	public String getDepartmentWeekStatus() {
		return departmentWeekStatus;
	}
	public void setDepartmentWeekStatus(String departmentWeekStatus) {
		this.departmentWeekStatus = departmentWeekStatus;
	}
	public Boolean getDepartmentInProgressStatus() {
		return departmentInProgressStatus;
	}
	public void setDepartmentInProgressStatus(Boolean departmentInProgressStatus) {
		this.departmentInProgressStatus = departmentInProgressStatus;
	}
	public String getDepartmentInProgressUpdatedById() {
		return departmentInProgressUpdatedById;
	}
	public void setDepartmentInProgressUpdatedById(String departmentInProgressUpdatedById) {
		this.departmentInProgressUpdatedById = departmentInProgressUpdatedById;
	}
	public String getDepartmentInProgressUpdatedOn() {
		return departmentInProgressUpdatedOn;
	}
	public void setDepartmentInProgressUpdatedOn(String departmentInProgressUpdatedOn) {
		this.departmentInProgressUpdatedOn = departmentInProgressUpdatedOn;
	}
	public Boolean getDepartmentCompletedStatus() {
		return departmentCompletedStatus;
	}
	public void setDepartmentCompletedStatus(Boolean departmentCompletedStatus) {
		this.departmentCompletedStatus = departmentCompletedStatus;
	}
	public String getDepartmentCompletedUpdatedById() {
		return departmentCompletedUpdatedById;
	}
	public void setDepartmentCompletedUpdatedById(String departmentCompletedUpdatedById) {
		this.departmentCompletedUpdatedById = departmentCompletedUpdatedById;
	}
	public String getDepartmentCompletedUpdatedByName() {
		return departmentCompletedUpdatedByName;
	}
	public void setDepartmentCompletedUpdatedByName(String departmentCompletedUpdatedByName) {
		this.departmentCompletedUpdatedByName = departmentCompletedUpdatedByName;
	}
	public String getDepartmentCompletedUpdatedOn() {
		return departmentCompletedUpdatedOn;
	}
	public void setDepartmentCompletedUpdatedOn(String departmentCompletedUpdatedOn) {
		this.departmentCompletedUpdatedOn = departmentCompletedUpdatedOn;
	}
	public Boolean getDepartmentSignOffStatus() {
		return departmentSignOffStatus;
	}
	public void setDepartmentSignOffStatus(Boolean departmentSignOffStatus) {
		this.departmentSignOffStatus = departmentSignOffStatus;
	}
	public String getDepartmentSignOffUpdatedById() {
		return departmentSignOffUpdatedById;
	}
	public void setDepartmentSignOffUpdatedById(String departmentSignOffUpdatedById) {
		this.departmentSignOffUpdatedById = departmentSignOffUpdatedById;
	}
	public String getDepartmentSignOffUpdatedOn() {
		return departmentSignOffUpdatedOn;
	}
	public void setDepartmentSignOffUpdatedOn(String departmentSignOffUpdatedOn) {
		this.departmentSignOffUpdatedOn = departmentSignOffUpdatedOn;
	}
	public Integer getProductsExpiringBeforeNextCheck() {
		return productsExpiringBeforeNextCheck;
	}
	public void setProductsExpiringBeforeNextCheck(Integer productsExpiringBeforeNextCheck) {
		this.productsExpiringBeforeNextCheck = productsExpiringBeforeNextCheck;
	}
	public int getDepartmentProductCheckId() {
		return departmentProductCheckId;
	}
	public void setDepartmentProductCheckId(int departmentProductCheckId) {
		this.departmentProductCheckId = departmentProductCheckId;
	}
	public String getProductMin() {
		return productMin;
	}
	public void setProductMin(String productMin) {
		this.productMin = productMin;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCreatedById() {
		return createdById;
	}
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedById() {
		return updatedById;
	}
	public void setUpdatedById(String updatedById) {
		this.updatedById = updatedById;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	public String getActionPerformed() {
		return actionPerformed;
	}
	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getWastageMessageId() {
		return wastageMessageId;
	}
	public void setWastageMessageId(String wastageMessageId) {
		this.wastageMessageId = wastageMessageId;
	}
	public String getBarcodeId() {
		return barcodeId;
	}
	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}
	public Integer getWastageReasonCode() {
		return wastageReasonCode;
	}
	public void setWastageReasonCode(Integer wastageReasonCode) {
		this.wastageReasonCode = wastageReasonCode;
	}
	public Boolean getMoveToMarkdown() {
		return moveToMarkdown;
	}
	public void setMoveToMarkdown(Boolean moveToMarkdown) {
		this.moveToMarkdown = moveToMarkdown;
	}
	@Override
	public String toString() {
		return "DepartmentProductCheck [storeId=" + storeId + ", departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", departmentCheckId=" + departmentCheckId + ", departmentConfigId="
				+ departmentConfigId + ", departmentWeekCheck=" + departmentWeekCheck + ", departmentYearCheck="
				+ departmentYearCheck + ", departmentDateCheck=" + departmentDateCheck + ", departmentNextCheck="
				+ departmentNextCheck + ", departmentWeekStatus=" + departmentWeekStatus
				+ ", departmentInProgressStatus=" + departmentInProgressStatus + ", departmentInProgressUpdatedById="
				+ departmentInProgressUpdatedById + ", departmentInProgressUpdatedOn=" + departmentInProgressUpdatedOn
				+ ", departmentCompletedStatus=" + departmentCompletedStatus + ", departmentCompletedUpdatedById="
				+ departmentCompletedUpdatedById + ", departmentCompletedUpdatedByName="
				+ departmentCompletedUpdatedByName + ", departmentCompletedUpdatedOn=" + departmentCompletedUpdatedOn
				+ ", departmentSignOffStatus=" + departmentSignOffStatus + ", departmentSignOffUpdatedById="
				+ departmentSignOffUpdatedById + ", departmentSignOffUpdatedOn=" + departmentSignOffUpdatedOn
				+ ", productsExpiringBeforeNextCheck=" + productsExpiringBeforeNextCheck + ", departmentProductCheckId="
				+ departmentProductCheckId + ", productMin=" + productMin + ", productName=" + productName
				+ ", expiryDate=" + expiryDate + ", createdById=" + createdById + ", createdOn=" + createdOn
				+ ", updatedById=" + updatedById + ", updatedOn=" + updatedOn + ", isDeleted=" + isDeleted
				+ ", actionId=" + actionId + ", actionPerformed=" + actionPerformed + ", actionName=" + actionName
				+ ", quantity=" + quantity + ", wastageMessageId=" + wastageMessageId + ", barcodeId=" + barcodeId
				+ ", wastageReasonCode=" + wastageReasonCode + ", moveToMarkdown=" + moveToMarkdown + "]";
	}
}
