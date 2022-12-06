import org.example.RequestsBooker;
import org.junit.Test;

public class TestNegative {
    String bodyUserAndPasswordWrong = "{\n" +
            "    \"username\" : \"adminWrong\",\n" +
            "    \"password\" : \"password123Wrong\"\n" +
            "}";

    String bodyCreateAndGetBookingWrong = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +

            "    \"bookingdates\" : {\n" +
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

        String getBooking = RequestsBooker.getBookingWrong(createdBooking, bodyCreateAndGetBookingWrong);
        System.out.println("getBooking test - "+getBooking);

    }


    @Test
    public void deleteBooking(){
        String createdBooking = RequestsBooker.createBooking(bodyCreateAndGetBookingWrong);
        System.out.println("ID Booking - "+createdBooking);

        String tokenBooking = RequestsBooker.getTokenOutput(bodyUserAndPasswordWrong);
        System.out.println("токен пользователя - "+tokenBooking);


        String deleteBooking = RequestsBooker.deleteBooking(tokenBooking, createdBooking);
        System.out.println("Test deleteBooking"+ deleteBooking);
    }
}
