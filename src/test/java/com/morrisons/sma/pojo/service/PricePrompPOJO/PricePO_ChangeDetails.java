package com.morrisons.sma.pojo.service.PricePrompPOJO;

public class PricePO_ChangeDetails {
	private String priceChangeDisplayId;

    private String priceChangeId;

    private String state;

    private String transactionId;

    public String getPriceChangeDisplayId ()
    {
        return priceChangeDisplayId;
    }

    public void setPriceChangeDisplayId (String priceChangeDisplayId)
    {
        this.priceChangeDisplayId = priceChangeDisplayId;
    }

    public String getPriceChangeId ()
    {
        return priceChangeId;
    }

    public void setPriceChangeId (String priceChangeId)
    {
        this.priceChangeId = priceChangeId;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getTransactionId ()
    {
        return transactionId;
    }

    public void setTransactionId (String transactionId)
    {
        this.transactionId = transactionId;
    }

	@Override
	public String toString() {
		return "ChangeDetails [priceChangeDisplayId=" + priceChangeDisplayId + ", priceChangeId=" + priceChangeId
				+ ", state=" + state + ", transactionId=" + transactionId + "]";
	}
    
    
}
