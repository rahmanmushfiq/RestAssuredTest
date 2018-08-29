package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest {

    @Test()
    public void GetWeatherDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        // Get the RequestSpecification of the request that we want to send
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.

        Response response = httpRequest.request(Method.GET, "/Dhaka");

        //Header name, Content type
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

        //Header name, server type
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);

        //Header name, content encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding value: " + acceptLanguage);

        //Get all headers
        Headers allHeader = response.headers();

        //Iterate over all the headers
        for (Header header : allHeader) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }

        //Get the status line and code
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        //Assert the returned value
        Assert.assertEquals(statusCode, 200, "Correct status code returned");

//        String responseBody = response.getBody().asString();
        System.out.println("Status Line is: " + statusLine + "\n Response Body is => " + response.asString());

    }
}
