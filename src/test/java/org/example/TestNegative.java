package org.example;

import org.example.RequestsBooker;
import org.junit.Test;

public class TestNegative {
    String bodyUserAndPasswordWrong = "{\n" +
            "    \"username\" : \"adminWrong\",\n" +
            "    \"password\" : \"password123Wrong\"\n" +
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

    String bodyCreateAndGetBookingWrong = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +

            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";




    @Test
    public void createToken(){
        String tokenBooking = RequestsBooker.getTokenOutput(bodyUserAndPasswordWrong);
        System.out.println("токен пользователя - "+tokenBooking);
    }

    @Test
    public void createBooking(){
        String createdBooking = RequestsBooker.createBooking(bodyCreateAndGetBookingWrong);
        System.out.println("ID Booking - "+createdBooking);

        String getBooking = RequestsBooker.getBooking(createdBooking, 500);
        System.out.println("getBooking test - "+getBooking);

    }
    @Test
    public void getBooking(){
        String getBooking = RequestsBooker.getBooking(String.valueOf(1243421), 404);
        System.out.println("getBooking test - "+getBooking);

    }


    @Test
    public void deleteBooking(){
        String createdBooking = RequestsBooker.createBooking(bodyCreateAndGetBookingWrong);
        System.out.println("ID Booking - "+createdBooking);

        String tokenBooking = RequestsBooker.getTokenOutput(bodyUserAndPasswordWrong);
        System.out.println("токен пользователя - "+tokenBooking);


        String deleteBooking = RequestsBooker.deleteBooking(tokenBooking, String.valueOf(375777772), 404);
        System.out.println("Test deleteBooking"+ deleteBooking);
    }
}
