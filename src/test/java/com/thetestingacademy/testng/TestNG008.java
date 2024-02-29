package com.thetestingacademy.testng;

import groovy.json.JsonOutput;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG008 {

    @Test
    void testcase01(){
        //softassertions
       // SoftAssert s= new SoftAssert();
        //s.assertEquals(true,false);
       // System.out.println("please execute me");
       // s.assertAll();

        //Hard Assertions
        Assert.assertEquals(true,false);
        System.out.println("This will not print");


    }
}
