package com.API;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FlightAPI {

	@BeforeMethod
	public void login() {

		RestAssured.baseURI = "http://localhost:8080/FlyAway";

		RequestSpecification req = RestAssured.given().log().all().queryParam("email_id", "rek1@gmail.com")
				.queryParam("pwd", "abc123").header("Content-Type", "application/json");

		Response response = req.post("/loginaction");

		System.out.println("***StatusCode***" + response.getStatusCode());
	}

	@Test
	public void searchFlight() {

		RestAssured.baseURI = "http://localhost:8080/FlyAway";

		RestAssured.given().log().all().get("/?source=1&destination=11").then().statusCode(200).log().all();
	}

	@Test
	public void getBookingList() {
		RestAssured.baseURI = "http://localhost:8080/FlyAway";
		
		RequestSpecification req = RestAssured.given().log().all().queryParam("user_id", "8");

		Response response = req.get("/memberbookings");
		System.out.println(response.asString());
		

		//RestAssured.given().log().all().get("/memberbookings").then().statusCode(200).log().all();
	}

}
