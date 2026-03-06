package com.sgtesting.RahulShetty;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test
    public void addBook(){
        RestAssured.baseURI="http://216.10.245.166";
       String respose= given().header("Content-Type","application/json")
                .body(getAddress.getAddBook())
                .when().post("http://216.10.245.166/Library/Addbook.php")
                .then().log().all().statusCode(200)
                .extract().response().asString();
       JsonPath js=ReusableMethods.rawToJson(respose);
       String Id=js.getString("ID");
        System.out.println(Id);
    }

    }

//"Content-Type","application/json"