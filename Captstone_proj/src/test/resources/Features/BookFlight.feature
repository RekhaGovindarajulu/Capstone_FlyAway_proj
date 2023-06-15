Feature: Login page feature

Background:
Given User is on the Flyaway homepage
When User clicks on LoginSignup
Then User is navigated to login page

  Scenario: Login with valid user credentials and book the flight
    Given User is on the login page
    When User enters valid credentials
    |rek1@gmail.com|abc123|
    Then User should be able to login successfully
    Given User is on the home page
    When User selects the Source and Destination
    | Bangalore | Hyderabad |
    And Clicks on Book Flight and confirms booking details
    Then Flight booking should be successful
    
  Scenario: New user registration
    Given User is on the login page
    When User clicks on New Signup
    And User enters the details
    | Fields                 | Values        |
		| Email_id 		           | arya@gmail.com |
		| Password	             | abc123        |
		| Confirm password       | abc123 |
		| Name									 | Arya |
		| Address	               | xxx |
		| City		               | London |
		And User clicks on Signup button
    Then User registration should be successful "arya@gmail.com"
    