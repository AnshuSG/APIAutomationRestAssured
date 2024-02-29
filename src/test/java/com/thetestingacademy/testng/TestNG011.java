package com.thetestingacademy.testng;

import org.testng.annotations.Test;

public class TestNG011 {
    @Test(groups = {"init"},priority = 1)
    public void getToken(){
        System.out.println("ServerStarted");
    }


    @Test(groups = {"init"},priority = 2)
    public void getbookingId(){
        System.out.println("init");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void testPutRequest(){
        System.out.println("Method1");
    }

}
