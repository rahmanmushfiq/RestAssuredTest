package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SimplePostTest {
    public void UserRegistration() {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("First Name", "Mushfiq");
        requestParams.put("Last Name", "Rahman");
        requestParams.put("UserName", "ToolsQA");
        requestParams.put("Password", "TestPassword");
        requestParams.put("Email", "mfrahman@iquantile.com");

        request.body(requestParams.toJSONString());
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");


    }
}
