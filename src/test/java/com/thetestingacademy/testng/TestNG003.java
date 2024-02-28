package com.thetestingacademy.testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {
    String token;
    Integer bookingId;


    public String getToken()
    {
        token = "123";
        return token;
    }

    @BeforeTest
    public void getTokenandBookingId(){
        getToken();
        bookingId=123;

    }


    @Test
    public void testPutRequest(){
        System.out.println(token);
        System.out.println(bookingId);
    }









}
