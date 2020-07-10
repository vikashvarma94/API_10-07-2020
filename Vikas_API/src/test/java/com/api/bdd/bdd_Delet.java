package com.api.bdd;

import org.testng.annotations.Test;

import com.api.dataprovider.data;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class bdd_Delet {


	@Test(dataProvider = "input", dataProviderClass = data.class)
	  public void b(String endpoint,String req,String code, String line) throws InterruptedException {
		  
		Response res =  given()
		  	.when().delete(endpoint+req)
		  	.then().statusCode(200).statusLine(line).log().all()
			.extract().response();
		//System.out.println(res);
	}
}