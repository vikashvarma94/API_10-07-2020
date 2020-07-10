package com.api.bdd;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.api.dataprovider.jsonbody_input;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class bdd_POST {
	
	public static HashMap map = new HashMap();
	
	  @Test(dataProvider ="put", dataProviderClass = jsonbody_input.class)
	  
	  public void b(String endpoint,String req, String id, String email, String name) {
		  
		  map.put("id",id );
		  map.put("email",email);
		  map.put("first_name",name);
		  
		  JSONObject js = new JSONObject(map);
		  
		  RestAssured.baseURI = endpoint;
		  RestAssured.basePath = req;
		  
		  
		 Response rsp = given()
		  	.contentType("application/Json")	
		  	.body(js.toJSONString())
		  .when()
		  	.post(endpoint+req)
		  .then()
		  	.statusCode(201).log().all().extract().response();  
	 }
}
