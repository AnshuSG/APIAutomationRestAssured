package com.thetestingacademy.tests.crud.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDelete {
   RequestSpecification requestSpecification;
   ValidatableResponse validatableResponse;

   String token  = "15dc6e120a985a3";


   @Test
    public void testDeleteRequest(){
        //url
        //auth - token --"3dc720bce755354"
        //header
        //id --992
        //payload


       requestSpecification = RestAssured.given();
       requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
       requestSpecification.basePath("booking/1572");
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.cookie("token",token);

       //requestSpecification.body(payload).log().all();
       // Patch Request
       //requestSpecification.body(payloadPATCH).log().all();


       // Calling PUT method on URI. After hitting we get Response
//        Response response = requestSpecification.when().put();

       Response response = requestSpecification.when().delete();

       // Get Validatable response to perform validation
       validatableResponse = response.then().log().all();


       validatableResponse.statusCode(201);
       //validatableResponse.body("firstname", Matchers.equalTo("Surekha"));
      // validatableResponse.body("lastname", Matchers.equalTo("Ganti"));


   }

}
