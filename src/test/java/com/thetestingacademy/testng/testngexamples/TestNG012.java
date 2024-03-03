package com.thetestingacademy.testng.testngexamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG012 {

    @Parameters("browser")
    @Test
    public void paramsmethod(String value){
        System.out.println("Browser is " + value);
    }



}
