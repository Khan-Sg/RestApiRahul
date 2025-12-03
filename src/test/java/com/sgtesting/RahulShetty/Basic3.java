package com.sgtesting.RahulShetty;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Basic3 {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(getAddress.addBody())
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("status", equalTo("OK"))
                .body("place_id", notNullValue())  // ensures place_id exists
                .header("Server", notNullValue()); // ensures Server header exists
        //add place
        RestAssured.baseURI="https://rahulshettyacademy.com";
       String response= given().header("Content-Type","application/json")
                .body(getAddress.addBody())
                .when().post("/maps/api/place/add/json")
                .then()
//        .log().all()
               .assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
        System.out.println(response);
        JsonPath js=new JsonPath(response);//parsing jason
        String placeId=js.getString("place_id");
        System.out.println(placeId);
        //update place with new address and check new address validation
        //updateplace
//        String newAddress="summer walk,holavanhalli";
//        given().log().all().queryParam("key","qaclick123").header("Content-Type",
//                        "application/json").body("{\\n\" +\n" +
//                        "          \"  \\\"place_id\\\": \\\"\" + placeId + \"\\\",\\n\" +\n" +
//                        "          \"  \\\"address\\\": \\\"\" + newAddress + \"\\\",\\n\" +\n" +
//                        "          \"  \\\"key\\\": \\\"qaclick123\\\"\\n\" +\n" +
//                        "          \"}")
//                .when().put("/maps/api/place/update/json")
//                .then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
        String newAddress = "summer walk, holavanhalli";
        given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"place_id\": \"" + placeId + "\",\n" +
                        "  \"address\": \"" + newAddress + "\",\n" +
                        "  \"key\": \"qaclick123\"\n" +
                        "}")
                .when()
                .put("/maps/api/place/update/json")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .body("msg", equalTo("Address successfully updated"));


        String getplaceResponse=given().log().all().queryParams("key","qaclick123")
           .queryParams("place_id",placeId)
           .when().get("/maps/api/place/get/json")
           .then().assertThat().statusCode(200).log().all().extract().response().asString();
JsonPath js1=ReusableMethods.rawToJson(getplaceResponse);
String actualAddress=js1.getString("address");
        System.out.println(getplaceResponse);
        Assert.assertEquals("actualAddress","newAddress");
    }
}


