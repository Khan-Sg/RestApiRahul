package com.sgtesting.SgServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Sample1 {
    public static void main(String[] args) {
        RestAssured.baseURI="http://localhost:9090";
        given().log().all().header("Content-Type","\t\n" +
                "application/json").body("{\n" +
                "        \"id\": 956,\n" +
                "        \"employeeFirstName\": \"Irshad\",\n" +
                "        \"employeeLastName\": \"A P\",\n" +
                "        \"jobName\": \"Front End Developer\",\n" +
                "        \"emailId\": \"irshad@gmail.com\",\n" +
                "        \"age\": 45,\n" +
                "        \"contactNumber\": 9012345699,\n" +
                "        \"salary\": 49000.0,\n" +
                "        \"departmentName\": \"UI Developer\",\n" +
                "        \"cityName\": \"Mumbai\",\n" +
                "        \"address\": \"7th Stage, 4th Phase Mubmai\",\n" +
                "        \"createdAt\": \"2025-06-29T03:13:17.138+00:00\",\n" +
                "        \"updatedAt\": \"2025-06-29T03:13:17.138+00:00\"\n" +
                "    }").when().post("/sgtesting/api/v1/employees")
                .then().assertThat().statusCode(201);

    }
}
