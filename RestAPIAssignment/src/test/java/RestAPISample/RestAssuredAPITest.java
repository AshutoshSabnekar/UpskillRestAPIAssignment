package RestAPISample;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given; 
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredAPITest {
	
/*	@Test
	public void firstTest()
	{
		Response object = RestAssured.get("https://petstore.swagger.io/v2/pet/9222968140497212000");
		System.out.println("Status Code :"+object.statusCode());
		
		System.out.println("Response body :"+object.asString());
		
	//	System.out.println("Pretty Response body :"+object.prettyPrint());
		
		System.out.println("Status Line :"+object.statusLine());
		
	//	Response object1 = RestAssured.delete("https://petstore.swagger.io/v2/pet/9223372036854775807");
	//	System.out.println("Status Line :"+object1.statusLine());
		
	}
	
	@Test
	public void secondTest()
	{
	
		given().get("https://petstore.swagger.io/v2/pet/9222968140497212000").
		then().statusCode(404);
	}
	
	@Test
	public void postTest()
	{
		String payLoad = "{\"stream\":\"SDET\",\"firstName\":\"Amit\",\"lastName\":\"Luthra\"}";
		
		System.out.println(payLoad);
		
		given().headers("content-type","application/json").body(payLoad).
		when().post("http://localhost:3000/students").
		then().statusCode(201).log().all();
		
	}
	
	
	@Test
	public void putTest()
	{
		String payLoad = "{\"stream\":\"Cucumber\",\"firstName\":\"Amit\",\"lastName\":\"Luthra\"}";
		
		System.out.println(payLoad);
		
		given().headers("content-type","application/json").body(payLoad).
		when().put("http://localhost:3000/students/3").
		then().statusCode(200).log().all();
		
	}
	
	@Test
	public void patchPutTest()
	{
		String payLoad = "{\"stream\":\"Rest API\"}";
		
		System.out.println(payLoad);
		
		given().headers("content-type","application/json").body(payLoad).
		when().patch("http://localhost:3000/students/2").
		then().statusCode(200).log().all();
		
	}
	
	@Test
	public void getTest()
	{
	//	String payLoad = "{\"stream\":\"Rest API\"}";
		
	//	System.out.println(payLoad);
		
		given().get("http://localhost:3000/students/2").
		then().statusCode(200).log().all();
	}
	
	@Test
	public void deleteTest()
	{	
		given().delete("http://localhost:3000/students/2").
		then().statusCode(200).log().all();
	}
*/	
	@Test
	public void getResponseTest()
	{
		Response obj = given().get("http://localhost:3000/students/3").
		then().statusCode(200).log().all().extract().response();
		
		String responseString = obj.jsonPath().getString("firstName");
		System.out.println(responseString);
	}

}
