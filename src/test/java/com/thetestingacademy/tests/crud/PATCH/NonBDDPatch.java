package com.thetestingacademy.tests.crud.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPatch {
   RequestSpecification requestSpecification;
   ValidatableResponse validatableResponse;

   String token  = "66918c13ac9679f";


   @Test
    public void testPatchRequest(){
        //url
        //auth - token --"3dc720bce755354"
        //header
        //id --992
        //payload

       String payloadPATCH = "{\n" +
               "    \"firstname\" : \"Surekha\",\n" +
               "    \"lastname\" : \"Ganti\"\n" +
               "}";

       requestSpecification = RestAssured.given();
       requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
       requestSpecification.basePath("booking/776");
       requestSpecification.contentType(ContentType.JSON);
       requestSpecification.cookie("token",token);

       //requestSpecification.body(payload).log().all();
       // Patch Request
       requestSpecification.body(payloadPATCH).log().all();


       // Calling PUT method on URI. After hitting we get Response
//        Response response = requestSpecification.when().put();

       Response response = requestSpecification.when().patch();


       // Get Validatable response to perform validation
       validatableResponse = response.then().log().all();


       validatableResponse.statusCode(200);
       validatableResponse.body("firstname", Matchers.equalTo("Surekha"));
       validatableResponse.body("lastname", Matchers.equalTo("Ganti"));


   }

}
