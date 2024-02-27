package com.thetestingacademy.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePost {
    @Test
    public void testnonBDDStylePost(){


        //preparation of request
        RequestSpecification r= RestAssured.given();

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON).log().all();
                r.body(payload);

                //Actual making of request
                Response response  = r.when().post();

                //Validation Part
        ValidatableResponse validatableresponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableresponse.statusCode(200);
        validatableresponse.body("token", Matchers.notNullValue());







    }


}
