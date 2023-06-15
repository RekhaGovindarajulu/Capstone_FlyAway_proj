package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {

	// page locators
	private By emailID = By.name("email_id");
	private By password = By.name("pwd");
	private By confirmPwd = By.name("pwd2");
	private By name = By.name("name");
	private By address = By.name("address");
	private By city = By.name("city");
	private By signup = By.xpath("//button[text()='Signup']");

	// constructor
	public SignupPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	// page methods
	public void userEmail(String id, String pwd) {
		setText(emailID, id);
		setText(password, pwd);
		setText(confirmPwd, pwd);
	}

	public void userName(String uname) {
		setText(name, uname);
	}

	public void userAddress(String add, String cname) {
		setText(address, add);
		setText(city, cname);	
	}

	public void signup() {
		clickElement(signup);	
	}
	
	public String getUrl() {
		String pageUrl = getCurrentPageUrl();
		return pageUrl;
	}
	
	public String getTitle() {
		String pageTitle = getCurrentPageTitle();
		return pageTitle;
	}
	

}
