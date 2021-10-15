package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GET_Read_A_Product {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void read_A_product() {
		// https://techfios.com/api-prod/api/product/read_one.php?id=2160
		// given: all input details(base URL/ base
		// URI,Headers,Payload/Body,QueryParameters)
		// when: submit api request(Http method,Endpoint/Resourse)
		// then: validate response(status code, Headers, responseTime, Payload/Body)

		Response response = given().baseUri("https://techfios.com/api-prod/api/product")
				.headers("Content-Type", "application/json").queryParam("id", "2168").when().get("read_one.php").then()
				.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
		
		//Parsing responseBody to Json:
		JsonPath jp = new JsonPath(responseBody);
		String productId = jp.getString("id");
		//Assert.assertEquals(productId,  "2168");
		softAssert.assertEquals(productId, "2168", "Product Id is not matching!");
		System.out.println("*****Product Id*****:" + productId);
		
		String productName = jp.getString("name");
		//Assert.assertEquals(productName,  "Cooling Fan");
		softAssert.assertEquals(productName, "Cooling Fan", "Product name is not matching!");
		System.out.println("****Product Name****: " + productName);
		
		String productPrice = jp.getString("price");
		//Assert.assertEquals(productPrice, "99");
		softAssert.assertEquals(productPrice, "99", "Product price is not matching!");
		System.out.println("****Product Price****: " + productPrice);
		
		
		// int actualStatusCode = response.getStatusCode();
		// Assert.assertEquals(actualStatusCode, 200);

		// long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		// System.out.println("Response Time: " + responseTime);
		// if(responseTime<=2000) {
		// System.out.println("Within the range.");
		// }else {
		// System.out.println("Out of range.");
		// }

		 softAssert.assertAll();

	}

}
