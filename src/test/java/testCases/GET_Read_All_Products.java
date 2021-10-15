package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class GET_Read_All_Products {

	@Test
	public void get_Read_All_products(){
		//https://techfios.com/api-prod/product/read.php
		//given: all input details(base URL/ base URI,Headers,Payload/Body,QueryParameters)
		//when: submit api request(Http method,Endpoint/Resourse)
		//then: validate response(status code, Headers, responseTime, Payload/Body)
		
		Response response =
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.headers("Content-Type","application/json").
		when()
			.get("/read.php").
		then().extract().response();
	
		//System.out.println()response);
		response.getBody().prettyPrint();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
}
