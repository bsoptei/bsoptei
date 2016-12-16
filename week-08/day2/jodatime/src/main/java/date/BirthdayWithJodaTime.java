package date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Scanner;

/**
 * Created by kicsen on 2016. 11. 30.. It's joda time
 */
public class BirthdayWithJodaTime implements BirthdayCalculator<LocalDate> {


    public LocalDate parseDate(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException();
        }
        return new LocalDate(str);
    }


    public String printMonthAndDay(LocalDate date) {
        return String.format("%d. %d.", date.getMonthOfYear(), date.getDayOfMonth());
    }


    public boolean isAnniversaryToday(LocalDate date) throws NullPointerException {
        if (date == null) {
            throw new NullPointerException();
        }
        LocalDate currentDate = new LocalDate();
        return (currentDate.getDayOfMonth() == date.getDayOfMonth()
                && currentDate.getMonthOfYear() == date.getMonthOfYear());
    }


    public int calculateAgeInYears(LocalDate birthday) throws NullPointerException {
        if (birthday == null) {
            throw new NullPointerException();
        }
        LocalDate currentDate = new LocalDate();

        return currentDate.getYear() - birthday.getYear();
    }


    public int calculateDaysToNextAnniversary(LocalDate date) throws NullPointerException {
        if (date == null) {
            throw new NullPointerException();
        }
        LocalDate currentDate = new LocalDate();
        int currentDay = currentDate.getDayOfYear();
                int day = (date.getYear() % 4 == 0 && date.getMonthOfYear() > 2) ? date.getDayOfYear() : date.getDayOfYear()+ 1;
        if (day > currentDay) {
            return day - currentDay;
        } else if (day < currentDay) {
            return day - currentDay + 365;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        new BirthdayWithJodaTime().run();
    }

    private void run() {

        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        LocalDate birthdayDate = parseDate(birthdayStr);
        print("Your birthday: " + printMonthAndDay(birthdayDate));

        if (isAnniversaryToday(birthdayDate)) {
            int ageInYears = calculateAgeInYears(birthdayDate);
            print("Congratulations! Today is your " + ageInYears + "th birthday!");
        } else {
            int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
            print("You have to wait only " + daysLeft + " days for your next birthday.");
        }
//        java.util.Date juDate = new Date();
//        DateTime dt = new DateTime(juDate);
//        System.out.println(dt);
//        DateTime dt2 = new DateTime();
//        int month = dt2.getMonthOfYear();  // where January is 1 and December is 12
//        int year = dt2.getYear();
//
//
//        System.out.println(dt2);
//        System.out.println(month);
//        System.out.println(year);
//
//        DateTime dt3 = new DateTime();
//        DateTime year2000 = dt3.withYear(2000);
//        DateTime twoHoursLater = dt3.plusHours(2);
//
//        System.out.println(dt3);
//        System.out.println(year2000);
//        System.out.println(twoHoursLater);
//
//
//        DateTime dt4 = new DateTime();
//        String monthName = dt4.monthOfYear().getAsText();
//        String frenchShortName = dt4.monthOfYear().getAsShortText(Locale.FRENCH);
//        boolean isLeapYear = dt4.year().isLeap();
//        DateTime rounded = dt4.dayOfMonth().roundFloorCopy();
//
//        System.out.println(dt4);
//        System.out.println(monthName);
//        System.out.println(frenchShortName);
//        System.out.println(isLeapYear);
//        System.out.println(rounded);

    }

    private void print(String line) {
        System.out.println(line);
    }

    private String readInput(String message) {
        System.out.print(message + ": ");
        return input.nextLine();
    }

    private final Scanner input = new Scanner(System.in, "UTF-8");
}
