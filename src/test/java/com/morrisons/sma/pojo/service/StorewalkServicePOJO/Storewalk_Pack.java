package com.morrisons.sma.pojo.service.StorewalkServicePOJO;

public class Storewalk_Pack {

	
    public String pin;
    public String weight;
    public String quantity;
    
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CreateWalkitem_Pack [pin=" + pin + ", weight=" + weight + ", quantity=" + quantity + "]";
	}
    
    
}
