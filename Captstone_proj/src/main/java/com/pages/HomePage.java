package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	// page locators
	private By loginSignup = By.xpath("//a[text()='Login/Signup']");
	private By sourceCity = By.name("source");
	private By destCity = By.name("destination");
	private By submitBtn = By.xpath("//button[text()='Submit']");
	private By bookFlightLink = By.xpath("//a[text()='Book Flight']");
	private By confirmBooking = By.xpath("//a[text()='Click to complete booking']");
	
	// constructor
	public HomePage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	// page methods
	public void clickLoginSignup() {
		clickElement(loginSignup);
	}

	public void selectCity(String src, String dest) {
		selectFromTo(sourceCity, destCity, src, dest);
		clickElement(submitBtn);
	}
	
	public void bookFlight() {
		clickElement(bookFlightLink);
		clickElement(confirmBooking);
	}
	
	public String getPageTitle() {
		return getCurrentPageTitle();
	}
	
	
}
