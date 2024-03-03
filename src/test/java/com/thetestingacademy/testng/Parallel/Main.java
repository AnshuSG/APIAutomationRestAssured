package com.thetestingacademy.testng.Parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {


  @BeforeMethod
    public void  BeforeMethod(){

      long id = Thread.currentThread().getId();
      System.out.println("Before Test method .Thread is :" + id  + getClass().getSimpleName());
    }

    @Test
    public void  testMethod1(){
        long id = Thread.currentThread().getId();
        System.out.println("Test method1 .Thread is :" + id  + getClass().getSimpleName());
    }


    @Test
    public void  testMethod2(){
        long id = Thread.currentThread().getId();
        System.out.println("Test method2 .Thread is :" + id  + getClass().getSimpleName());
    }


    @AfterMethod
    public void  AfterMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("After Method .Thread is :" + id  + getClass().getSimpleName());
    }

}
