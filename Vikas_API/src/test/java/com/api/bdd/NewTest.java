package com.api.bdd;



import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NewTest  {
	
	Response response;
	static int pid;
	static String pname,paddress,pcountry;
    
	
	
	@Given("^Create the post method for publisher \"([^\"])\",\"([^\"])\",\"([^\"]*)\"$")
    public void create_the_post_method_for_publisher(String publisherName, String address, String country) {
    	

		Map<String,Object> request = new HashMap<String,Object>();
		request.put( "publisherName", publisherName);
		request.put( "address", address);
		request.put( "country", country);
		
		JSONObject Jsonreq = new JSONObject(request);
		
		baseURI	= "http://localhost:8080/";

		response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Content-Type","application/JSON")
			.body(Jsonreq.toJSONString())
		.when()
			.post("/publishers/publisher")
		.then()
			.statusCode(200)
			.log().all()
			.contentType(ContentType.JSON).extract().response();
		
		String Res = response.asString();
		JsonPath jp=new JsonPath(Res);
		pid=jp.getInt("publisherId");
		pname = jp.get("publisherName");
		paddress = jp.get("address");
		pcountry = jp.get("country");
        System.out.println("publisher Id created : "+pid);

    	//Validations:
        int publisher_Id = response.jsonPath().getInt("publisherId");
        Assert.assertEquals(publisher_Id, pid);
        
        String publisher_Name = response.jsonPath().getString("publisherName");
        Assert.assertEquals(publisher_Name, pname);
        
        String add_ress = response.jsonPath().getString("address");
        Assert.assertEquals(add_ress, paddress);
        
        String coun_try = response.jsonPath().getString("country");
        Assert.assertEquals(coun_try, pcountry);
    	
    	
    }