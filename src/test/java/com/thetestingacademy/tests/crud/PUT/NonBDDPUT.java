package com.thetestingacademy.tests.crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPUT {
   RequestSpecification requestSpecification;
   ValidatableResponse validatableResponse;

   String token  = "479e46a24d798cd";


   @Test
    public void testPutRequest(){
        //url
        //auth - token --"3dc720bce755354"
        //header
        //id --1577
        //payload

        String payload = "{\n" +
                "    \"firstname\" : \"Anshu\",\n" +
                "    \"lastname\" : \"Ganti\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
      requestSpecification = RestAssured.given();
      requestSpecification.baseUri("https://restful-booker.herokuapp.com");
      requestSpecification.basePath("booking/1577");
      requestSpecification.contentType(ContentType.JSON);
      requestSpecification.cookie("token",token);


      requestSpecification.body(payload).log().all();

      //calling put method in URI ,AFTER hitting we get response

        Response response = requestSpecification.when().put();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Anshu"));
        validatableResponse.body("lastname",Matchers.equalTo("Ganti"));

    }

}
