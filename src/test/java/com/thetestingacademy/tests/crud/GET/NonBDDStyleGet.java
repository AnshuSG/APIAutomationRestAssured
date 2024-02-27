package com.thetestingacademy.tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGet {

    public static void main(String[] args) {

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful.booker.com");
        r.basePath("booking/3072").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);


        //Testing framework allows to execute multiple test cases
        //1 main - will execute all test cases






    }

}
