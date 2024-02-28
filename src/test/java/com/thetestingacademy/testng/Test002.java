package com.thetestingacademy.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Test002 {
    //Put Request

    //Before - token, ID

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token;
    @BeforeTest
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
        //MATCHERS,
        validatableResponse.body("token", Matchers.notNullValue());


        // TESTNG-ASSERT ASSERTIONS
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);


        //Assertj Assertions
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();


        System.out.println(token);

    }

    @Test
    public void nonBDDStylePutRequest()
    {
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
        requestSpecification.basePath("booking/4330");
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
