package RestAPISample;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataProvider.fetchDataFromExcel;

import static io.restassured.RestAssured.given; 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONBodyExample {

		
	@Test(enabled = true, dataProvider = "fetchDataFromExcel")
	public void AssingmentTestCase1(String Name, String PhotoURLs, String CategoryId, String Status, String CategoryName) throws JsonProcessingException, InterruptedException {
		
		RestAssured.baseURI = "http://localhost:3000";
		
		JSONObject jsonBody = new JSONObject();
		List<String> photoUrls = new ArrayList<String>();
		List<category> Tags = new ArrayList<category>();
		
		photoUrls.add(PhotoURLs);
	//	photoUrls.add("Covidshield");
	//	photoUrls.add("Pfizer");
			
		rootBody rootbody = new rootBody();
		category categorybody = new category();
		
		rootbody.setId(0);
		rootbody.setName(Name);
		rootbody.setStatus(Status);
		rootbody.setPhotoURL(photoUrls);

		categorybody.setId(CategoryId);
		categorybody.setName(CategoryName);
		
		Tags.add(categorybody);
		
		rootbody.setCategory(categorybody);
		rootbody.setTags(Tags);
		
		ObjectMapper mapperObject = new ObjectMapper();
		String jsonBody1 = mapperObject.writerWithDefaultPrettyPrinter().writeValueAsString(rootbody);
		System.out.println(jsonBody1);
		
		given().contentType(ContentType.JSON).
		body(jsonBody1).
		when().post("/Students").
		then().statusCode(201).log().all();

		Thread.sleep(3000);
	}
	
	@DataProvider(name = "fetchDataFromExcel")
	public Object[][] exceldata() throws IOException {
		Object[][] data = fetchDataFromExcel.gettestdata();
		System.out.println(data);

		return data;

	}
	
	@Test(enabled = false)
	public void soapExample() throws IOException {
		
		RestAssured.baseURI = "http://www.dneonline.com/";
		
		FileInputStream fInput = new FileInputStream(".\\payload\\AddIntegers.xml");
		
		given().headers("content-type","text/xml").
		body(IOUtils.toString(fInput,"UTF-8")).
		when().
			post("/calculator.asmx").
		 then().
		 	log().all();
		
	}
}
