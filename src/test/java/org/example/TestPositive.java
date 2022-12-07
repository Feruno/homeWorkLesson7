package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class TestPositive {

    String bodyUserAndPassword = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    String bodyCreateAndGetBooking = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    String bodyPutBooking = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2020-11-11\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";




    @Test
    public void createToken(){
        String tokenBooking = RequestsBooker.getTokenOutput(bodyUserAndPassword);
        System.out.println("токен пользователя - "+tokenBooking);
    }

    @Test
    public void createBooking(){
        String createdBooking = RequestsBooker.createBooking(bodyCreateAndGetBooking);
        System.out.println("ID Booking - "+createdBooking);

        String getBooking = RequestsBooker.getBooking(createdBooking, 200);
        System.out.println("getBooking test - "+getBooking);

    }

    @Test
    public void putBooking(){
        String createdBooking = RequestsBooker.createBooking(bodyCreateAndGetBooking);
        System.out.println("ID Booking - "+createdBooking);

        String tokenBooking = RequestsBooker.getTokenOutput(bodyUserAndPassword);
        System.out.println("токен пользователя - "+tokenBooking);

        String putBooking = RequestsBooker.putBooking(bodyPutBooking, tokenBooking, createdBooking);
        System.out.println("Test putBooking = " +putBooking);
    }

    @Test
    public void deleteBooking(){
        String createdBooking = RequestsBooker.createBooking(bodyCreateAndGetBooking);
        System.out.println("ID Booking - "+createdBooking);

        String tokenBooking = RequestsBooker.getTokenOutput(bodyUserAndPassword);
        System.out.println("токен пользователя - "+tokenBooking);


        String deleteBooking = RequestsBooker.deleteBooking(tokenBooking, createdBooking, 200);
        System.out.println("Test deleteBooking"+ deleteBooking);
    }

}
