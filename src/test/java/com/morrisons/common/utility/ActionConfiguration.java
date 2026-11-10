package com.morrisons.common.utility;

public class ActionConfiguration {

	/*
	 * public boolean isPrice; public boolean isSpace; public boolean
	 * isPromotion; public boolean isBFF; public boolean isProduct; public
	 * boolean isProductHierarchyAdapter; public boolean isPriceV2; public
	 * boolean isMarkdown; public boolean isPromoAdapter; public boolean
	 * isPcsPca; public boolean isPriceAdapter; public boolean
	 * isContentHierarchyAdapter; public boolean isSignage; public boolean
	 * isPriceEstablishment;
	 */

	public boolean isPriceV2;

	@Override
	public String toString() {
		return "ActionConfiguration [isPriceV2=" + isPriceV2 + ", isProduct=" + isProduct + ", isPromotion="
				+ isPromotion + ", isSpace=" + isSpace + ", isPrice=" + isPrice + ", isMarkdown=" + isMarkdown
				+ ", isAM_Counts=" + isAM_Counts + ", isCleanAndRotate=" + isCleanAndRotate + ", isStockAdjustment="
				+ isStockAdjustment + ", isStockInformation=" + isStockInformation + ", isPM_Gap=" + isPM_Gap
				+ ", isPM_Count=" + isPM_Count + ", isAM_GLH=" + isAM_GLH + ", isGLHBurst=" + isGLHBurst
				+ ", isMarketStreet=" + isMarketStreet + ", isPriceIntegrity=" + isPriceIntegrity + ", isNegativePromt="
				+ isNegativePromt + ", isSalesOrder=" + isSalesOrder + ", isGlhDrillDown=" + isGlhDrillDown
				+ ", isIntegratedSales=" + isIntegratedSales + ", isforgotPassword=" + isforgotPassword
				+ ", isEasyStore=" + isEasyStore + ", isFreshCodeCheck=" + isFreshCodeCheck + ", isPromptedCount="
				+ isPromptedCount + ", isWasteValidation=" + isWasteValidation + ", isDLDR=" + isDLDR
				+ ", isTwilightManager=" + isTwilightManager + ", cleanAndRotate_Action=" + cleanAndRotate_Action
				+ ", isRFID=" + isRFID + "]";
	}

	public boolean isProduct;
	public boolean isPromotion;

	public void setPromptedCount(boolean promptedCount) {
		isPromptedCount = promptedCount;
	}

	public boolean isWasteValidation() {
		return isWasteValidation;
	}

	public void setWasteValidation(boolean wasteValidation) {
		isWasteValidation = wasteValidation;
	}

	public boolean isSpace;
	public boolean isPrice;
	public boolean isMarkdown;
	public boolean isAM_Counts;
	public boolean isCleanAndRotate;
	public boolean isStockAdjustment;
	public boolean isStockInformation;
	public boolean isPM_Gap;
	public boolean isPM_Count;
	public boolean isAM_GLH;
	public boolean isGLHBurst;
	public boolean isMarketStreet;
	public boolean isPriceIntegrity;

	public boolean isNegativePromt;
	public boolean isSalesOrder;
	public boolean isGlhDrillDown;
	public boolean isIntegratedSales;
	public boolean isforgotPassword;
	public boolean isEasyStore;
	public boolean isFreshCodeCheck;
	public boolean isPromptedCount;
	public boolean isWasteValidation;
	public boolean isDLDR;
	public boolean isTwilightManager;

	public boolean isDLDR() {
		return isDLDR;
	}

	public void setDLDR(boolean DLDR) {
		isDLDR = DLDR;
	}


	public CnR_ActionConfig cleanAndRotate_Action;
	
	public boolean isRFID;

	public boolean isPriceV2() {
		return isPriceV2;
	}

	public void setPriceV2(boolean isPriceV2) {
		this.isPriceV2 = isPriceV2;
	}

	public boolean isProduct() {
		return isProduct;
	}

	public void setProduct(boolean isProduct) {
		this.isProduct = isProduct;
	}

	public boolean isPromotion() {
		return isPromotion;
	}

	public void setPromotion(boolean isPromotion) {
		this.isPromotion = isPromotion;
	}

	public boolean isSpace() {
		return isSpace;
	}

	public void setSpace(boolean isSpace) {
		this.isSpace = isSpace;
	}

	public boolean isPrice() {
		return isPrice;
	}

	public void setPrice(boolean isPrice) {
		this.isPrice = isPrice;
	}

	public boolean isMarkdown() {
		return isMarkdown;
	}

	public void setMarkdown(boolean isMarkdown) {
		this.isMarkdown = isMarkdown;
	}

	public boolean isAM_Counts() {
		return isAM_Counts;
	}

	public void setAM_Counts(boolean isAM_Counts) {
		this.isAM_Counts = isAM_Counts;
	}

	public boolean isCleanAndRotate() {
		return isCleanAndRotate;
	}

	public void setCleanAndRotate(boolean isCleanAndRotate) {
		this.isCleanAndRotate = isCleanAndRotate;
	}

	public boolean isStockAdjustment() {
		return isStockAdjustment;
	}

	public void setStockAdjustment(boolean isStockAdjustment) {
		this.isStockAdjustment = isStockAdjustment;
	}

	public boolean isStockInformation() {
		return isStockInformation;
	}

	public void setStockInformation(boolean isStockInformation) {
		this.isStockInformation = isStockInformation;
	}

	public boolean isPM_Gap() {
		return isPM_Gap;
	}

	public void setPM_Gap(boolean isPM_Gap) {
		this.isPM_Gap = isPM_Gap;
	}

	public boolean isPM_Count() {
		return isPM_Count;
	}

	public void setPM_Count(boolean isPM_Count) {
		this.isPM_Count = isPM_Count;
	}

	public boolean isAM_GLH() {
		return isAM_GLH;
	}

	public void setAM_GLH(boolean isAM_GLH) {
		this.isAM_GLH = isAM_GLH;
	}

	public boolean isGLHBurst() {
		return isGLHBurst;
	}

	public void setGLHBurst(boolean isGLHBurst) {
		this.isGLHBurst = isGLHBurst;
	}

	public boolean isMarketStreet() {
		return isMarketStreet;
	}

	public void setMarketStreet(boolean isMarketStreet) {
		this.isMarketStreet = isMarketStreet;
	}

	public boolean isPriceIntegrity() {
		return isPriceIntegrity;
	}

	public void setPriceIntegrity(boolean isPriceIntegrity) {
		this.isPriceIntegrity = isPriceIntegrity;
	}

	public boolean isNegativePromt() {
		return isNegativePromt;
	}

	public void setNegativePromt(boolean isNegativePromt) {
		this.isNegativePromt = isNegativePromt;
	}

	public boolean isSalesOrder() {
		return isSalesOrder;
	}

	public void setSalesOrder(boolean isSalesOrder) {
		this.isSalesOrder = isSalesOrder;
	}

	public boolean isGlhDrillDown() {
		return isGlhDrillDown;
	}

	public void setGlhDrillDown(boolean isGlhDrillDown) {
		this.isGlhDrillDown = isGlhDrillDown;
	}

	public boolean isIntegratedSales() {
		return isIntegratedSales;
	}

	public void setIntegratedSales(boolean isIntegratedSales) {
		this.isIntegratedSales = isIntegratedSales;
	}

	public boolean isIsforgotPassword() {
		return isforgotPassword;
	}

	public void setIsforgotPassword(boolean isforgotPassword) {
		this.isforgotPassword = isforgotPassword;
	}

	public boolean isEasyStore() {
		return isEasyStore;
	}

	public void setEasyStore(boolean isEasyStore) {
		this.isEasyStore = isEasyStore;
	}

	public CnR_ActionConfig getCleanAndRotate_Action() {
		return cleanAndRotate_Action;
	}

	public void setCleanAndRotate_Action(CnR_ActionConfig cleanAndRotate_Action) {
		this.cleanAndRotate_Action = cleanAndRotate_Action;
	}
	
	

	public boolean isFreshCodeCheck() {
		return isFreshCodeCheck;
	}

	public void setFreshCodeCheck(boolean isFreshCodeCheck) {
		this.isFreshCodeCheck = isFreshCodeCheck;
	}

	public boolean isRFID() {
		return isRFID;
	}

	public void setRFID(boolean isRFID) {
		this.isRFID = isRFID;
	}
	
	

	public boolean isPromptedCount() {
		return isPromptedCount;
	}

	public void setPrompteCount(boolean isPromptedCount) {
		this.isPromptedCount = isPromptedCount;
	}

	public boolean isTwilightManager() {
		return isTwilightManager;
	}

	public void setTwilightManager(boolean isTwilightManager) {
		this.isTwilightManager = isTwilightManager;
	}
	
	


}