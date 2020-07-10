package com.api.bdd;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class d_get {
  @Test
  public void f() {
	  
	  given().
	  when().get("https://reqres.in/api/user/1").then().statusCode(200).log().all();
  }

//https://reqres.in/api/users
//http://dummy.restapiexample.com/api/v1/employees
@Test
public void g() {
	  
	  given().
	  when().get("http://dummy.restapiexample.com/api/v1/employee/1").then().statusCode(200).log().all();
}
}