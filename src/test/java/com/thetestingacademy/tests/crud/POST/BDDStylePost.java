package com.thetestingacademy.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePost {
    //Post Request
    //headers,url,payload,contenttype
  @Test
    public void testBDDStylePost(){


        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        //Hashmap,class


        RestAssured.
                given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType(ContentType.JSON).log().all()
                .body(payload)

                .when().post().

                then().log().all().statusCode(200);
    }


}
