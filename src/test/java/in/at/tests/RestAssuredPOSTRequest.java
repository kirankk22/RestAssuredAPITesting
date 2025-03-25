package in.at.tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testdata.POJOProductRequest;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.naming.ContextNotEmptyException;

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
		
		// add gson dependency in pom.xml
		
		Map<String, String> jsonRequestBodyAsMap = new HashMap();
		jsonRequestBodyAsMap.put("title", "Laptop");
		jsonRequestBodyAsMap.put("price", "150");
		jsonRequestBodyAsMap.put("description", "Best Laptop");
		jsonRequestBodyAsMap.put("category", "electronics");
		
		// way-1
//		RestAssured.baseURI = "https://fakestoreapi.com/products";
//		RequestSpecification requestSpec = RestAssured.given();
//		requestSpec.contentType(ContentType.JSON);
//		requestSpec.body(jsonRequestBodyAsMap);
//		
//		Response response = requestSpec.post();
//		System.out.println(response.getBody().asPrettyString());
		
		// way-2
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonRequestBodyAsMap)
		.when()
			.post("https://fakestoreapi.com/products")
		.then()
			.log().body();
		
		
	}
	
	@Test
	public void addProductUsingJSONObject() {
		
		// add json dependency from org.json
		JSONObject jsonRequestBody = new JSONObject();
		jsonRequestBody.put("title", "Laptop");
		jsonRequestBody.put("price", "200");
		jsonRequestBody.put("description", "Best Laptop");
		jsonRequestBody.put("category", "electronics");
		
		// way-1
//		RestAssured.baseURI = "https://fakestoreapi.com/products";
//		RequestSpecification requestSpec = RestAssured.given();
//		requestSpec.contentType(ContentType.JSON);
//		requestSpec.body(jsonRequestBody.toString());
//		
//		Response response = requestSpec.post();
//		System.out.println(response.getBody().asPrettyString());
		
		//way-2
		given()
			.contentType(ContentType.JSON)
			.body(jsonRequestBody.toString())
		.when()
			.post("https://fakestoreapi.com/products")
		.then()
			.log().body();
	}
	
	@Test
	public void addProductsUsingPOJOClass() {
		POJOProductRequest pojoRequest = new POJOProductRequest();
		pojoRequest.setTitle("Laptop");
		pojoRequest.setPrice("300");
		pojoRequest.setDescription("Best Laptop");
		pojoRequest.setCategory("electronics");
		
		//way-1
//		RestAssured.baseURI = "https://fakestoreapi.com/products";
//		RequestSpecification requestSpec = RestAssured.given();
//		requestSpec.contentType(ContentType.JSON);
//		requestSpec.body(pojoRequest);
//		
//		Response response = requestSpec.post();
//		System.out.println(response.getBody().asPrettyString());
		
		//way-2
		given()
			.contentType(ContentType.JSON)
			.body(pojoRequest)
		.when()
			.post("https://fakestoreapi.com/products")
		.then()
			.log().body();
		
	}
	
	@Test
	public void addProductUsingExternalJSONFile() {
		File requestJSONFile = new File("./product.json");
		
		// way-1
//		RestAssured.baseURI = "https://fakestoreapi.com/products";
//		RequestSpecification requestSpec = RestAssured.given();
//		requestSpec.contentType(ContentType.JSON);
//		requestSpec.body(requestJSONFile);
//		
//		Response response = requestSpec.post();
//		System.out.println(response.getBody().asPrettyString());
		
		//way-2
		given()
			.contentType(ContentType.JSON)
			.body(requestJSONFile)
		.when()
			.post("https://fakestoreapi.com/products")
		.then()
			.log().body();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
