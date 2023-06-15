package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	//page locators
	private By loginBtn =  By.xpath("//button[text()='Login']");
	private By newSignup = By.xpath("//a[text()='Not a member? Signup']");
	private By emailID = By.name("email_id");
	private By password = By.name("pwd");
	private By home = By.xpath("//a[text()='Home']");
	
			
	//constructor
	public LoginPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}
	
	//page methods
	public void login(String id, String pwd) {
		setText(emailID, id);
		setText(password, pwd);
		clickElement(loginBtn);
	}
	
	public void newMemberSignup() {
		clickElement(newSignup);
	}
	
	public String getUrl() {
		String pageUrl = getCurrentPageUrl();
		return pageUrl;
	}
	
	public String getTitle() {
		String pageTitle = getCurrentPageTitle();
		return pageTitle;
	}
	
	public void homePageLink() {
		clickElement(home);
	}
		
}
