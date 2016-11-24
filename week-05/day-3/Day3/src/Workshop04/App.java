package Workshop04;

/**
 * Created by Söp on 2016.11.16..
 */

import com.greenfox.bx.*;

import java.util.ArrayList;

public class App {
    final static String[] lsDow = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        ArrayList<CreditCardReservation> bookings = new ArrayList<CreditCardReservation>();
        int ct = 10;

        for (int i = 0; i < ct; i++) {
            bookings.add(new CreditCardReservation(new Reservation(randomDow(10)), new CreditCard(0, "DEF" + i, random16())));
        }

        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }
    }

    static String random16() {
        String out = "";
        for (int i = 0; i < 16; i++) {
            out += Integer.toString((int) (Math.random() * 9));
        }

        return out;
    }

    static String randomDow(int ct) {
        return lsDow[(int) (Math.random() * 6)];
    }
}
