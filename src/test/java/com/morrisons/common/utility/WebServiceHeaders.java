package com.morrisons.common.utility;

public class WebServiceHeaders {
	
	public String Key;
	public String Value;
	public String Key1;
	public String Value1;
	public String Key2;
	public String Value2;
	
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
	public String getKey1() {
		return Key1;
	}
	public void setKey1(String key1) {
		Key1 = key1;
	}
	public String getValue1() {
		return Value1;
	}
	public void setValue1(String value1) {
		Value1 = value1;
	}
	public String getKey2() {
		return Key2;
	}
	public void setKey2(String key2) {
		Key2 = key2;
	}
	public String getValue2() {
		return Value2;
	}
	public void setValue2(String value2) {
		Value2 = value2;
	}
	
	@Override
	public String toString() {
		return "WebServiceHeaders [Key=" + Key + ", Value=" + Value + ", Key1=" + Key1 + ", Value1=" + Value1
				+ ", Key2=" + Key2 + ", Value2=" + Value2 + "]";
	}
	
}