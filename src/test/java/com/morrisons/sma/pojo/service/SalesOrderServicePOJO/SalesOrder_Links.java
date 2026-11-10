package com.morrisons.sma.pojo.service.SalesOrderServicePOJO;

public class SalesOrder_Links {

    public String next;
    public String current;
    public String previous;
    
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	@Override
	public String toString() {
		return "SalesOrder_Links [next=" + next + ", current=" + current + ", previous=" + previous + "]";
	}
    
    
    
}
