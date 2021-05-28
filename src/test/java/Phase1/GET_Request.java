package Phase1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request {
	
	
	@Test
	public void GetAPI1() {
		
		
		RestAssured.baseURI = "https://reqres.in/";
		
		//GIVEN -> header, param, body, authenitcation
		//WHEN  -> GET/POST/PUT/DELETE
		//THEN  -> response
		
		RestAssured.given().header("content-type", "application/json").param("page", "2")
		.when().get("/api/users")
		.then().log().all();
		
	}
	
	@Test
	public void GetAPI2() {
		
		
		RestAssured.baseURI = "https://reqres.in/";
	
		
	Response res =	RestAssured.given().header("content-type", "application/json").param("page", "2")
		.when().get("/api/users");
	
	//System.out.println(res.getBody().asString()); 
	//System.out.println(res.asPrettyString());
	System.out.println(res.getStatusCode());
	System.out.println(res.getHeader("Vary"));
	System.out.println(res.getTime());
		
	}
	
	@Test
	public void GetAPI3() {
		
		
		RestAssured.baseURI = "https://reqres.in/";
	
		RequestSpecification request = RestAssured.given();
		
		request.header("content-type", "application/json");
		request.param("page", "2");
		
		
	Response res =	request.get("/api/users");
	
	//System.out.println(res.getBody().asString()); 
	//System.out.println(res.asPrettyString());
	System.out.println(res.getStatusCode());
	System.out.println(res.getHeader("Vary"));
	System.out.println(res.getTime());
		
	}

}
