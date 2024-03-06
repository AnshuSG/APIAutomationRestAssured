package com.thetestingacademy.misc.payloadmap.gson;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.misc.payloadmap.gson.example.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class POSTReqTC {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPositive(){
        //step1 - POST
        //Url
        //Header
        //BODY
        //Auth - no

        //step2
        //Prepare the payload(object to json string)
        // send the request


        //Step3
        //Validate Response(Json String - object)
        //Firstname
        //Status code
        //Time response

   //prepare your payload

        Faker faker = new Faker();


        Booking booking = new Booking();
        String expectedFirstName = faker.name().firstName();
        booking.setFirstname(expectedFirstName);
        booking.setLastname("Ganti");
        booking.setTotalprice(1000);
        booking.setDepositpaid(true);

        Bookingdates bookingdates =  new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");



      //Object -> Json string

        Gson gson = new Gson();
        String jsonStringbooking = gson.toJson(booking);










        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);



        requestSpecification.body(jsonStringbooking).log().all();

        ////calling put method in URI ,AFTER hitting we get response

        Response response = requestSpecification.when().post();
        String jsonresponsestring = response.asString();
       // Integer bookingId= response.then().extract().path("bookingid");
        System.out.println(jsonresponsestring);
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Validate Object
        BookingResponse  bookingresponseObject  = gson.fromJson(jsonresponsestring,BookingResponse.class);
         assertThat(bookingresponseObject.getBookingid()).isNotNull();



        System.out.println(bookingresponseObject);
        Assert.assertEquals(bookingresponseObject.getBooking().getFirstname(),expectedFirstName);
        //Assert.assertEquals(bookingresponseObject.getLastname(),"Ganti");


        //AssertJ
        assertThat(bookingresponseObject.getBooking().getFirstname()).isEqualTo(expectedFirstName).isNotEmpty();





        //System.out.println("Your booking id i:" + bookingId);







    }

}
