package com.simplilearn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.SignupPage;

import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class flyaway1 {

	WebDriver driver;
	SignupPage signup;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/FlyAway/signup");
	}
	
	@AfterMethod
	public void teardown() {
	//	driver.quit();
	}
	
	@Test
	public void signUp() throws InterruptedException {
		
	//	SignupPage signup = new SignupPage(driver);
		signup.userEmail("john@gmail.com", "1234");	
		signup.userName("John");
		signup.userAddress("#10, WestPark", "NewYork");
		signup.signup();
	}
	
}
