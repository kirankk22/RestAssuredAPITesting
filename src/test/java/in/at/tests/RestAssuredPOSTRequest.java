package in.at.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
		
		RestAssured.baseURI="https://fakestoreapi.com/products";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonRequestBodyAsString);
		
		Response response = requestSpec.post();
		System.out.println(response.getBody().asPrettyString());
				
	}

}
