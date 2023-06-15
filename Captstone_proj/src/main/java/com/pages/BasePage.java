package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public BasePage(ThreadLocal<WebDriver> driver) {
		tdriver = driver;
	}
	
	protected void clickElement(By element){
		tdriver.get().findElement(element).click();
	}
	
	protected void setText(By element, String text){
		tdriver.get().findElement(element).sendKeys(text);
	}
	
	protected String getCurrentPageUrl(){
		return tdriver.get().getCurrentUrl();
	}
	
	protected String getCurrentPageTitle(){
		return tdriver.get().getTitle();
	}
	
	protected void selectFromTo(By element1, By element2, String src, String dest) {
		Select source = new Select(tdriver.get().findElement(element1));
		source.selectByVisibleText(src);
		Select destination = new Select(tdriver.get().findElement(element2));
		destination.selectByVisibleText(dest);
	}
	
		
}
