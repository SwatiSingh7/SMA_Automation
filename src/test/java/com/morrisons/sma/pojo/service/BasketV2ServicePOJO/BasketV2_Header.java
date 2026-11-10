package com.morrisons.sma.pojo.service.BasketV2ServicePOJO;

public class BasketV2_Header {


	private String organisation;
	private long transactionId;
	private double basketTotal;
	private String cashier;
	private String checkoutDate;
	private Object cardNumber;
	private String accountId;
	private String country;
	private String countryDescription;
	private String currency;
	private boolean isTraining;
	private boolean outputProhibited;
	private long receiptNumber;
	private int storeId;
	private Object storeName;
	private int tillNumber;
	private boolean refundFlag;

	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public double getBasketTotal() {
		return basketTotal;
	}
	public void setBasketTotal(double basketTotal) {
		this.basketTotal = basketTotal;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Object getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Object cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryDescription() {
		return countryDescription;
	}
	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public boolean isTraining() {
		return isTraining;
	}
	public void setTraining(boolean isTraining) {
		this.isTraining = isTraining;
	}
	public boolean isOutputProhibited() {
		return outputProhibited;
	}
	public void setOutputProhibited(boolean outputProhibited) {
		this.outputProhibited = outputProhibited;
	}
	public long getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(long receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public Object getStoreName() {
		return storeName;
	}
	public void setStoreName(Object storeName) {
		this.storeName = storeName;
	}
	public int getTillNumber() {
		return tillNumber;
	}
	public void setTillNumber(int tillNumber) {
		this.tillNumber = tillNumber;
	}
	public boolean isRefundFlag() {
		return refundFlag;
	}
	public void setRefundFlag(boolean refundFlag) {
		this.refundFlag = refundFlag;
	}
	@Override
	public String toString() {
		return "BasketV2_Header [organisation=" + organisation + ", transactionId=" + transactionId + ", basketTotal="
				+ basketTotal + ", cashier=" + cashier + ", checkoutDate=" + checkoutDate + ", cardNumber=" + cardNumber
				+ ", accountId=" + accountId + ", country=" + country + ", countryDescription=" + countryDescription
				+ ", currency=" + currency + ", isTraining=" + isTraining + ", outputProhibited=" + outputProhibited
				+ ", receiptNumber=" + receiptNumber + ", storeId=" + storeId + ", storeName=" + storeName
				+ ", tillNumber=" + tillNumber + ", refundFlag=" + refundFlag + "]";
	}


}
