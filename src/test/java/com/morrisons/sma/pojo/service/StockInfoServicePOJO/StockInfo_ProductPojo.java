package com.morrisons.sma.pojo.service.StockInfoServicePOJO;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class StockInfo_ProductPojo {

	@JsonIgnoreProperties(ignoreUnknown = true)
	private List<StockInfo_Gtins> gtins;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String itemNumber;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String supplySource;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String components;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String vatRate;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String isCatchWeight;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String[] storage;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_CafeSelfServe cafeSelfServe;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String forceEnterPrice;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_UnitEquivalentPrice unitEquivalentPrice;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_CommercialHierarchy commercialHierarchy;
	@JsonIgnoreProperties(ignoreUnknown = true)
	//private String[] packComponents;

	// private String imageUrl;
	//
	// private String[] ingredients;

	private String netContent;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_Magazines magazines;

	private String itemDescription;

	private String brand;

	private String productType;

	private String vatCode;

	// private String[] nutritionalInfo;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_MarketStreet marketStreet;

	private String productMarketing;

	// private String[] gda;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_StockAccountingMethod stockAccountingMethod;

	private String nutritionalHeading;

	// private String[] allergenInfo;

	private String parentItemNumber;

	private String sellingUnitOfMeasure;

	private String[] legacyItemNumbers;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_Packs[] packs;

	private String customerFriendlyDescription;

	private String sellBy;

	private String priceMarked;

	private String countryOfOrigin;

	private String tillDescription;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_BeersWinesSpirits beersWinesSpirits;

	private String status;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private StockInfo_Dimensions dimensions;

	public List<StockInfo_Gtins> getGtins() {
		return gtins;
	}

	public void setGtins(List<StockInfo_Gtins> gtins) {
		this.gtins = gtins;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getSupplySource() {
		return supplySource;
	}

	public void setSupplySource(String supplySource) {
		this.supplySource = supplySource;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	public String getIsCatchWeight() {
		return isCatchWeight;
	}

	public void setIsCatchWeight(String isCatchWeight) {
		this.isCatchWeight = isCatchWeight;
	}

	public String[] getStorage() {
		return storage;
	}

	public void setStorage(String[] storage) {
		this.storage = storage;
	}

	public StockInfo_CafeSelfServe getCafeSelfServe() {
		return cafeSelfServe;
	}

	public void setCafeSelfServe(StockInfo_CafeSelfServe cafeSelfServe) {
		this.cafeSelfServe = cafeSelfServe;
	}

	public String getForceEnterPrice() {
		return forceEnterPrice;
	}

	public void setForceEnterPrice(String forceEnterPrice) {
		this.forceEnterPrice = forceEnterPrice;
	}

	public StockInfo_UnitEquivalentPrice getUnitEquivalentPrice() {
		return unitEquivalentPrice;
	}

	public void setUnitEquivalentPrice(StockInfo_UnitEquivalentPrice unitEquivalentPrice) {
		this.unitEquivalentPrice = unitEquivalentPrice;
	}

	public StockInfo_CommercialHierarchy getCommercialHierarchy() {
		return commercialHierarchy;
	}

	public void setCommercialHierarchy(StockInfo_CommercialHierarchy commercialHierarchy) {
		this.commercialHierarchy = commercialHierarchy;
	}

//	public String[] getPackComponents() {
//		return packComponents;
//	}
//
//	public void setPackComponents(String[] packComponents) {
//		this.packComponents = packComponents;
//	}

	public String getNetContent() {
		return netContent;
	}

	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}

	public StockInfo_Magazines getMagazines() {
		return magazines;
	}

	public void setMagazines(StockInfo_Magazines magazines) {
		this.magazines = magazines;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getVatCode() {
		return vatCode;
	}

	public void setVatCode(String vatCode) {
		this.vatCode = vatCode;
	}

	public StockInfo_MarketStreet getMarketStreet() {
		return marketStreet;
	}

	public void setMarketStreet(StockInfo_MarketStreet marketStreet) {
		this.marketStreet = marketStreet;
	}

	public String getProductMarketing() {
		return productMarketing;
	}

	public void setProductMarketing(String productMarketing) {
		this.productMarketing = productMarketing;
	}

	public StockInfo_StockAccountingMethod getStockAccountingMethod() {
		return stockAccountingMethod;
	}

	public void setStockAccountingMethod(StockInfo_StockAccountingMethod stockAccountingMethod) {
		this.stockAccountingMethod = stockAccountingMethod;
	}

	public String getNutritionalHeading() {
		return nutritionalHeading;
	}

	public void setNutritionalHeading(String nutritionalHeading) {
		this.nutritionalHeading = nutritionalHeading;
	}

	public String getParentItemNumber() {
		return parentItemNumber;
	}

	public void setParentItemNumber(String parentItemNumber) {
		this.parentItemNumber = parentItemNumber;
	}

	public String getSellingUnitOfMeasure() {
		return sellingUnitOfMeasure;
	}

	public void setSellingUnitOfMeasure(String sellingUnitOfMeasure) {
		this.sellingUnitOfMeasure = sellingUnitOfMeasure;
	}

	public String[] getLegacyItemNumbers() {
		return legacyItemNumbers;
	}

	public void setLegacyItemNumbers(String[] legacyItemNumbers) {
		this.legacyItemNumbers = legacyItemNumbers;
	}

	public StockInfo_Packs[] getPacks() {
		return packs;
	}

	public void setPacks(StockInfo_Packs[] packs) {
		this.packs = packs;
	}

	public String getCustomerFriendlyDescription() {
		return customerFriendlyDescription;
	}

	public void setCustomerFriendlyDescription(String customerFriendlyDescription) {
		this.customerFriendlyDescription = customerFriendlyDescription;
	}

	public String getSellBy() {
		return sellBy;
	}

	public void setSellBy(String sellBy) {
		this.sellBy = sellBy;
	}

	public String getPriceMarked() {
		return priceMarked;
	}

	public void setPriceMarked(String priceMarked) {
		this.priceMarked = priceMarked;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getTillDescription() {
		return tillDescription;
	}

	public void setTillDescription(String tillDescription) {
		this.tillDescription = tillDescription;
	}

	public StockInfo_BeersWinesSpirits getBeersWinesSpirits() {
		return beersWinesSpirits;
	}

	public void setBeersWinesSpirits(StockInfo_BeersWinesSpirits beersWinesSpirits) {
		this.beersWinesSpirits = beersWinesSpirits;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StockInfo_Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(StockInfo_Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	@Override
	public String toString() {
		return "StockInfo_ProductPojo [gtins=" + gtins + ", itemNumber=" + itemNumber + ", supplySource=" + supplySource
				+ ", components=" + components + ", vatRate=" + vatRate + ", isCatchWeight=" + isCatchWeight
				+ ", storage=" + Arrays.toString(storage) + ", cafeSelfServe=" + cafeSelfServe + ", forceEnterPrice="
				+ forceEnterPrice + ", unitEquivalentPrice=" + unitEquivalentPrice + ", commercialHierarchy="
				+ commercialHierarchy + ", netContent="
				+ netContent + ", magazines=" + magazines + ", itemDescription=" + itemDescription + ", brand=" + brand
				+ ", productType=" + productType + ", vatCode=" + vatCode + ", marketStreet=" + marketStreet
				+ ", productMarketing=" + productMarketing + ", stockAccountingMethod=" + stockAccountingMethod
				+ ", nutritionalHeading=" + nutritionalHeading + ", parentItemNumber=" + parentItemNumber
				+ ", sellingUnitOfMeasure=" + sellingUnitOfMeasure + ", legacyItemNumbers="
				+ Arrays.toString(legacyItemNumbers) + ", packs=" + Arrays.toString(packs)
				+ ", customerFriendlyDescription=" + customerFriendlyDescription + ", sellBy=" + sellBy
				+ ", priceMarked=" + priceMarked + ", countryOfOrigin=" + countryOfOrigin + ", tillDescription="
				+ tillDescription + ", beersWinesSpirits=" + beersWinesSpirits + ", status=" + status + ", dimensions="
				+ dimensions + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
