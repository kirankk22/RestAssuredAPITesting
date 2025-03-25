package in.at.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class RestAssuredPOSTRequest {
	@Test
	public void addProductUsingJSONAsString() {
		
		//way-1
		String jsonRequestBodyAsString = "{ "
				+ "\"title\" : \"Laptop\","
				+ "\"price\" : \"100\","
				+ "\"description\" : \"Best Laptop\","
				+ "\"category\" : \"electronics\""
				+ "}";
		
//		RestAssured.baseURI="https://fakestoreapi.com/products";
//		RequestSpecification requestSpec = RestAssured.given();
//		requestSpec.contentType(ContentType.JSON);
//		requestSpec.body(jsonRequestBodyAsString);
//		
//		Response response = requestSpec.post();
//		System.out.println(response.getBody().asPrettyString());
		
		//way-2
		given()
			.contentType(ContentType.JSON)
			.body(jsonRequestBodyAsString)
		.when()
			.post("https://fakestoreapi.com/products")
		.then()
			.log().body();
					
	}
	
	@Test
	public void addProductUsingMap() {
		// way-1
		// add gson dependency in pom.xml
		
		Map<String, String> jsonRequestBodyAsMap = new HashMap();
		jsonRequestBodyAsMap.put("title", "Laptop");
		jsonRequestBodyAsMap.put("price", "150");
		jsonRequestBodyAsMap.put("description", "Best Laptop");
		jsonRequestBodyAsMap.put("category", "electronics");
		
		RestAssured.baseURI = "https://fakestoreapi.com/products";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonRequestBodyAsMap);
		
		Response response = requestSpec.post();
		System.out.println(response.getBody().asPrettyString());
		
	}

}
