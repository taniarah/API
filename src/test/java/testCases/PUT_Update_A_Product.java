package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PUT_Update_A_Product {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void update_A_product() {
		
		

		Response response = 
			given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.headers("Content-Type", "application/json; charset=UTF-8")
				.body(new File(".\\src\\main\\java\\data\\updatePayload.json")).
			when()
				.put("/update.php").
			then()
				.extract().response();

		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);

//		// Parsing responseBody to Json:
//		JsonPath jp = new JsonPath(responseBody);
//		String productId = jp.getString("id");
//		// Assert.assertEquals(productId, "2161");
//		softAssert.assertEquals(productId, "2160", "Product Id is not matching!");
//		System.out.println("*****Product Id*****:" + productId);
//
//		String productName = jp.getString("name");
//		// Assert.assertEquals(productName, "Cooling Fan");
//		softAssert.assertEquals(productName, "Cooling Fan", "Product name is not matching!");
//		System.out.println("****Product Name****: " + productName);
//
//		String productPrice = jp.getString("price");
//		// Assert.assertEquals(productPrice, "99");
//		softAssert.assertEquals(productPrice, "99", "Product price is not matching!");
//		System.out.println("****Product Price****: " + productPrice);
//
//		// int actualStatusCode = response.getStatusCode();
//		// Assert.assertEquals(actualStatusCode, 200);
//
//		// long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		// System.out.println("Response Time: " + responseTime);
//		// if(responseTime<=2000) {
//		// System.out.println("Within the range.");
//		// }else {
//		// System.out.println("Out of range.");
//		// }
//
//		softAssert.assertAll();

	}

}
