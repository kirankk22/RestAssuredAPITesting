package in.at.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class RestAssuredGETAPITests {

	public static void main(String[] args) {
		// way1
//		RestAssured.baseURI = "https://fakestoreapi.com/products";
//		RequestSpecification requestSpec = RestAssured.given();
//		Response response = requestSpec.get();
//		
//		System.out.println(response.asPrettyString());
		
		//way2
//		RestAssured.baseURI = "https://fakestoreapi.com/products";
//		RequestSpecification requestSpec = RestAssured.given();
//		Response response = requestSpec.request(Method.GET);
//		
//		System.out.println(response.asPrettyString());
		
		//way3
		given()
			.when()
				.get("https://fakestoreapi.com/products")
			.then()
				.log().all();
		
		

	}

}
