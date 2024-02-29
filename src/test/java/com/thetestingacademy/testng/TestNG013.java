package com.thetestingacademy.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG013 {

    //Data Driven testing
    // test with multiple users
    //login DDT
    //Registration page DDT

    //Data Provider-- Test Data?

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
            new Object[]{"admin","admin"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password123"},

        };
    }



    @Test(dataProvider = "getData")
    public void loginTest(String username,String password){
        System.out.println(username);
        System.out.println(password);
    }






}
