package com.thetestingacademy.misc.payloadmap.gson.example;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeSer {

    @Test
    public void DeserializationTest(){
  String JsonString = "{\"employeeId\":212,\"firstName\":\"SG\",\"lastName\":\"Ganti\",\"email\":\"Ganti@gmail.com\",\"hireDate\":\"2012-01-02\"}";

  Gson gson = new Gson();
  Employee employeeObject  = gson.fromJson(JsonString,Employee.class);

    String firstname= employeeObject.getFirstName();
    String lastname = employeeObject.getLastName();

        Assert.assertEquals(firstname,"SG");


    }
}
