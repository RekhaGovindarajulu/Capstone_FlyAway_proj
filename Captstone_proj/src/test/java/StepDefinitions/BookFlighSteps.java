package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;
import utils.dbUtil;

public class BookFlighSteps extends DriverManager {

	// hooks
	@Before
	public void setupDriver() throws ClassNotFoundException, SQLException {
		setup();
		dbUtil.dbConnect();
	}

	@After
	public void cleanUp() {
		teardown();
		dbUtil.dbClose();
	}

	@Given("User is on the Flyaway homepage")
	public void user_is_on_the_flyaway_homepage() {
		String homeUrl = "http://localhost:8080/FlyAway/";
		assertEquals(loginPage.getUrl(), homeUrl);
	}

	@When("User clicks on LoginSignup")
	public void user_clicks_on_login_signup() {
		homePage.clickLoginSignup();
	}

	@Then("User is navigated to login page")
	public void user_is_navigated_to_login_page() {
		System.out.println("Navigated to login page");
	}

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		String title = "Fly Away - Login";
		assertEquals(loginPage.getTitle(), title);
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials(DataTable userCred) {
		List<List<String>> data = userCred.cells();
		loginPage.login(data.get(0).get(0), data.get(0).get(1));
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
		String url = "http://localhost:8080/FlyAway/dashboard";
		assertEquals(loginPage.getUrl(), url);
	}

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		loginPage.homePageLink();
	}

	@When("User selects the Source and Destination")
	public void user_selects_the_source_and_destination(DataTable cityName) {
		List<List<String>> data = cityName.cells();
		homePage.selectCity(data.get(0).get(0), data.get(0).get(1));
	}

	@When("Clicks on Book Flight and confirms booking details")
	public void confirmBooking() {
		homePage.bookFlight();
	}

	@Then("Flight booking should be successful")
	public void flight_booking_should_be_successful() {
		String title = "Fly Away - Booking Confirmation";
		assertEquals(homePage.getPageTitle(), title);
	}

	@When("User clicks on New Signup")
	public void newSignup() {
		loginPage.newMemberSignup();
	}

	@When("User enters the details")
	public void user_enters_the_details(DataTable userDetails) {
		List<List<String>> data = userDetails.cells();
		signupPage.userEmail(data.get(1).get(1), data.get(2).get(1));
		signupPage.userName(data.get(4).get(1));
		signupPage.userAddress(data.get(5).get(1), data.get(6).get(1));
	}

	@When("User clicks on Signup button")
	public void user_clicks_on_signup_button() {
		signupPage.signup();
	}

	@Then("User registration should be successful {string}")
	public void user_registration_should_be_successful(String emailID) throws SQLException {
		String title = "Fly Away - Register";
		assertEquals(signupPage.getTitle(), title);
		dbUtil.dbQuery(emailID);
	}

}
