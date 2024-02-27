package com.thetestingacademy.tests.crud.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {

//Get Request - https://api.zippopotam.us/IN/500035
        //Url
        //Header?
        //Get Method
        //baseurl - https://api.zippopotam.us
        //basepath - /IN/500035
        //Payload - No
        //Auth - Basic,digest,JMT, BT, Oauth 2.0 ? - No



        //Status Code
        //response body
        //Time, Headers,Cookies

        //Gherkin - given,when, then
        //BDD - framework uses gherkin syntax

        //RestAssured.given().when().then()  -  DSL

  //given
        //Url
        //Header?
        //baseurl - https://api.zippopotam.us
        //basepath - /IN/500035
       //Auth - Basic,digest,JMT, BT, Oauth 2.0 ? - No
// when
        //Payload - No
        //Get Method
 //then
        //validation
        //Status Code
        //response body
        //Time, Headers,Cookies

        RestAssured.given()
                .baseUri("https://api.zippopotam.us").basePath("/IN/500035")

                .when().log().all()
                .get()

                .then().log().all().statusCode(201);




    }

}
