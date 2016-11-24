package Workshop06;

/**
 * Created by Söp on 2016.11.16..
 */

import com.greenfox.bx.*;

import java.util.ArrayList;
import java.util.Comparator;


public class CompareReservations {
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

        System.out.println("**************************now I'm sorting by reservation code, ascending****************************");

        bookings.sort(reservationNumberComparator);
        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }

        System.out.println("**************************now I'm sorting by reservation code, descending****************************");

        bookings.sort(reservationNumberComparator.reversed());
        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }

        System.out.println("**************************now I'm sorting by credit card number, ascending****************************");

        bookings.sort(creditCardNumberComparator);
        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }

        System.out.println("**************************now I'm sorting by credit card number, descending****************************");

        bookings.sort(creditCardNumberComparator.reversed());
        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }

        System.out.println("**************************now I'm sorting by credit card number, ascending****************************");

        bookings.sort(reservationDayComparator);
        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }

        System.out.println("**************************now I'm sorting by credit card number, descending****************************");

        bookings.sort(reservationDayComparator.reversed());
        for (CreditCardReservation iBooking : bookings) {
            System.out.println(iBooking.toString());
        }
    }

    public static Comparator<CreditCardReservation> reservationNumberComparator = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String left = res1.getReservation().getCodeBooking().toUpperCase();
            String right = res2.getReservation().getCodeBooking().toUpperCase();
            return left.compareTo(right);
        }
    };

    public static Comparator<CreditCardReservation> reservationDayComparator = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String left = Integer.toString(res1.getReservation().dayToNumber());
            String right = Integer.toString(res2.getReservation().dayToNumber());
            return left.compareTo(right);
        }
    };

    public static Comparator<CreditCardReservation> creditCardNumberComparator = new Comparator<CreditCardReservation>() {
        public int compare (CreditCardReservation res1, CreditCardReservation res2) {
            String left = res1.getCreditCard().getCodeAccount().toUpperCase();
            String right = res2.getCreditCard().getCodeAccount().toUpperCase();
            return left.compareTo(right);
        }
    };


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
