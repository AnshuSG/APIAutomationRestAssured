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

   String token  = "82b437e20d34702";


   @Test
    public void testPatchRequest(){
        //url
        //auth - token --"3dc720bce755354"
        //header
        //id --992
        //payload

        String payload = "{\n" +
                "    \"firstname\" : \"Surekha\",\n" +
                "    \"lastname\" : \"ganti\"\n" +
                "}";
      requestSpecification = RestAssured.given();
      requestSpecification.baseUri("https://restful-booker.herokuapp.com");
      requestSpecification.basePath("booking/992");
      requestSpecification.contentType(ContentType.JSON);
      requestSpecification.cookie("token",token);


      requestSpecification.body(payload).log().all();

      //calling put method in URI ,AFTER hitting we get response

        Response response = requestSpecification.when().patch();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Surekha"));
        validatableResponse.body("lastname",Matchers.equalTo("ganti"));

    }

}
