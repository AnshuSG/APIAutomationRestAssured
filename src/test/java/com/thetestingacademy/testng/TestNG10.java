package com.thetestingacademy.testng;

import org.testng.annotations.Test;

public class TestNG10 {
    @Test
    public void serverStartedOK(){
        System.out.println("serverStartedOK");
    }

    @Test(dependsOnMethods = "serverStartedOK")
    public void Method1(){
        System.out.println("Method1");
    }






}
