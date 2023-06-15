package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignupPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	protected HomePage homePage;
	protected LoginPage loginPage;
	protected SignupPage signupPage;
	
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		driver.get().get("http://localhost:8080/FlyAway/");
		
		initializePageObjects();
		
	}

	public void teardown() {
		driver.get().quit();
	}

	public void initializePageObjects() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		signupPage = new SignupPage(driver);
	}
	
}
