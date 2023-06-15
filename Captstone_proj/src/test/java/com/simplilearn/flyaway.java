package com.simplilearn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class flyaway {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/FlyAway/login");
	}
	
	@AfterMethod
	public void teardown() {
	//	driver.quit();
	}
	
	@Test
	public void flight() throws InterruptedException {
		
		Select source = new Select(driver.findElement(By.name("source")));
		source.selectByVisibleText("Hyderabad");
		Select destination = new Select(driver.findElement(By.name("destination")));
		destination.selectByVisibleText("Bangalore");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("//a[contains(text(), 'Book Flight')][1]")).click();
		
		if(driver.getPageSource().contains("Error, You need to login before booking a flight")==true)
		{
			System.out.println("Login before booking");
		}
		
	}
	
	@Test
	public void login() throws InterruptedException {
		
//		rek@gmail.com abc123 tomcat-login
		driver.findElement(By.xpath("//a[contains(text(), 'Login')]")).click();
		driver.findElement(By.xpath("//input[@name='email_id']")).sendKeys("rek@gmail.com");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
		
		Thread.sleep(5000);
		
		
	}
	
	
}
