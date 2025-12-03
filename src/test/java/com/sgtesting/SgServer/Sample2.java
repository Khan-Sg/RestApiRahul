package com.sgtesting.SgServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Sample2 {
    public static void main(String[] args) {
        RestAssured.baseURI="http://localhost:9090";
        given().log().all()
                .header("Transfer-Encoding", "chunked")
                .body(Body.getBody())
                .when().get("/sgtesting/api/v1/employees")
                        .then().statusCode(200).body("[0].employeeFirstName", equalTo("Chetan A"));  // <-- FIXED
    }
}
