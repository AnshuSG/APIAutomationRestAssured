package com.thetestingacademy.testng;

import org.testng.annotations.Test;

public class TestNG006 {
    @Test(priority = 2)
    public void t1(){
        System.out.println("t1");
    }

    @Test(priority = 1)
    public void t2(){
        System.out.println("t2");
    }

    @Test(priority = 3)
    public void t3(){
        System.out.println("t3");
    }
}
