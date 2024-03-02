package com.thetestingacademy.testng.DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {

    //Test data -  from the excel file- data provider
    //Read the excel file - Apache POI -60 to 70% use this
    //  Fillo library


    // test case login where we will inject the username and password
  //to  read from excel file Apache POI


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
