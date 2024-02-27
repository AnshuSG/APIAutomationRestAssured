package com.thetestingacademy.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequestNonBDDTestNG {

    //TestNG ADD
 @Test
    void testGetallBookingPositive(){


     RequestSpecification r = RestAssured.given();
     r.baseUri("https://restful-booker.herokuapp.com/");
     r.basePath("booking/3").log().all();
     r.when().get();
     r.then().log().all().statusCode(200);
    }


    @Test
    void testGetallBookingNegative(){


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);


    }

    @Test
    void testGetallBookingNegative2(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking/abc").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);



    }
}
