package com.thetestingacademy.testng.DDT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class HWDDT02 {


    int id;
    int Statuscode;
    String Statusmessage;

    @Test(dataProvider = "getData" ,  dataProviderClass =  UtilExcel.class)
    public void testLogin(String Username,String Password)
    {
       String payload = "{\n" +
               "  \"username\": \"gantianshu@gmail.com\",\n" +
               "  \"password\": \"G@123nshu\",\n" +
               "  \"remember\": false,\n" +
               "  \"recaptcha_response_field\": \"\"\n" +
               "}\n";

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://app.vwo.com");
        requestSpecification.basePath("/login");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        Response response =requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        Integer  id = response.then().extract().path("id");
        System.out.println(id);

        assertThat(id).isNotNull();

        Assert.assertNotNull(id);
        //Statuscode 200
        Statuscode=validatableResponse.extract().statusCode();
        Statusmessage=validatableResponse.extract().statusLine();
        System.out.println(Statusmessage);
        System.out.println(Statuscode);
        //if(id>0)
        Assert.assertEquals(Statuscode,200);
        // else
        //Assert.assertEquals(Statuscode,401);





    }

}
