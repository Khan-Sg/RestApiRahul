package com.sgtesting.RahulShetty;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class JasonPath {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(getAddress.getBookPrice())
                .when();
    }
}
