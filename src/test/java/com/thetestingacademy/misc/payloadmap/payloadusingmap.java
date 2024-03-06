package com.thetestingacademy.misc.payloadmap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class payloadusingmap {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
 public void testPostRequest(){
//
//        String payload = "{\n" +
//                "    \"firstname\" : \"Anshu\",\n" +
//                "    \"lastname\" : \"Ganti\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        //Hashmap

     Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();

     Faker faker  = new Faker();
     String name = faker.name().fullName();

     jsonBodyUsingMap.put("firstname",faker.name().firstName());
        jsonBodyUsingMap.put("lastname",faker.name().lastName());
        jsonBodyUsingMap.put("totalprice",faker.random().nextInt(1000));
        jsonBodyUsingMap.put("depositpaid",faker.random().nextBoolean());

        Map<String,Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap);







        // requestSpecification = (Map<String, Object>) RestAssured.given();
        //requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        //requestSpecification.basePath("booking");
        //requestSpecification.contentType(ContentType.JSON);



        //requestSpecification.body(payload).log().all();

        ////calling put method in URI ,AFTER hitting we get response

        //Response response = requestSpecification.when().post();
       //Integer bookingId= response.then().extract().path("bookingid");

        //validatableResponse = response.then().log().all();
        //validatableResponse.statusCode(200);


        //System.out.println("Your booking id i:" + bookingId);



    }




}
