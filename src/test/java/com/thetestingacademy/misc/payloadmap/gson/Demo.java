package com.thetestingacademy.misc.payloadmap.gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class Demo {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    //payload
    //strin -no
    //hashmap -no
    //pojo classes- yes

// {
//    "firstname" : "Anshu",
//     "lastname":"G",
//    "totalprice" : 1000,
//    "depositpaid" : true,
//    "bookingdates" : {
//        "checkin" : "2018-01-01",
//        "checkout" : "2019-01-01"
//    },
//    "additional needs" : "Breakfast"
//}


@Test
public void testPost(){


    Booking booking = new Booking();
    booking.setFirstname("Surekha");
    booking.setLastname("Ganti");
    booking.setTotalprice(1000);
    booking.setDepositpaid(true);

    Bookingdates bookingdates =  new Bookingdates();
    bookingdates.setCheckin("2018-01-01");
    bookingdates.setCheckout("2019-01-01");
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds("Breakfast");

    System.out.println(booking);






//    requestSpecification = RestAssured.given();
//    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
//    requestSpecification.basePath("booking");
//    requestSpecification.contentType(ContentType.JSON);
//
//
//    requestSpecification.body(payload).log().all();
//
//    //calling put method in URI ,AFTER hitting we get response
//
//    Response response = requestSpecification.when().post();
//
//
//    validatableResponse = response.then().log().all();
//    validatableResponse.statusCode(200);

}









}
