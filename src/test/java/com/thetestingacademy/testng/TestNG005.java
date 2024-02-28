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

import static org.assertj.core.api.Assertions.assertThat;

public class TestNG005 {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;
    @BeforeTest
    public void getToken()
    {
        System.out.println("--get token");
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

    @BeforeTest
    public void getBookingId()
    {
        System.out.println("--get booking id");


        RequestSpecification r= RestAssured.given();

        String payload = "{\n" +
                "    \"firstname\": \"Ansh\",\n" +
                "    \"lastname\": \"G\",\n" +
                "    \"totalprice\": 1000,\n" +
                "    \"depositpaid\": 1000,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    }\n" +
                "}";



        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        //Actual making of request
        Response response  = r.when().post();

        //Validation Part
        ValidatableResponse validatableresponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableresponse.statusCode(200);
        //validatableresponse.body("token", Matchers.notNullValue());

        bookingId = response.then().log().all().extract().path("bookingid");
        System.out.println(bookingId);


    }
    @Test
    public void testPutRequest()
    {
        System.out.println("Test case Full Put Request");

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
        requestSpecification.basePath("booking/" + bookingId);
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

    @Test
    public void testPutRequest2(){

        System.out.println("First name");

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
        requestSpecification.basePath("booking/" + bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);


        requestSpecification.body(payload).log().all();

        //calling put method in URI ,AFTER hitting we get response

        Response response = requestSpecification.when().put();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        //validatableResponse.body("firstname", Matchers.equalTo("Anshu"));
        //validatableResponse.body("lastname",Matchers.equalTo("Ganti"));

        String firstname = response.then().log().all().extract().path("firstname");

        assertThat(firstname).isNotNull().isNotBlank().isNotEmpty();

        System.out.println(firstname);
    }

}
