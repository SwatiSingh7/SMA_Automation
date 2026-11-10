package com.morrisons.sma.pojo.service.CleanNRotateServicePOJO;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class CnR_Links {


	private String next;
	private String current;
	private String previous;
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
		return "Links [next=" + next + ", current=" + current + ", previous=" + previous + "]";
	}	
}
