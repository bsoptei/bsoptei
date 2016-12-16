package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public final class BirthdayWithJavaUtilDate implements BirthdayCalculator<Date> {
    private final ArrayList<Integer> numberOfDaysInMonth = new ArrayList<>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31));

    public Date parseDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }


    public String printMonthAndDay(Date date) {
        return String.format("%d. %d.", date.getMonth() + 1, date.getDate());
    }

    public boolean isAnniversaryToday(Date date) {
        Date currentDate = new Date();
        return (currentDate.getDate() == date.getDate() && currentDate.getMonth() == date.getMonth());
    }


    public int calculateAgeInYears(Date birthday) {
        Date currentDate = new Date();
        return (currentDate.getDate() < birthday.getDate()) ?
                currentDate.getYear() - birthday.getYear() - 1
                : currentDate.getYear() - birthday.getYear();
    }


    public int calculateDaysToNextAnniversary(Date date) {
        Date currentDate = new Date();
        int currentDay = getDayOfYear( currentDate);
        int day = getDayOfYear(date) ;
        if (day > currentDay) {
            return day - currentDay;
        } else if (day < currentDay) {
            return day - currentDay + 365;
        } else {
            System.out.println(0);
            return 0;
        }
//        if (currentDate.getDate() > date.getDate()) {
//            return  (currentDate.getMonth() - date.getMonth())*30 + currentDate.getDate() - date.getDate();
//        } else if (currentDate.getDate() == date.getDate()) {
//            return 364;
//        } else {
//            return 0;
//        }
    }

    public static void main(String[] args) throws ParseException {
        new BirthdayWithJavaUtilDate().run();
    }

    private void run() throws ParseException {
        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        Date birthdayDate = parseDate(birthdayStr);
        print("Your birthday: " + printMonthAndDay(birthdayDate));

        if (isAnniversaryToday(birthdayDate)) {
            int ageInYears = calculateAgeInYears(birthdayDate);
            print("Congratulations! Today is your " + ageInYears + "th birthday!");
        } else {
            int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
            print("You have to wait only " + daysLeft + " days for your next birthday.");
        }
    }

    private void print(String line) {
        System.out.println(line);
    }

    private String readInput(String message) {
        System.out.print(message + ": ");
        return input.nextLine();
    }

    private final Scanner input = new Scanner(System.in, "UTF-8");


    int getDayOfYear(Date dateToProcess) {
        int sum = 0;
        for (int i = 0; i <= dateToProcess.getMonth(); i ++) {
            sum += numberOfDaysInMonth.get(i);
        }
        sum += dateToProcess.getDate();
        return sum;
    }
}
