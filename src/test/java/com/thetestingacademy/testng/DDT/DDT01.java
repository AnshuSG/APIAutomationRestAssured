package com.thetestingacademy.testng.DDT;

import org.testng.annotations.Test;

public class DDT01 {


  @Test(dataProvider = "getData" ,  dataProviderClass =  UtilExcel.class)
    public void testLogin(String Username,String Password)
    {
        System.out.println(Username);
        System.out.println(Password);
    }
}
