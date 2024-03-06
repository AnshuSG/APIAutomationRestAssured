package com.thetestingacademy.misc.payloadmap.gson.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

public class SimpleSer {
   //Object->Json String  Ser(client to server)

    @Test
    public void test1(){

        Employee employeeObject = new Employee();
        employeeObject.setFirstName("SG");
        employeeObject.setLastName("Ganti");
        employeeObject.setEmail("Ganti@gmail.com");
        employeeObject.setHireDate("2012-01-02");
        employeeObject.setEmployeeId(212);

        //crete a gson object
        Gson gson = new Gson();
        String jsonEmployee = gson.toJson(employeeObject);
        System.out.println(jsonEmployee);

        Gson gsonbuilder = new GsonBuilder().setPrettyPrinting().create();
        String employeeJsonstringUsingBuilder = gsonbuilder.toJson(employeeObject);
        System.out.println(employeeJsonstringUsingBuilder);







    }


}
