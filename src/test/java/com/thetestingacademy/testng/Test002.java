package com.thetestingacademy.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Test002 {
    //Put Request

    //Before - token, ID

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token;
    public void getToken(){

        requestSpecification = RestAssured.given();

        String payload = "{\n" +
                "  \"username\" : \"admin\",\n" +
                "   \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);


        Response response = requestSpecification.post();
        validatableResponse = response.then();
        validatableResponse.body("token", Matchers.notNullValue());
  //MATCHERS,TESTNG,ASSERTJ ASSERTIONS
        token = response.then().log().all().extract().path("token");
        System.out.println(token);













    }

    @Test
    public void nonBDDStylePutRequest()
    {

    }


}
