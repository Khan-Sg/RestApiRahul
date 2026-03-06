package com.sgtesting.RahulShetty;

import io.restassured.RestAssured;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class StaticJason {
    public static void main(String[] args) throws IOException {
        RestAssured.baseURI="http://216.10.245.166";
    String response=    given().log().all().queryParam("key","qaclick123")
            .header("Content-Type","application/json")
            .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Admin\\Downloads\\Library+API.postman_collection (2).json")))).when().post("/maps/api/place/add/json").then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .body("status", equalTo("APP"))
            .extract().response().asString();
        System.out.println(response);

    }
}