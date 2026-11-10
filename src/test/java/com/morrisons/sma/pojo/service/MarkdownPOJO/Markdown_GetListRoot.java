package com.morrisons.sma.pojo.service.MarkdownPOJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Markdown_GetListRoot {

	@JsonProperty("MyArray") 
	public List<Markdown_GetList> myArray;

	public List<Markdown_GetList> getMyArray() {
		return myArray;
	}

	public void setMyArray(List<Markdown_GetList> myArray) {
		this.myArray = myArray;
	}

	@Override
	public String toString() {
		return "Markdown_GetListRoot [myArray=" + myArray + "]";
	}
}