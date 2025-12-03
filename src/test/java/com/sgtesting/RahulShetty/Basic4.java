package com.sgtesting.RahulShetty;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Basic4 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // -----------------------------
        // 1️⃣ Add a new place
        // -----------------------------
        String addPlaceResponse = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(getAddress.addBody()) // Your JSON payload
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("status", equalTo("OK"))
                .body("place_id", notNullValue())
                .extract().response().asString();

        // Parse response to get place_id
        JsonPath jsAdd = new JsonPath(addPlaceResponse);
        String placeId = jsAdd.getString("place_id");
        System.out.println("Place ID: " + placeId);

        // -----------------------------
        // 2️⃣ Update the place with new address
        // -----------------------------
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

        // -----------------------------
        // 3️⃣ Get the place and verify the new address
        // -----------------------------
        String getPlaceResponse = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get("/maps/api/place/get/json")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract().response().asString();

        // Parse GET response
        JsonPath jsGet = new JsonPath(getPlaceResponse);
        String actualAddress = jsGet.getString("address");
        System.out.println("Actual Address: " + actualAddress);

        // -----------------------------
        // 4️⃣ Verification
        // -----------------------------
        if (newAddress.equals(actualAddress)) {
            System.out.println("✅ Address updated successfully!");
        } else {
            System.out.println("❌ Address update failed.");
        }
    }
}
