package com.morrisons.sma.step_definitions.mobile;

import com.morrisons.sma.page_objects.mobile.old.TimeChangePO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;

public class TimeChangeStepDefUI {
	public static String hourss;
	public static String minss;
	public static String meridiems;
	public static String dte;

	TimeChangePO implemented = new TimeChangePO();

	
	@Given("I send the time {string} and mins {string} and meridiem {string} and current date in list")
	public void i_send_the_time_and_mins_and_meridiem_and_date_in_list(String hrs, String min, String mer) throws Throwable {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		String date = String.valueOf(localDateTime.getDayOfMonth());
			
		hourss = hrs;
		minss = min;
		meridiems = mer;
		implemented.getDetails(hourss, minss, meridiems, date);
	}
	
	@Given("I send the time {string} and month {string} and year {string}")
	public void i_send_the_time_and_month_and_year(String date, String month, String year) throws Throwable {
		dte = date;
		month = month;
		year = year;
		implemented.getDetailss(dte, month, year);
	}
	

	@Then("I Change time")
	public void i_Change_time() throws Throwable {
		 implemented.changeTime();
	}
	
	
	@Then("I Change date")
	public void i_Change_date() throws Throwable {
		implemented.changedate();
	}

}
