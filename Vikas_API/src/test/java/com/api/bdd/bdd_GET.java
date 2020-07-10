package com.api.bdd;

import org.testng.annotations.Test;

import com.api.dataprovider.data;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class bdd_GET {


	@Test(dataProvider = "input", dataProviderClass = data.class)
	  public void b(String endpoint,String req,String code, String line) throws InterruptedException {
		  
		Response res =  given()
		  	.when().get(endpoint+req)
		  	.then().statusCode(200).statusLine(line)
		  	.body("RestResponse.data.id", equalTo(7))
			.log().all().contentType(ContentType.JSON).extract().response();
		
		String rp = res.toString();
		JsonPath jp = new JsonPath(rp);
		System.out.println(jp.get("name"));
	}
}