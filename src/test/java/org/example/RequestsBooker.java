package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestsBooker {

    public static String getTokenOutput(String recBody){

        String responsePost = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .body(recBody)
                .log().body(true)
                .contentType(ContentType.JSON)
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .statusCode(200)
                .extract()
                .response().asString().substring(10,25);

        //System.out.println(responsePost.substring(10,25));
        System.out.println(responsePost);
        return responsePost;
    }


    public static String createBooking(String recBody){
        String responsePost = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .body(recBody)
                .log().body(true)
                .contentType(ContentType.JSON)
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .extract()
                .response().path("bookingid").toString();
        System.out.println("createBooking = "+responsePost);
        return responsePost;
    }


    public static String getBooking(String createBooking, Integer statusCod){
        String responsePost = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking/"+createBooking)

                .log().body(true)
                .contentType(ContentType.JSON)
                .get("https://restful-booker.herokuapp.com/booking/"+createBooking)
                .then()
                .statusCode(statusCod)
                .extract()
                .response().toString();

        System.out.println("getBooking - " +responsePost);
        return responsePost;
    }




    public static String putBooking(String recBody,String tokenAut, String createBooking){
        String responsePost = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking/"+createBooking)

                .headers("Cookie","token="+tokenAut)

                .body(recBody)
                .log().body(true)
                .contentType(ContentType.JSON)
                .put("https://restful-booker.herokuapp.com/booking/"+createBooking)
                .then()
                .statusCode(200)
                .extract()
                .response().asString();

        System.out.println("RB putBooking = "+responsePost);
        return responsePost;
    }

    public static String deleteBooking(String tokenAut, String createBooking, Integer stacusCod){
        String responsePost = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking/")
                .headers("Cookie","token="+tokenAut)
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/"+createBooking)
                .then()

                .log().body(true)
                .statusCode(stacusCod)
                .extract()
                .response().asString();


        System.out.println("RB deleteBooking "+responsePost);
        return responsePost;
    }
}
