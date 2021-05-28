package Phase1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request_ValidateReponse {

	@Test
	public void Get_API_Response_1() {
		
		
		RestAssured.baseURI = "https://reqres.in/";
	
		RequestSpecification request = RestAssured.given();
		
		request.header("content-type", "application/json");
		request.param("page", "2");
		
		
	Response res =	request.get("/api/users");
	
	//System.out.println(res.asPrettyString());
	
	//int page = res.jsonPath().getInt("page");
	String page = res.jsonPath().getString("page");
	System.out.println("Value of page is ----> "+ page);
	int per_page = res.jsonPath().getInt("per_page");
	System.out.println("Value of per_page is ----> "+ per_page);
	
	String first_name = res.jsonPath().getString("data[1].first_name");
	
	System.out.println("Value of first_name is ----> "+ first_name);
	
	}
}
